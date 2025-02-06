package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Invisibility Spell from the interface spell.
 */
public class InvisibilitySpell implements Spell {

    final Position position;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public InvisibilitySpell(FloorManager floorManager, final Position position) {
        this.store(floorManager);
        this.position = position;
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
    public Interactable interact(FloorManager floorManager) {
        //TODO (i mostri non lo vedono)
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.INVISIBILITY.getName(), true);
        floorManager.getPlayer().getInventory().removeInvisibilityScroll();
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
