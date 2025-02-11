package fargoal.model.interactable.pickUpAble.insideChest.Utility.impl;

import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.AbstractUtility;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.UtilityType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Magic Sack, which the player found in a chest.
 */
public class MagicSack extends AbstractUtility {

    final static int GOLD_CARRIED_BY_MAGIC_SACK = 100;
    private static int N_MAGICK_SACK_TO_START = 1;

    /**
     * This is the constructor of the class. It stores right away the item in the player's inventory.
     * @param floorManager - it contains all the element of the floor in which the item was found.
     */
    public MagicSack(FloorManager floorManager) {
        this.setNumberInInventory(N_MAGICK_SACK_TO_START);
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.MAGIC_SACK.getName();
    }

    @Override
    public void effect(FloorManager floorManager) {
    }

    @Override
    public void addToPlayer(FloorManager floorManager) {
        floorManager.getPlayer().getPlayerGold().setMaxCapacity(floorManager.getPlayer().getMaxGoldCapacity() + GOLD_CARRIED_BY_MAGIC_SACK);
    }

}
