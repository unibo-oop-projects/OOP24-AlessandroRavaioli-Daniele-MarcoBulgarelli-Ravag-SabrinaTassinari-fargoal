package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Drift Spell from the interface Spell.
 * When the player cast this spell if he falls in a pit he does not damage himself.
 */
public class DriftSpell implements Spell{

    final private static int SPELL_NOT_CASTED = -1;
    final private Position position;
    private int floorLevelSpellCasted;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     * If the spell was cast and player did not fall in a pit when he change the floor
     * the spell ends.
     */
    public DriftSpell(FloorManager floorManager, final Position position) {
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
        return SpellType.DRIFT.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
       floorManager.getPlayer().getInventory().addDriftScroll();
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.DRIFT.getName(), true);
        floorManager.getPlayer().getInventory().removeDriftScroll();
        this.setFloorLevelSpellCast(floorManager.getFloorLevel());
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

    /** {@inheritDoc} */
    @Override
    public void render() {}

}
