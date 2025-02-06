package fargoal.model.entity.monsters.api;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Entity;
import fargoal.model.map.api.FloorMap;

/**
 * A monster represent an Entity who will try to attack
 * the player and kill him.
 */
public interface Monster extends Entity {
    /**
     * Return the MonsterType of the monster selected.
     * 
     * @return the MonsterType
     */
    MonsterType getMonsterType();

    /**
     * The Monster selected with the call of this
     * method will receive the damage. For example if it's
     * called on a monster, he will receives the damages from the
     * player.
     */
    public void receiveDamage();

    /**
     * Method that returns the level of the
     * Monster selected.
     * 
     * @return the level of the Monster
     */
    public Integer getLevel();

    /**
     * Set the new Position of the Monster.
     * 
     * @param position - the new Position
     */
    public void setPosition(final Position position);

    /**
     * Move the Monster to a new Position, the choice of
     * new location is random.
     * 
     * @param floorManager - to get infos about the player
     */
    public void move();

    /**
     * The Monster attack the Player and deals damage
     * based on their skill.
     * 
     * @return the int indicating the damage dealt to
     * the player
     */
    public Integer attack();

    /**
     * The Monster steals from the Player and takes
     * spell or potions from his inventory.
     */
    public abstract void steal();

    /**
     * Return the FloorMap where the Monster is located.
     * 
     * @return the FloorMap
     */
    public FloorMap getFloorMap();

    /**
     * Set the Monster's visibility to true,
     * which means that the Monster is visible.
     */
    public void setVisibilityOn();

    /**
     * Set the Monster's visibility to false,
     * which means that the Monster isn't visible.
     */
    public void setVisibilityOff();

    /**
     * Return the visibility of the monster.
     * Assassin for example are often invisible for the 
     * player.
     * 
     * @return the field isVisible of the Monster
     */
    public boolean getVisibility();
}
