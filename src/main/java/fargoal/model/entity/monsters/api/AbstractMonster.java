package fargoal.model.entity.monsters.api;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.commons.impl.HealthImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.model.entity.monsters.ai.Ai;

/**
 * A Monster is an abstraction of anything that will try
 * to attack and kill the player.
 * Every object that will attack and kill the player must
 * extend this abstract class.
 */
public abstract class AbstractMonster implements Monster {

    private static final Integer MONSTER_ATTACK = 4;
    private long timer;
    private MonsterType monsterType;
    private Health health;
    private Position position;
    private Integer skill;
    private Integer level;
    private FloorManager floorManager;
    private boolean isVisible = false;
    private final Random random = new Random();

    /**
     * A constructor to set the field that the monster needs
     * to be able to walk in the map, interacts with the items
     * and, in case, attacks the player.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public AbstractMonster(
                final Position position,
                final Integer level, 
                final FloorManager floorManager) {
        this.setPosition(position);
        this.setFloorManager(floorManager);
        this.setSkill(level);
        this.setLevel(level);
        this.setVisibilityOn();
        this.health = new HealthImpl(floorManager.getPlayer().getHealth().getCurrentHealth() / 3 * (this.getRandom(level) + 1));
        this.setTimer();
    }

    /** {@inheritDoc} */
    @Override
    public MonsterType getMonsterType() {
        return this.monsterType;
    }

    /** {@inheritDoc} */
    @Override
    public Health getHealth() {
        return this.health;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getSkill() {
        return this.skill;
    }

    /** {@inheritDoc} */
    @Override
    public void receiveDamage() {
        final int damage = this.getFloorManager().getPlayer().doDamage(this);
        this.getHealth().decreaseHealth(damage);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getLevel() {
        return this.level;
    }

    /** {@inheritDoc} */
    @Override
    public void setPosition(final Position position) {
        this.position = position;
    }

    /** {@inheritDoc} */
    @Override
    public void move() {
        Ai.move(this, floorManager.getPlayer());
    }

    /** {@inheritDoc} */
    @Override
    public Integer attack() {
        final var ratio = this.getFloorManager().getPlayer().getSkill() / this.getSkill();
        return getRandom(MONSTER_ATTACK * this.getFloorManager().getPlayer().getLevel() * ratio) + 1;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isDead() {
        return this.getHealth().getCurrentHealth() <= 0;
    }

    /**
     * Method to set the level of the Monster.
     * 
     * @param level - the level that the monster has
     */
    private void setLevel(final Integer level) {
        this.level = level;
    }

    /**
     * Set the skill of the Monster, based on the 
     * level where the Monster is.
     * 
     * @param level - the level where the Monster is
     */
    private void setSkill(final Integer level) {
        this.skill = level * (getRandom(level) + 1);
    }

    /**
     * Set the Floormanager of the Monster.
     * 
     * @param floorManager - the FloorManager of the Floor where the Monster is located
     */
    private void setFloorManager(final FloorManager floorManager) {
        this.floorManager = floorManager;
    }

    /**
     * Set the MonsterType of the Monster selected.
     * 
     * @param monsterType the MonsterType of the Monster
     * @return
     */
    public void setMonsterType(final MonsterType monsterType) {
        this.monsterType = monsterType;
    }

    /**
     * Return a random number between 0 and the Integer
     * before the given value.
     * 
     * @param num - the max number of the random
     * @return a random number
     */
    public Integer getRandom(final Integer num) {
        return random.nextInt(num);
    }

    /**
     * Method to set the last time when the monster
     * was created or moved.
     */
    public void setTimer() {
        this.timer = System.currentTimeMillis();
    }

    /**
     * Method that return the time when the monster
     * last moved or was created.
     * 
     * @return a long indicating the last update
     */
    public long getTimer() {
        return this.timer;
    }

    /**
     * Return the FloorMap where the Monster is located.
     * 
     * @return the FloorMap
     */
    public FloorMap getFloorMap() {
        return this.floorManager.getFloorMap();
    }

    /**
     * Return the Floormanager where the Monster is located.
     * 
     * @return the Floormanager
     */
    public FloorManager getFloorManager() {
        return this.floorManager;
    }

    /**
     * Set the Monster's visibility to true,
     * which means that the Monster is visible.
     */
    public void setVisibilityOn() {
        this.isVisible = true;
    }

    /**
     * Set the Monster's visibility to false,
     * which means that the Monster isn't visible.
     */
    public void setVisibilityOff() {
        this.isVisible = false;
    }

    /**
     * Return the visibility of the monster.
     * Assassin for example are often invisible for the 
     * player.
     * 
     * @return the field isVisible of the Monster
     */
    public boolean getVisibility() {
        return this.isVisible;
    }

    /**
     * Return if the monster and the player are near(based on the given amount).
     * 
     * @param floorManager - which can give all the information we need
     * @param amount - the Integer to set the proximity area
     * @return if the monster is near the player
     */
    public boolean areNeighbours(final FloorManager floorManager, final Integer amount) {
        return floorManager.getPlayer().getPosition().x() - this.getPosition().x() <= amount
                && floorManager.getPlayer().getPosition().y() - this.getPosition().y() <= amount;
    }

    /**
     * The Monster steals from the Player and takes
     * spell or potions from his inventory.
     */
    public abstract void steal();
}
