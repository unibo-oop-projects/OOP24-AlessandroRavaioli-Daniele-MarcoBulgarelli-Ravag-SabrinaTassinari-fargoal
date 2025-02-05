package fargoal.model.entity.monsters.api;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.player.api.Player;
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
    private FloorMap floorMap;
    private MonsterType monsterType;
    private Health health;
    private Position position;
    private Integer skill;
    private boolean isVisible = false;
    private final Random random = new Random();

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
     * Set the new Position of the Monster.
     * 
     * @param position - the new Position
     */
    public void setPosition(final Position position) {
        this.position = position;
    }

    /**
     * Set the skill of the Monster, based on the 
     * level where the Monster is.
     * 
     * @param level - the level where the Monster is
     */
    public void setSkill(final Integer level) {
        this.skill = level * (getRandom(level) + 1);
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
     * Set the FloorMap of the Monster.
     * 
     * @param floorMap - the FloorMap where the Monster is
     */
    public void setFloorMap(final FloorMap floorMap) {
        this.floorMap = floorMap;
    }

    /**
     * Return the FloorMap where the Monster is.
     * 
     * @return the FloorMap
     */
    public FloorMap getFloorMap() {
        return this.floorMap;
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
     * Move the Monster to a new Position, the choice of
     * new location is random.
     * 
     * @param floorManager - to get infos about the player
     */
    public void move(final FloorManager floorManager) {
        Ai.move(this, floorManager.getPlayer());
    }

    /**
     * The Monster attack the Player and deals damage
     * based on their skill.
     * 
     * @param player - the attacked Entity
     */
    public void attack(final Player player) {
        var ratio = player.getSkill() / this.getSkill();
        player.getHealth().decreaseHealth(getRandom(MONSTER_ATTACK * player.getLevel() * ratio));
    }

    /**
     * Return if the monster and the player are near(based on the given amount).
     * 
     * @param floorManager - which can give all the information we need
     * @param amount - the Integer to set the proximity area
     * @return if the monster is near the player
     */
    public boolean areNeighbours(final FloorManager floorManager, final Integer amount) {
        return (floorManager.getPlayer().getPosition().x() - this.getPosition().x() <= amount
                && floorManager.getPlayer().getPosition().y() - this.getPosition().y() <= amount);
    }

    /**
     * The Monster steals from the Player and takes
     * spell or potions from his inventory.
     * 
     * @param player - the player robbed
     */
    public abstract void steal(Player player);
}
