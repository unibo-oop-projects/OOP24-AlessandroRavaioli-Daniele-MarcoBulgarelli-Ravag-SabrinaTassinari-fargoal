package fargoal.model.interactable.pickUpAble.insideChest.Utility.impl;

import fargoal.model.events.impl.PlacedABeacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.AbstractUtility;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.UtilityType;
import fargoal.model.interactable.pickUpAble.onGround.BeaconOnGround;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Beacon, when it is in the player's inventory. 
 * The player found the beacon in a chest.
 */
public class Beacon extends AbstractUtility {

    /**
     * This is the constructor of the class. It store right away the beacon in the player's inventory.
     * @param floorManager - in it there are all the information about the floor the item is.
     */
    public Beacon(final FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.BEACON.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void effect(final FloorManager floorManager) {
        this.removeUtility();
        BeaconOnGround beaconOnGround = new BeaconOnGround(floorManager.getPlayer().getPosition(), floorManager);
        floorManager.getInteractables().add(beaconOnGround);
        floorManager.notifyFloorEvent(new PlacedABeacon(beaconOnGround));
    }

    /** {@inheritDoc} */
    @Override
    public void addToPlayer(final FloorManager floorManager) {
    }

}
