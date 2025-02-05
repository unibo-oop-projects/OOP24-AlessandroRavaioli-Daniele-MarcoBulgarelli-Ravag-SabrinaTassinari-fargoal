package fargoal.model.interactable.pickUpAble.inChest.Trap.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Trap.api.AbstractTrap;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

public class Pit extends AbstractTrap {

    final Position position;

    public Pit(FloorManager floorManager, final Position position) {
        this.damage(floorManager);
        this.position = position;
    }

    @Override
    public String getChestItemType() {
        return ChestItemType.TRAP.getName();
    }

    @Override
    public String getChestItemName() {
        return TrapType.PIT.getName();
    }

    @Override
    public Interactable interact(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public String getTag() {
        return this.getChestItemName();
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
