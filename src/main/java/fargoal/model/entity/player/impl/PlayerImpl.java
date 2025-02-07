package fargoal.model.entity.player.impl;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.commons.impl.HealthImpl;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.SpellType;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;
import fargoal.model.entity.player.api.Gold;
import fargoal.model.entity.player.api.Inventory;

/**
 * Manages the player's state, actions, and interactions within the game world.
 * This includes handling movement, combat mechanics, health management,
 * inventory operations, and interactions with other entitires.
 * <p>
 * The class also tracks the player's status, such as whether they are engaged
 * in battle, their ability to flee, and the effects of recieved or inflicted damage.
 * </p>
 */
public class PlayerImpl implements Player {

    private static final int CONSTANT_ADDED_TO_MAX_HEALTH_IN_LEVEL_UP = 4;
    private static final int MAX_LEVEL_UP_ADDED_MAX_HEALTH = 15;
    private static final int MIN_LEVEL_UP_ADDED_MAX_HEALTH = 1;
    private static final int INITIAL_EXPERIENCE_POINTS_REQUIRED = 200;
    private static final int INITIAL_STAT_MAX_COUNTER = 3;
    private static final int DAMAGE_MULTIPLIER = 4;
    private static final int MINIMUM_DAMAGE = 1;
    private static final int INITIAL_LEVEL = 1;

    private Position position;
    private Integer level;
    private Integer experiencePoints;
    private Integer experiencePointsRequired;
    private Health health;
    private Integer skill;
    private final Gold gold;
    private final Inventory inventory;
    private Integer numberOfSlainFoes;

    private boolean hasSword;
    private boolean isFighting;
    private boolean isAttacked;
    private boolean isVisible;
    private boolean hasLight;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Renderer render;

    public PlayerImpl() {
        this.level = INITIAL_LEVEL;
        this.experiencePoints = 0;
        this.experiencePointsRequired = INITIAL_EXPERIENCE_POINTS_REQUIRED;
        this.health = new HealthImpl(this.setInitialStat());
        this.skill = setInitialStat();
        this.gold = new GoldImpl();
        this.inventory = new InventoryImpl();
        this.numberOfSlainFoes = 0;
        this.hasSword = false;
        this.isFighting = false;
        this.isAttacked = false;
        this.isVisible = true;
        this.hasLight = false;
    }

    public PlayerImpl(FloorMap floorMap, RenderFactory renderFactory) {
        startingPosition(floorMap);
        this.level = INITIAL_LEVEL;
        this.experiencePoints = 0;
        this.experiencePointsRequired = INITIAL_EXPERIENCE_POINTS_REQUIRED;
        this.health = new HealthImpl(this.setInitialStat());
        this.skill = setInitialStat();
        this.gold = new GoldImpl();
        this.inventory = new InventoryImpl();
        this.numberOfSlainFoes = 0;
        this.hasSword = false;
        this.isFighting = false;
        this.isAttacked = false;
        this.isVisible = true;
        this.hasLight = false;
        this.render = renderFactory.playerRenderer(this);
    }

    /**
     * Sets the renderer responsible for rendering the player.
     * This method allows updating the current rendering engine or system.
     * 
     * @param renderer - The {@link Renderer} instance to be assigned to the player.
     */
    public void setRender(final Renderer renderer) {
        this.render = renderer;
    }

    /**{@inheritDoc} */
    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Sets the player's starting position on the given floor map.
     * The position is determined by selecting a random valid tile from the map.
     * 
     * @param floorMap - The {@link Floormap} instance from which a random tile is chosen.
     */
    private void startingPosition(FloorMap floorMap) {
        Position pos = floorMap.getRandomTile();
        this.setPosition(pos);
    }

    /**
     * Generates the initial stat value by rolling a six-sided die (d6) multiple times.
     * The total value is determined by summing up a series of random d6 rolls.
     * 
     * @return The computed initial stat value as an {@link Integer}.
     */
    private Integer setInitialStat() {
        Integer stat = 0;
        Integer d6;
        for(int i = 0; i <= INITIAL_STAT_MAX_COUNTER; i ++) {
            d6 = new Random().nextInt(1, 6);
            stat = stat + d6;
        }
        return stat;
    }

    /**
     * Sets the player's skill level.
     * The skill value must be a non-null, non-negative integer.
     * 
     * @param skill - The skill level to assign to the player.
     * @throws IllegalArgumentException If the skill value is null or negative.
     */
    @Override
    public void setPlayerSkill(final Integer skill) {
        if(skill == null || skill < 0) {
            throw new IllegalArgumentException("The skill cannot be set to a null or negative value.");
        } else {
            this.skill = skill;
        }
    }

    /**
     * Increases the player's skill by the specified amount.
     * The skill can only be increased if the provided amount is valid.
     * Specifically, the amount must not be null nor negative, as this method 
     * is designed to only increase the skill and not decrease it.
     * 
     * @param amount - The amount by which to increase the player's skill.
     * @throws IllegalArgumentException If the amount is negative or null.
     */
    @Override
    public void increasePlayerSkill(final Integer amount) {
        if(amount == null) {
            throw new IllegalArgumentException("The skill cannot be increased of a null value.");
        } else if(amount < 0) {
            throw new IllegalArgumentException("The skill cannot be decreased with this method.");
        } else {
            this.skill = this.skill + amount;
        }
    }

    /**
     * Checks if the player has enough experience points to level up.
     * The player is considered ready to level up if their current experience points
     * are greater than or equal to the experience points required for the next level.
     * 
     * @return {@code true} if the player has enough experience points to level up,
     *         {@code false} otherwise.
     */
    private boolean isLevellingUp() {
        return this.getExperiencePoints() >= this.getExperiencePointsRequired();
    }

    /**
     * Levels up the player if they have enough experience points.
     * If the player has sufficient experience points, their level is increased,
     * their maximum health is adjusted by a random amount within a specified range,
     * their skill is increased by a random value, and the experience points required
     * for the next level are doubled.
     * <p>
     * If the player does not have enough experience points to level up, an exception is thrown.
     * </p>
     * 
     * @throws IllegalStateException If the player does not have enough experience points to level up.
     */
    @Override
    public void levelUp() {
        if(!this.isLevellingUp()) {
            throw new IllegalStateException("Player does not have enough experience points to level up.");
        } else {
            this.level ++;
            this.health.setMaxHealth(this.health.getMaxHealth() + new Random().nextInt(MIN_LEVEL_UP_ADDED_MAX_HEALTH, MAX_LEVEL_UP_ADDED_MAX_HEALTH) + CONSTANT_ADDED_TO_MAX_HEALTH_IN_LEVEL_UP);
            this.increasePlayerSkill(new Random().nextInt(1, 10));
            this.experiencePointsRequired = this.experiencePointsRequired * 2;
        }
    }

    public Renderer getRenderer() {
        return this.render;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Integer getLevel() {
        return this.level;
    }

    @Override
    public Integer getExperiencePoints() {
        return this.experiencePoints;
    }

    @Override
    public Integer getExperiencePointsRequired() {
        return this.experiencePointsRequired;
    }

    @Override
    public void addExperiencePoints(final Integer experiencePointsToAdd) {
        this.experiencePoints += experiencePointsToAdd;
    }

    @Override
    public Health getHealth() {
        return this.health;
    }

    @Override
    public Integer getSkill() {
        return this.skill;
    }

    @Override
    public Integer getCurrentGold() {
        return this.gold.getCurrentGold();
    }

    @Override
    public Integer getMaxGoldCapacity() {
        return this.gold.getMaxCapacity();
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public Integer getNumberOfSlainFoes() {
        return this.numberOfSlainFoes;
    }

    @Override
    public Gold getPlayerGold() {
        return this.gold;
    }

    @Override
    public String getTag() {
        return "PLAYER";
    }

    @Override
    public boolean hasSword() {
        return this.hasSword;
    }

    public boolean isFighting() {
        return this.isFighting;
    }

    public boolean isAttacked() {
        return this.isAttacked;
    }

    @Override
    public void setHasSword(final boolean condition) {
        this.hasSword = condition;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isVisible() {
        return this.isVisible;
    }

    /** {@inheritDoc} */
    @Override
    public void setIsVisible(boolean condition) {
        this.isVisible = condition;
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasLight() {
        return this.hasLight;
    }

    /** {@inheritDoc} */
    @Override
    public void setHasLight(final boolean condition) {
        this.hasLight = condition;
    }

    @Override
    public void increaseNumberOfSlainFoes(Integer amount) {
        this.numberOfSlainFoes ++;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public void update(final FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /**
     * This method manages the entire fight: it should check if player can and wants to flee
     * it should manage player automatic turn and monster turn and return true if battle
     * is won.
     * 
     * @param monster - The enemy monster.
     * 
     * @return true if player won the battle, false if they lose it.
     */
    private boolean battle(final AbstractMonster monster) {
        //TODO
        //isFighting = true
        //if isAttacked == false -> Player can flee
        //if isAttacked == true -> player cannot flee
        //for each turn -> doDamage to monster; recieveDamage from monster
        //check isDead (for both sides)
        this.isFighting = true;
        
        do {
            if(isMovingAwayFrom(monster)) {
                this.isFighting = false;
                unlockInputs();
                return true;
            }

            if(this.isAttacked) {
                //TODO block the inputs between turns.
                lockInputs();

                //Monster Attack
                this.receiveDamage(monster);

                //Player Attack
                monster.receiveDamage();

            } else {
                //TODO do not block the inputs for the whole fight

                //Player Attack
                monster.receiveDamage();

                //Monster Attack
                this.receiveDamage(monster);

                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }
        } while(!this.isDead() && !monster.isDead());

        unlockInputs();
        
        return !this.isDead();
    }

    private boolean isMovingAwayFrom(AbstractMonster monster) {
        throw new UnsupportedOperationException("Unimplemented method 'isMovingAwayFrom'");
    }

    /**
     * Locks all inputs except from teleport one.
     */
    private void lockInputs() {
        throw new UnsupportedOperationException("Unimplemented method 'lockInputs'");
    }

    private void unlockInputs() {
        throw new UnsupportedOperationException("Unimplemented method 'lockInputs'");
    }

    @Override
    public Integer doDamage(final Monster monster) {
        if(monster == null) {
            throw new IllegalArgumentException("The monster passed to this method can not be null");
        } else {
            int ratio = this.getSkill() / monster.getSkill();
            Random random = new Random();
            return random.nextInt(MINIMUM_DAMAGE, (DAMAGE_MULTIPLIER * this.getLevel() * ratio));
        }
    }

    /**
     * Subtracts player's health from a monster attack.
     * 
     * @param monster - current foe.
     */
    private void receiveDamage(AbstractMonster monster) {
        //if player hasn't shield
        if(!this.inventory.getSpellCasted().get(SpellType.SHIELD.getName())) {
            this.health.decreaseHealth(monster.attack());
        } else {
            this.inventory.getSpellCasted().replace(SpellType.SHIELD.getName(), false);
        }
    }

    /**
     * This method is used to check wether the player character is dead or not.
     * If the player has at least one healing potion and their health is not
     * below a critical limit, then they should be able to automatically use 
     * the healing potion and do not die.
     * 
     * @return true if player is dead, false otherwise.
     */
    @Override
    public boolean isDead() {
        if(inventory.getHealingPotions() == 0){
            return this.health.getCurrentHealth() == 0;
        } else {
            return this.health.getCurrentHealth() < -5;
        }
    }

    /**
     * This method calculates the passive health regeneration of the player.
     * It should be 1 health for 10 t.u.(time unity).
     */
    public void startPasiveRegeneration() {
        Integer amountToRegenerate = 1;
        Runnable regenerationTask = () -> {
            if(!isFighting) {
                //If it isn't on temple
                //If it isn't under the regeneration spell
                this.health.increaseHealth(amountToRegenerate);
            }
        };

        scheduler.scheduleAtFixedRate(regenerationTask, 0, 10, TimeUnit.SECONDS);
    }

    public void stopRegeneration() {
        scheduler.shutdown();
    }
}
