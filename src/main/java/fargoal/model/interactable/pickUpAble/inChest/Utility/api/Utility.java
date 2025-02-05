package fargoal.model.interactable.pickUpAble.inChest.Utility.api;

import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

public interface Utility extends ChestItem{
    
    public void store(FloorManager floorManager);

}
