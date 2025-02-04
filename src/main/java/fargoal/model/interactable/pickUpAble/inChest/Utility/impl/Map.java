package fargoal.model.interactable.pickUpAble.inChest.Utility.impl;

import fargoal.model.interactable.pickUpAble.inChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;

public class Map implements Utility {

    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    @Override
    public String getChestItemName() {
        return UtilityType.MAP.getName();
    }

    @Override
    public void store() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }
    
}
