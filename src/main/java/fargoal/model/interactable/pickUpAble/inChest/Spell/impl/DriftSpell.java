package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Drift Spell from the interface Spell.
 */
public class DriftSpell implements Spell{

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public DriftSpell(FloorManager floorManager) {
        this.store(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.SPELL.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return SpellType.DRIFT.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
       floorManager.getPlayer().getInventory().addDriftScroll();
    }

    /** {@inheritDoc} */
    @Override
    public void cast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cast'");
    }

    
}
