package fargoal.model.interactable.pickUpAble.inChest.Utility.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.interactable.pickUpAble.onGround.BeaconOnGround;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Beacon, when it is in the player's inventory.
 */
public class Beacon implements Utility {

    final Position position;

    /**
     * This is the constructor of the class. It store right away the ebacon in the player's inventory.
     * @param floorManager - in it there are all the information about the floor the item is.
     * @param position - the position of the chest the beacon has been found.
     */
    public Beacon(FloorManager floorManager, final Position position) {
        this.store(floorManager);
        this.position = position;
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.BEACON.getName();
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        return new BeaconOnGround(floorManager.getPlayer().getPosition());
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return this.getChestItemName();
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addBeacon();
    }
}
