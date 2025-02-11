package fargoal.model.interactable.pickUpAble.insideChest.Spell.api;

import fargoal.model.events.impl.PlayerActionEvent;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

public abstract class AbstractSpell implements Spell {
    
    private int numberInInventory = 0;
    private int floorLevelSpellCasted;

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.SPELL.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        this.addSpell();
    }

    /**
     * This method add a spell in the player's inventory.
     */
    private void addSpell() {
        this.numberInInventory++;
    }

    /** {@inheritDoc} */
    @Override
    public void removeSpell() {
        if (this.numberInInventory > 0) {
            this.numberInInventory--;
        }
    }

    /** {@inheritDoc} */
    @Override
    public Integer getNumberInInventory() {
        return this.numberInInventory;
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        floorManager.notifyFloorEvent(new PlayerActionEvent(this));
        this.effect(floorManager);
        this.setFloorLevelSpellCast(floorManager.getFloorLevel());
    }

    public abstract void effect(FloorManager floorManager);

    /**
     * Setter for the field floorLevelSpellCast, which indicates in which floor the spell has been cast
     * @param floorLevelSpellCasted - the level in which the spell has been cast
     */
    private void setFloorLevelSpellCast(int floorLevelSpellCasted) {
        this.floorLevelSpellCasted = floorLevelSpellCasted;
    }

    public int getFloorLevelSpellCast() {
        return this.floorLevelSpellCasted;
    }
}
