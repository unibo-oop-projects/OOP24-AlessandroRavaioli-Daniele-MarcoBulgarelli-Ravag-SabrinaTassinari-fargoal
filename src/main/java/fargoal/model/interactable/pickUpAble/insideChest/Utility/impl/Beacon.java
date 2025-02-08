package fargoal.model.interactable.pickUpAble.insideChest.Utility.impl;

import fargoal.model.interactable.pickUpAble.insideChest.Utility.UtilityType;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.interactable.pickUpAble.onGround.BeaconOnGround;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Beacon, when it is in the player's inventory. 
 * The player found the beacon in a chest.
 */
public class Beacon implements Utility {

    private int numberInInventory;

    /**
     * This is the constructor of the class. It store right away the beacon in the player's inventory.
     * @param floorManager - in it there are all the information about the floor the item is.
     * @param position - the position of the chest the beacon has been found.
     */
    public Beacon(FloorManager floorManager) {
        this.numberInInventory = 0;
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
        this.removeUtility();
        BeaconOnGround beaconOnGround = new BeaconOnGround(floorManager.getPlayer().getPosition(), floorManager);
        floorManager.getInteractables().add(beaconOnGround);
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        this.addUtility();
    }

    @Override
    public int getNumberInInventory() {
        return this.numberInInventory;
    }

    private void addUtility() {
        this.numberInInventory++;
    }

    @Override
    public void removeUtility() {
        if (this.numberInInventory > 0) {
            this.numberInInventory--;
        }
    }



}
