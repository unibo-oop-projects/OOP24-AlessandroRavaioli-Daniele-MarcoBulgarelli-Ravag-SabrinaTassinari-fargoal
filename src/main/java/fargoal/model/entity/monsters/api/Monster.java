package fargoal.model.entity.monsters.api;

import java.util.List;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Entity;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.Renderer;

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
     * Method that return the render of this Monster.
     * 
     * @return the render field
     */
    public Renderer getRender();

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
     * Return the FloorMap where the Monster is located.
     * 
     * @return the FloorMap
     */
    public FloorMap getFloorMap();

    /**
     * Return the Floormanager where the Monster is located.
     * 
     * @return the Floormanager
     */
    public FloorManager getFloorManager();

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

    /**
     * Return the list containing the last 5
     * position where the monster was.
     * 
     * @return a list of positions
     */
    public List<Position> getLastPositions();

    /**
     * Method that remove the position in the 
     * index n.5 in the list that contains 
     * the cache with the last movements of the Monster.
     */
    public void removeLastPosition();

    /**
     * Method that add the position at the top
     * of the list containing the cache of the last
     * movements of the Monster.
     * 
     * @param position - the position to addFirst in the cacheList
     */
    public void addFirstPosition(Position position);
}
