package fargoal.model.interactable.pickUpAble.insideChest.Utility.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the interface of the utilities, which can be found in a chest. 
 */
public interface Utility extends ChestItem {
    
    /**
     * This method store the utility in the player's inventory.
     * @param floorManager - it contains all the element of the floor.
     */
    void store(FloorManager floorManager);

}
