package fargoal.model.interactable.pickUpAble.inChest.Trap.impl;

import fargoal.model.interactable.pickUpAble.inChest.Trap.api.Trap;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;

public class CeilingTrap implements Trap {

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

    @Override
    public void damage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'damage'");
    }
    
}
