package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Teleport Spell from the interface spell.
 */
public class TeleportSpell implements Spell {

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public TeleportSpell(FloorManager floorManager) {
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
        return SpellType.TELEPORT.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addTeleportScroll();
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTag'");
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
