package fargoal.model.interactable.pickUpAble.insideChest.Spell.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ItemsForInventory;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the interface for the spells the player can find in a chest.
 */
public interface Spell extends ItemsForInventory {

    /**
     * This method checks if the spell is still been cast or not.
     * For example, if the floor change, the spell ends.
     * @param floorManager - it contains all the element of the floor.
     */
    void update(FloorManager floorManager);

    /**
     * This method checks how many spells are in the inventory.
     * @return the number of a determined spell are in the player's inventory.
     */
    Integer getNumberInInventory();

    /**
     * This method remove a spell from the inventory.
     */
    void removeSpell();
}
