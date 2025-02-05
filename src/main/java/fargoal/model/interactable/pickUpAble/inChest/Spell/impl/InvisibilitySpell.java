package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Invisibility Spell from the interface spell.
 */
public class InvisibilitySpell implements Spell {

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public InvisibilitySpell(FloorManager floorManager) {
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
        return SpellType.INVISIBILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addInvisibilityScroll();
    }

    /** {@inheritDoc} */
    @Override
    public void cast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cast'");
    }
    
}
