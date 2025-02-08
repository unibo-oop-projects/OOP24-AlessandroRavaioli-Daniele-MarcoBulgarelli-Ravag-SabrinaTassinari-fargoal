package fargoal.model.interactable.pickUpAble.insideChest.Utility.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ItemsForInventory;

public interface Utility extends ItemsForInventory {
    
    int getNumberInInventory();

    void removeUtility();

}
