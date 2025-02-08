package fargoal.model.interactable.pickUpAble.insideChest.Utility;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.interactable.pickUpAble.insideChest.api.ItemsForInventory;
import fargoal.model.interactable.pickUpAble.onGround.BeaconOnGround;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Beacon, when it is in the player's inventory. 
 * The player found the beacon in a chest.
 */
public class Beacon implements ItemsForInventory {

    /**
     * This is the constructor of the class. It store right away the beacon in the player's inventory.
     * @param floorManager - in it there are all the information about the floor the item is.
     * @param position - the position of the chest the beacon has been found.
     */
    public Beacon(FloorManager floorManager) {
        this.store(floorManager);
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
    public void use(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().removeBeacon();
        BeaconOnGround beaconOnGround = new BeaconOnGround(floorManager.getPlayer().getPosition(), floorManager);
        floorManager.getInteractables().add(beaconOnGround);
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addBeacon(this);
    }

}
