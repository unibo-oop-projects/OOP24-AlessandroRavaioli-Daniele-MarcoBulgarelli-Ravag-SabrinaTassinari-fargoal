package fargoal.model.interactable.pickUpAble.insideChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Shield Spell from the interface spell.
 * When the player casts this spell he does not damage himself in the next fight.
 * If the player is not damaged and when he change floor level the spell is still 
 * casted, the spell ends.
 */
public class ShieldSpell implements Spell {

    private int floorLevelSpellCasted;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     * 
     */
    public ShieldSpell(FloorManager floorManager) {
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
        return SpellType.SHIELD.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addShieldScroll();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.SHIELD.getName(), true);
        floorManager.getPlayer().getInventory().removeShieldScroll();
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
        if (floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.SHIELD.getName())) {
            if (this.floorLevelSpellCasted < floorManager.getFloorLevel()) {
                floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.SHIELD.getName(), false);
            }
        }
    }

}
