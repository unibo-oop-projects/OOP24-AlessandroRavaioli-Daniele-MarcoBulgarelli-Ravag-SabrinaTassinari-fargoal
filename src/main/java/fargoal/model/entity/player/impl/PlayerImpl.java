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
    private boolean isImmune;

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
        this.isImmune = false;
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

    /**{@inheritDoc}*/
    @Override
    public void setPlayerSkill(final Integer skill) {
        if(skill == null || skill < 0) {
            throw new IllegalArgumentException("The skill cannot be set to a null or negative value.");
        } else {
            this.skill = skill;
        }
    }

    /**{@inheritDoc}*/
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

    /**{@inheritDoc}*/
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

    /** {@inheritDoc} */
    @Override
    public void Render() {
        this.render.render();
    }

    /**{@inheritDoc}*/
    @Override
    public Position getPosition() {
        return this.position;
    }

    /**{@inheritDoc}*/
    @Override
    public Integer getLevel() {
        return this.level;
    }

    /**{@inheritDoc}*/
    @Override
    public Integer getExperiencePoints() {
        return this.experiencePoints;
    }

    /**{@inheritDoc}*/
    @Override
    public Integer getExperiencePointsRequired() {
        return this.experiencePointsRequired;
    }

    /**{@inheritDoc}*/
    @Override
    public void addExperiencePoints(final Integer experiencePointsToAdd) {
        if(experiencePointsToAdd == null || experiencePointsToAdd < 0) {
            throw new IllegalArgumentException("The amount of experience points to add cannot be null nor negative.");
        } else {
            this.experiencePoints += experiencePointsToAdd;
        }
    }

    /**{@inheritDoc}*/
    @Override
    public Health getHealth() {
        return this.health;
    }

    /**{@inheritDoc}*/
    @Override
    public Integer getSkill() {
        return this.skill;
    }

    /**{@inheritDoc}*/
    @Override
    public Integer getCurrentGold() {
        return this.gold.getCurrentGold();
    }

    /**{@inheritDoc}*/
    @Override
    public Integer getMaxGoldCapacity() {
        return this.gold.getMaxCapacity();
    }

    /**{@inheritDoc}*/
    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Retrieves the number of monsters the player has defeated.
     * This method returns the total count of enemies slain by the player.
     * 
     * @return The {@link Integer} representing the number of slain foes.
     */
    public Integer getNumberOfSlainFoes() {
        return this.numberOfSlainFoes;
    }

    /**{@inheritDoc}*/
    @Override
    public Gold getPlayerGold() {
        return this.gold;
    }

    /**{@inheritDoc}*/
    @Override
    public String getTag() {
        return "PLAYER";
    }

    /**{@inheritDoc}*/
    @Override
    public boolean hasSword() {
        return this.hasSword;
    }

    /**
     * Checks if the player is currently engaged in combat.
     * This method returns {@code true} if the player is in a fight, otherwise {@code false}.
     * 
     * @return {@code true} if the player is fighting, {@code false} otherwise.
     */
    public boolean isFighting() {
        return this.isFighting;
    }

    /**
     * Checks if the player has been attacked.
     * This method returns {@code true} if the player has been attacked, otherwise {@code false}.
     * 
     * @return {@code true} if the player has been attacked, {@code false} otherwise.
     */
    public boolean isAttacked() {
        return this.isAttacked;
    }

    /**{@inheritDoc}*/
    @Override
    public void setHasSword(final boolean condition) {
        this.hasSword = condition;
    }

    /**{@inheritDoc} */
    @Override
    public boolean isVisible() {
        return this.isVisible;
    }

    /**{@inheritDoc} */
    @Override
    public void setIsVisible(boolean condition) {
        this.isVisible = condition;
    }

    /**{@inheritDoc} */
    @Override
    public boolean hasLight() {
        return this.hasLight;
    }

    /**{@inheritDoc} */
    @Override
    public void setHasLight(final boolean condition) {
        this.hasLight = condition;
    }

    /**
     * Increases the count of enemies defeated by the player.
     * This method increments the number of slain monsters by one.
     */
    public void increaseNumberOfSlainFoes() {
        this.numberOfSlainFoes ++;
    }

    /**{@inheritDoc}*/
    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    /**{@inheritDoc}*/
    @Override
    public void update(final FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void setIsImmune(Boolean condition) {
        this.isImmune = condition;
    }

    /**
     * Manages the entire fight sequence between the player and the given monster.
     * This method handles the combat mechanics, including attacks, fleeing conditions,
     * and input locking. The battle continues until either the player or the monster is defeated.
     * <p>
     * If the player is moving away from the monster and was the one that started the fight,
     * the battle ends immediately, allowing the player to flee.
     * If the player has been attacked, inputs are locked between turns.
     * Otherwise, the combat continues in an automated fashion.
     * </p>
     * 
     * @param monster - The enemy {@link AbstractMonster} the player is fighting.
     * 
     * @return {@code true} if the player wins the battle, {@code false} if they lose.
     */
    private boolean battle(final AbstractMonster monster) {
        //TODO
        //isFighting = true
        //if isAttacked == false -> Player can flee
        //if isAttacked == true -> player cannot flee
        //for each turn -> doDamage to monster; recieveDamage from monster
        //check isDead (for both sides)
        this.isFighting = true;
        this.stopRegeneration();
        
        do {
            if(isMovingAwayFrom(monster) && !this.isAttacked) {
                this.isFighting = false;
                unlockInputs();
                this.startPasiveRegeneration();
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
        this.startPasiveRegeneration();
        
        return !this.isDead();
    }

    /**
     * Determinies if the player is moving away from the specified monster.
     * This method should check the player's movement direction relative to the monster
     * and return {@code true} if the player is retreating.
     * <p>
     * Currently, this method is not implemented and will throw an
     * {@link UnsupportedOperationException} when called.
     * </p>
     * 
     * @param monster - The {@link AbstractMonster} to check the player's movement against.
     *  
     * @return {@code true} if the player is moving away from the monster, {@code false} otherwise.
     * 
     * @throws UnsupportedOperationException Always thrown, as the method is not yet implemented.
     */
    private boolean isMovingAwayFrom(AbstractMonster monster) {
        throw new UnsupportedOperationException("Unimplemented method 'isMovingAwayFrom'");
    }

    /**
     * Locks all player inputs except for the teleport action.
     * This method is responsible for disabling user interactions during certain events,
     * such as when the player is attacked by an enemy, but still allows the 
     * player to teleport if needed.
     * <p>
     * Currently, this method is not implemented and will throw an
     * {@link UnsupportedOperationException} when called.
     * </p>
     * 
     * @throws UnsupportedOperationException Always thrown, as the method is not yet implemented.
     */
    private void lockInputs() {
        throw new UnsupportedOperationException("Unimplemented method 'lockInputs'");
    }

    /**
     * Unlocks all previously locked player inputs.
     * This method allows the player to resume normal interactions after a period of input restriction,
     * enabling actions like movement, interactions or other player inputs.
     * <p>
     * Currently, this method is not implemented and will throw an
     * {@link UnsupportedOperationException} when called.
     * </p>
     * 
     * @throws UnsupportedOperationException Always thrown, as the method is not yet implemented.
     */
    private void unlockInputs() {
        throw new UnsupportedOperationException("Unimplemented method 'lockInputs'");
    }

    /**{@inheritDoc}*/
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
     * Subtracts health from the player when attacked by a monster.
     * If the player is not protected by a shield spell, the player's health is decreased based on the monster's attack.
     * If the player has a shield spell active, it is deactivated instead of taking damage.
     * 
     * @param monster - The {@link AbstractMonster} that is attacking the player.
     */
    private void receiveDamage(AbstractMonster monster) {
        //if player hasn't shield
        if(!this.inventory.getSpellCasted().get(SpellType.SHIELD.getName())) {
            this.health.decreaseHealth(monster.attack());
        } else {
            this.inventory.getSpellCasted().replace(SpellType.SHIELD.getName(), false);
        }
    }

    /**{@inheritDoc}*/
    @Override
    public boolean isDead() {
        if(inventory.getHealingPotions() == 0){
            return this.health.getCurrentHealth() == 0;
        } else {
            return this.health.getCurrentHealth() < -5;
        }
    }

    /**
     * Initiates the passive health regeneration for the player.
     * The player will regenerate 1 health every 10 seconds, provided they are not fighting and
     * not affected by any regeneration spells.
     * The regeneration occurs at fixed intervals managed by a scheduled task.
     * <p>
     * The method uses a scheduler to execute the regeneration task every 10 seconds.
     * It checks whether the player is in combat (not regenerating during battle) and when the player
     * is under the effect of a regeneration spell.
     * </p>
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

    /**
     * Stops the passive health regeneration by shutting down the scheduler.
     * This method halts the scheduled task responsible for the player's health regeneration.
     * Once invoked, no further health regeneration will occour until the regeneration process is started again.
     * <p>
     * Calling this method will terminate any ongoing regeneration tasks managed by the scheduler.
     * </p>
     */
    public void stopRegeneration() {
        scheduler.shutdown();
    }
}
