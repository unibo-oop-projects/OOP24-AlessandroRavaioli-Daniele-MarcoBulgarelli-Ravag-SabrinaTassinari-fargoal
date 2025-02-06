package fargoal.model.interactable.pickUpAble.inChest.Utility.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Magic Sack, which the player found in a chest.
 */
public class MagicSack implements Utility{

    final static int GOLD_CARRIED_BY_MAGIC_SACK = 100;
    final Position position;

    /**
     * This is the constructor of the class. It stores right away the item in the player's inventory.
     * @param floorManager - it contains all the element of the floor in which the item was found.
     * @param position - this is the position of the chest that contained the item.
     */
    public MagicSack(FloorManager floorManager, final Position position) {
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
        return UtilityType.MAGIC_SACK.getName();
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        return this;
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
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().getMagicSacks();
        floorManager.getPlayer().getPlayerGold().setMaxCapacity(floorManager.getPlayer().getMaxGoldCapacity() + GOLD_CARRIED_BY_MAGIC_SACK);
    }

    
    
}
