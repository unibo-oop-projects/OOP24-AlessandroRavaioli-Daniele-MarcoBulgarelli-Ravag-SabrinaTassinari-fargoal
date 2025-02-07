package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Light Spell from the interface spell.
 * When the player cast this spell he can uncover more map of the floor: 
 * he can see two tiles near him. If the player is not visible, it makes him visible.
 * The spell ends when the player change floor level.
 */
public class LightSpell implements Spell {

    final private static int SPELL_NOT_CASTED = -1;
    final private  Position position;
    private int floorLevelSpellCasted;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public LightSpell(FloorManager floorManager, final Position position) {
        this.store(floorManager);
        this.position = position;
        this.floorLevelSpellCasted = SPELL_NOT_CASTED;
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.SPELL.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return SpellType.LIGHT.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addLightScroll();
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.LIGHT.getName(), true);
        floorManager.getPlayer().getInventory().removeLightScroll();
        if (!floorManager.getPlayer().isVisible()) {
            floorManager.getPlayer().setIsVisible(true);
        }
        this.setFloorLevelSpellCast(floorManager.getFloorLevel());
        return this;
    }

    public void turnLight(FloorManager floorManager) {
        if (floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.LIGHT.getName())) {
            if (floorManager.getPlayer().isVisible()) {
                
            }
        }
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
        if (this.floorLevelSpellCasted != SPELL_NOT_CASTED) {
            if (this.floorLevelSpellCasted < floorManager.getFloorLevel()) {
                floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.DRIFT.getName(), false);
            }
        }
    }
    
}
