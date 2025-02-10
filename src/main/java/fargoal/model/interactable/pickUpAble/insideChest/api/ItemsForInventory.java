package fargoal.model.interactable.pickUpAble.insideChest.api;

import fargoal.model.manager.api.FloorManager;

/**
 * This class models the interface for the items that can be store in the inventory,
 * for later use.
 */
public interface ItemsForInventory extends ChestItem {
    
    /**
     * This method put the spell the player found in a chest in his inventory.
     * 
     * @param floorManager
     */
    void store(FloorManager floorManager);
}
