package fargoal.model.interactable.pickUpAble.inChest.Trap.impl;

import fargoal.model.interactable.pickUpAble.inChest.Trap.api.AbstractTrap;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;

public class Pit extends AbstractTrap {

    public Pit() {
        this.damage();
    }

    @Override
    public String getChestItemType() {
        return ChestItemType.TRAP.getName();
    }

    @Override
    public String getChestItemName() {
        return TrapType.PIT.getName();
    }
    
}
