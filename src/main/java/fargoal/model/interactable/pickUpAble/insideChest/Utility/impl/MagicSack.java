package fargoal.model.interactable.pickUpAble.insideChest.Utility.impl;

import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.UtilityType;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Magic Sack, which the player found in a chest.
 */
public class MagicSack implements Utility {

    final static int GOLD_CARRIED_BY_MAGIC_SACK = 100;
    private int numberInInventory;

    /**
     * This is the constructor of the class. It stores right away the item in the player's inventory.
     * @param floorManager - it contains all the element of the floor in which the item was found.
     */
    public MagicSack(FloorManager floorManager) {
        this.numberInInventory = 1;
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.MAGIC_SACK.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        this.addUtility();
        floorManager.getPlayer().getPlayerGold().setMaxCapacity(floorManager.getPlayer().getMaxGoldCapacity() + GOLD_CARRIED_BY_MAGIC_SACK);
    }

    /** {@inheritDoc} */
    @Override
    public int getNumberInInventory() {
        return this.numberInInventory;
    }

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

}
