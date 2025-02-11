package fargoal.model.interactable.pickUpAble.insideChest.Trap.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;

public abstract class AbstractTrap implements ChestItem {
    
    @Override 
    public String getChestItemType() {
        return ChestItemType.TRAP.getName();
    }

}
