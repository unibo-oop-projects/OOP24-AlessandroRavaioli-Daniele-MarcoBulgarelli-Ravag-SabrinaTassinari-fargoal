package fargoal.model.interactable.pickUpAble.insideChest.Utility.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

public abstract class AbstractUtility implements Utility {
    
    private int numberInInventory = 0;

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        this.effect(floorManager);
    }

    public abstract void effect(FloorManager floorManager);

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        this.addUtility();
        this.addToPlayer(floorManager);
    }

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

    public void setNumberInInventory(final int numberInInventory) {
        this.numberInInventory = numberInInventory;
    }
}
