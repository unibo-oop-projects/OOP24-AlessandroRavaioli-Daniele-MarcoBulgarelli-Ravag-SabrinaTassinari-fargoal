package fargoal.model.interactable.pickUpAble.inChest.Spell.api;

import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the interface for the spells the player can find in a chest.
 */
public interface Spell extends ChestItem {

    /**
     * This method put the spell the player found in a chest in his inventory.
     */
    public void store(FloorManager floorManager);

    /**
     * This method allows the player to cast the spell he has in the inventory. 
     * If he does not have the spell it does nothing.
     */
    public void cast();
}
