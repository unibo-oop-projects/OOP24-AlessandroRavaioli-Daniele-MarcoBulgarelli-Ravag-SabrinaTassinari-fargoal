package fargoal.model.interactable.pickUpAble.inChest.Trap.impl;

import fargoal.model.interactable.pickUpAble.inChest.Trap.api.Trap;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;

public class Explosion implements Trap {

    public Explosion() {
        this.damage();
    }

    @Override
    public String getChestItemType() {
        return ChestItemType.TRAP.getName();
    }

    @Override
    public String getChestItemName() {
        return TrapType.EXPLOSION.getName();
    }

    @Override
    public void damage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'damage'");
    }

    
    
}
