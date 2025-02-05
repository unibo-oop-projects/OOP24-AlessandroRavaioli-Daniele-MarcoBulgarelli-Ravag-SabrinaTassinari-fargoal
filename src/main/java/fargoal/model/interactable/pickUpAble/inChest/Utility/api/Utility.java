package fargoal.model.interactable.pickUpAble.inChest.Utility.api;

import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the interface of the utilities, which can be found in a chest. 
 */
public interface Utility extends ChestItem{
    
    /**
     * This method store the utility in the player's inventory.
     * @param floorManager - it contains all the element of the floor.
     */
    public void store(FloorManager floorManager);

}
