package fargoal.model.interactable.pickUpAble.inChest.Trap.impl;

import fargoal.model.interactable.pickUpAble.inChest.Trap.api.AbstractTrap;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;

public class CeilingTrap extends AbstractTrap {

    public CeilingTrap() {
        this.damage();
    }

    @Override
    public String getChestItemType() {
        return ChestItemType.TRAP.getName();
    }

    @Override
    public String getChestItemName() {
        return TrapType.CEILING_TRAP.getName();
    }
    
}
