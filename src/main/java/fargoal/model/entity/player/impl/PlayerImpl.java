package fargoal.model.entity.player.impl;

import java.util.Random;
import fargoal.commons.api.Position;
import fargoal.controller.input.api.InputComponent;
import fargoal.controller.input.api.KeyboardInputController;
import fargoal.controller.input.api.PlayerInputComponent;
import fargoal.model.commons.Timer;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.commons.impl.HealthImpl;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.events.impl.BattleEvent;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.interactable.pickupable.inside_chest.spell.api.SpellType;
import fargoal.model.interactable.temple.Temple;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.Renderer;
import fargoal.view.impl.InventoryInformationRenderer;
import fargoal.view.impl.PlayerInformationRenderer;
import fargoal.model.entity.player.api.Gold;
import fargoal.model.entity.player.api.Inventory;

/**
 * Manages the player's state, actions, and interactions within the game world.
 * This includes handling movement, combat mechanics, health management,
 * inventory operations, and interactions with other entities.
 * <p>
 * The class also tracks the player's status, such as whether they are engaged
 * in battle, their ability to flee, and the effects of recieved or inflicted damage.
 * </p>
 */
public class PlayerImpl implements Player {

    private static final int MIN_SKILL_REWARD = 1;
    private static final int MAX_SKILL_REWARD = 5;
    private static final int CONSTANT_ADDED_TO_MAX_HEALTH_IN_LEVEL_UP = 4;
    private static final int MAX_LEVEL_UP_ADDED_MAX_HEALTH = 15;
    private static final int MIN_LEVEL_UP_ADDED_MAX_HEALTH = 1;
    private static final int INITIAL_EXPERIENCE_POINTS_REQUIRED = 200;
    private static final int INITIAL_STAT_MAX_COUNTER = 3;
    private static final int DAMAGE_MULTIPLIER = 4;
    private static final int MINIMUM_DAMAGE = 1;
    private static final int INITIAL_LEVEL = 1;
    private static final long MILLIS_BETWEEN_MOVES = 150;

    private final InputComponent input;
    private final KeyboardInputController controller;
    private Position position;
    private Integer level;
    private Integer experiencePoints;
    private Integer experiencePointsRequired;
    private Health health;
    private Integer skill;
    private final Gold gold;
    private final Inventory inventory;
    private Integer numberOfSlainFoes;
    private final Timer moveTimer;
    private long regenerationTimer;
    private int attackCounter = 0;

    private boolean hasSword;
    private boolean isFighting;
    private boolean isAttacked;
    private boolean isVisible;
    private boolean hasLight;
    private boolean isImmune;

    private PlayerInformationRenderer playerInformationRender;
    private final InventoryInformationRenderer infoRenderer;
    private Renderer render;
    private FloorManager floorManager;

    int healingTime = 0;

    public PlayerImpl(FloorManager floorManager,
        KeyboardInputController controller,
        PlayerInformationRenderer playerInformationRenderer,
        InventoryInformationRenderer infoRenderer) {

        this.floorManager = floorManager;
        this.input = new PlayerInputComponent();
        this.controller = controller;
        this.level = INITIAL_LEVEL;
        this.experiencePoints = 0;
        this.experiencePointsRequired = INITIAL_EXPERIENCE_POINTS_REQUIRED;
        this.health = new HealthImpl(this.generateInitialStat());
        this.skill = generateInitialStat();
        this.gold = new GoldImpl();
        this.inventory = new InventoryImpl(floorManager);
        this.numberOfSlainFoes = 0;
        this.hasSword = false;
        this.isFighting = false;
        this.isAttacked = false;
        this.isVisible = true;
        this.isImmune = false;
        this.hasLight = false;
        this.playerInformationRender = playerInformationRenderer;
        this.playerInformationRender.setRender(floorManager);
        this.infoRenderer = infoRenderer;
        this.infoRenderer.setRenderer(this.inventory);
        this.setRender(floorManager.getRenderFactory().playerRenderer(this));
        this.moveTimer = new Timer();
        this.regenerationTimer = System.currentTimeMillis();

        this.PassiveRegeneration();
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
    public void move(Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Generates the initial stat value by rolling a six-sided die (d6) multiple times.
     * The total value is determined by summing up a series of random d6 rolls.
     * 
     * @return The computed initial stat value as an {@link Integer}.
     */
    private Integer generateInitialStat() {
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
    public boolean levelUp() {
        if(!this.isLevellingUp()) {
            return false;
        } else {
            this.level ++;
            this.health.setMaxHealth(this.health.getMaxHealth() + new Random().nextInt(MIN_LEVEL_UP_ADDED_MAX_HEALTH, MAX_LEVEL_UP_ADDED_MAX_HEALTH) + CONSTANT_ADDED_TO_MAX_HEALTH_IN_LEVEL_UP);
            this.increasePlayerSkill(new Random().nextInt(1, 10));
            this.experiencePointsRequired = this.experiencePointsRequired * 2;
            return true;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void render() {
        this.render.render();
        this.playerInformationRender.render();
        this.infoRenderer.render();
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

    /**{@inheritDoc}*/
    @Override
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
    @Override
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
    public void setIsAttacked(final boolean value) {
        this.isAttacked = value;
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

    /** {@inheritDoc}*/
    @Override
    public void update(final FloorManager floorManager) {
        this.PassiveRegeneration();
        if (this.moveTimer.updateTime(floorManager.getTimePassed()) == 0) {
            if (isFighting) {
                if (!isAttacked) {
                    final var pos = this.getPosition();
                    this.input.update(floorManager, this.controller);
                    if (!this.getPosition().equals(pos)) {
                        isFighting = false;
                        floorManager.getMonsters().stream()
                                .filter(p -> p.isFighting())
                                .forEach(p -> p.setIsFighting(false));
                    } else {
                        for (var monster : floorManager.getMonsters()) {
                            if (monster.isFighting()) {
                                this.battle(monster);
                                break;
                            }
                            this.isAttacked = false;
                            this.isFighting = false;
                        }
                    }
                } else {
                    this.battle(floorManager.getMonsters().stream()
                            .filter(p -> p.isFighting())
                            .findAny()
                            .get());
                }
            } else {
                this.input.update(floorManager, this.controller);
            }
            this.moveTimer.setTime(MILLIS_BETWEEN_MOVES);
        }
    }

    /** {@inheritDoc}*/
    @Override
    public void setIsImmune(Boolean condition) {
        this.isImmune = condition;
    }

    /** {@inheritDoc}*/
    @Override
    public boolean isImmune() {
        return isImmune;
    }

    /** {@inheritDoc}*/
    @Override
    public void battle(final Monster monster) {
        if (isAttacked && attackCounter == 0) {
            floorManager.notifyFloorEvent(new ReceiveAttackEvent(monster));
        } else {
            floorManager.notifyFloorEvent(new BattleEvent());
        }
        attackCounter ++;
        this.isFighting = true;
        monster.receiveDamage();
        this.receiveDamage(monster);
        if (monster.isDead() | this.isDead()) {
            this.isFighting = false;
            this.isAttacked = false;
            attackCounter = 0;

            //winning 
            this.increasePlayerSkill(new Random().nextInt(MIN_SKILL_REWARD, MAX_SKILL_REWARD));
            int gainedExp = this.getLevel() * (monster.getSkill() + monster.getHealth().getMaxHealth());
            this.addExperiencePoints(gainedExp);
            this.levelUp();
            this.increaseNumberOfSlainFoes();
        }
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

    /** {@inheritDoc} */
    @Override
    public void receiveDamage(Monster monster) {
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
        int currentHealth = this.health.getCurrentHealth();
        int potions = inventory.getHealingPotions().getNumberInInventory();

        if (!isFighting()) {
            return currentHealth <= 0;
        } else {
            if (currentHealth <= 0 && potions == 0) {
                return true;
            } else if (currentHealth <= 0 && potions > 0) {
                this.inventory.getHealingPotions().use(floorManager);
                return this.health.getCurrentHealth() <= 0;
            } else {
                return currentHealth <= 0;
            }
        }
    }

    /**
     * Handles the player's passive health regeneration.
     * <p>
     * This method checks if the player is eligible for regeneration and
     * adjusts the regeneration rate based on active effects and location.
     * The base regeneration period can be reduced if the player is in
     * a temple or has an active regeneration spell. 
     * </p><p>
     * Conditions affecting regeneration:
     * <ul>
     * <li>If the player is fighting, regeneration does not occour</li>
     * <li>If both the regeneration spell is active and the player is in a temple,
     * the regeneration period is reduced to 1/5th of the base rate.</li>
     * <li>If either the regeneration spell is active or the player is in a temple,
     * but not both, the regeneration period is reduced to half.</li>
     * </ul>
     * </p><p>
     * When the adjusted regeneration period has passed, the player's health
     * increases by 1 and the regeneration timer is reset.
     * </p>
     */
    public void PassiveRegeneration() {    
        
        final int baseHealingAmount = 1;
        int regenerationPeriod = 10000;
        final long time = System.currentTimeMillis();
        final boolean check = floorManager.getAllElements().stream()
                .filter(p -> p instanceof Temple)
                .findAny()
                .isPresent();

        if (this.isFighting) {
            return;
        }

        if (this.inventory.getSpellCasted().get(SpellType.REGENERATION.getName()) && check && this.isOnTemple()) {
            regenerationPeriod = regenerationPeriod / 5;
        } else if ((this.inventory.getSpellCasted().get(SpellType.REGENERATION.getName()) && check && !this.isOnTemple()) || (!this.inventory.getSpellCasted().get(SpellType.REGENERATION.getName()) && check && this.isOnTemple())) {
            regenerationPeriod = regenerationPeriod / 2;
        }

        if (Math.abs(this.getRegenerationTimer() - time) >= regenerationPeriod) {
            this.health.increaseHealth(baseHealingAmount);
            resetRegenerationTimer();
        }

    }

    /**
     * Resets the regeneration timer to the current system time.
     * <p>
     * This method is called after a successful health regeneration event
     * to ensure that the next regeneration occurs after the appropriate delay.
     * </p>
     */
    private void resetRegenerationTimer() {
        this.regenerationTimer = System.currentTimeMillis();
    }

    /**
     * Retrieves the current regeneration timer value.
     * 
     * @return the timestamp of the last regeneration event in milliseconds.
     */
    private long getRegenerationTimer() {
        return this.regenerationTimer;
    }

    /**
     * Checks if the player is currently at the temple's position.
     * 
     * @return {@code true} if the player is on the temple, {@code false} otherwise.
     */
    private boolean isOnTemple() {
        return this.getPosition().equals(floorManager.getTemple().getPosition());
    }

    /**{@inheritDoc} */
    @Override
    public void useInvisibilitySpell() {
        if (this.getInventory().getInvisibilitySpell().getNumberInInventory() > 0) {
            this.getInventory().getInvisibilitySpell().use(floorManager);
        }
    }

    /**{@inheritDoc} */
    @Override
    public void useTeleportSpell() {
        if (this.getInventory().getTeleportSpell().getNumberInInventory() > 0) {
            this.getInventory().getTeleportSpell().use(floorManager);
        }
    }

    /**{@inheritDoc} */
    @Override
    public void useShieldSpell() {
        if (this.getInventory().getShieldSpell().getNumberInInventory() > 0) {
            this.getInventory().getShieldSpell().use(floorManager);
        }
    }

    /**{@inheritDoc} */
    @Override
    public void useRegenerationSpell() {
        if (this.getInventory().getRegenerationSpell().getNumberInInventory() > 0) {
            this.getInventory().getRegenerationSpell().use(floorManager);
        }
    }

    /**{@inheritDoc} */
    @Override
    public void useDriftSpell() {
        if (this.getInventory().getDriftSpell().getNumberInInventory() > 0) {
            this.getInventory().getDriftSpell().use(floorManager);
        }
    }

    /**{@inheritDoc} */
    @Override
    public void useLightSpell() {
        if (this.getInventory().getLightSpell().getNumberInInventory() > 0) {
            this.getInventory().getLightSpell().use(floorManager);
        }
    }

    /**{@inheritDoc} */
    @Override
    public void useHealingPotion() {
        if (this.getInventory().getHealingPotions().getNumberInInventory() > 0) {
            this.getInventory().getHealingPotions().use(floorManager);
        }
    }

    /**{@inheritDoc} */
    @Override
    public void useBeacon() {
        if (this.getInventory().getBeacons().getNumberInInventory() > 0) {
            this.getInventory().getBeacons().use(floorManager);
        }
    }
}
