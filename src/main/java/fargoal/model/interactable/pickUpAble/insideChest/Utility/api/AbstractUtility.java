package fargoal.model.interactable.pickUpAble.insideChest.Utility.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This abstract class helps to implement an utility.
 */
public abstract class AbstractUtility implements Utility {

    private int numberInInventory = 0;

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(final FloorManager floorManager) {
        this.effect(floorManager);
    }

    /**
     * This method is the effect the utility has when it is used.
     * @param floorManager - it contains all the element of the floor.
     */
    public abstract void effect(FloorManager floorManager);

    /** {@inheritDoc} */
    @Override
    public void store(final FloorManager floorManager) {
        this.addUtility();
        this.addToPlayer(floorManager);
    }

    /**
     * This method add a determined statistics to the player, when the utility 
     * is stored.
     * @param floorManager - it contains all the elements of the floor.
     */
    public abstract void addToPlayer(FloorManager floorManager);

    /**
     * This method add an utility in the player's inventory.
     */
    private void addUtility() {
        this.numberInInventory++;
    }

    /** {@inheritDoc} */
    @Override
    public void removeUtility() {
        this.numberInInventory--;
    }

    /** {@inheritDoc} */
    @Override
    public int getNumberInInventory() {
        return this.numberInInventory;
    }

    /**
     * Setter for the field numberInInventory.
     * @param numberInInventory - number of this item in inventory.
     */
    public void setNumberInInventory(final int numberInInventory) {
        this.numberInInventory = numberInInventory;
    }
}
