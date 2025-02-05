package fargoal.model.interactable.pickUpAble.inChest.Utility.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

public class Beacon implements Utility {

    final Position position;

    public Beacon(FloorManager floorManager, final Position position) {
        this.store(floorManager);
        this.position = position;
    }

    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    @Override
    public String getChestItemName() {
        return UtilityType.BEACON.getName();
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

    @Override
    public void store(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }
}
