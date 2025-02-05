package fargoal.model.entity.player.api;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Entity;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.monsters.api.Monster;

/**
 * Interface that manages the player character
 */

public interface Player extends Entity {

    /**
     * Getter for player's current level.
     * 
     * @return player's current level.
     */
    Integer getLevel();

    /**
     * Getter for the amount of experience points
     * the player currently has.
     * 
     * @return the amount of experience points the 
     * player currently has.
     */
    Integer getExperiencePoints();

    /**
     * Getter for the player's inventory.
     * 
     * @return the inventory associated to the player.
     */
    Inventory getInventory();

    /**
     * This method controls if player has aquired the
     * legendary sword.
     * 
     * @return true if player has the sword, false otherwise.
     */
    boolean hasSword();

    /**
     * Makes the player move one tile in the map.
     */
    void move();

    /**
     * This method calculates the amount of damage the player
     * does against the monster they are currently fighting in
     * a single attack.
     * 
     * @param monster - The enemy monster.
     * 
     * @return the amount of damage dealt.
     */
    Integer doDamage(Monster monster);
}
