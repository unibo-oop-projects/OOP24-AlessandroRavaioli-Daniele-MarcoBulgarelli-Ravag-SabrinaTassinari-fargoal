package fargoal.model.interactable.pickUpAble.insideChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Regeneration Spell from the interface spell.
 * When the player cast this spell his hit points increases faster. 
 * This spell finishes when the player changes the floor.
 */
public class RegenerationSpell implements Spell {

    private int floorLevelSpellCasted;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public RegenerationSpell(FloorManager floorManager) {
    
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.SPELL.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return SpellType.REGENERATION.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addRegenerationScroll();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.REGENERATION.getName(), true);
        floorManager.getPlayer().getInventory().removeRegenerationScroll();
        this.setFloorLevelSpellCast(floorManager.getFloorLevel());
    }

    /**
     * Setter for the field floorLevelSpellCast, which indicates in which floor the spell has been cast
     * @param floorLevelSpellCasted - the level in which the spell has been cast
     */
    private void setFloorLevelSpellCast(int floorLevelSpellCasted) {
        this.floorLevelSpellCasted = floorLevelSpellCasted;
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        if (floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.REGENERATION.getName())) {
            if (this.floorLevelSpellCasted < floorManager.getFloorLevel()) {
                floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.REGENERATION.getName(), false);
            }
        }
    }

}
