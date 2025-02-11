package fargoal.model.interactable.pickUpAble.insideChest.Spell.impl;

import fargoal.model.events.impl.PlayerActionEvent;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Invisibility Spell from the interface spell.
 * When the player cast this spell the monsters can not see him.
 * If the light spell is active the player can be seen.
 * The spell ends when the player change floor level.
 */
public class InvisibilitySpell implements Spell {

    private int numberInInventory;
    private int floorLevelSpellCasted;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public InvisibilitySpell(FloorManager floorManager) {
        this.numberInInventory = 0;
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
        this.addSpell();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        floorManager.notifyFloorEvent(new PlayerActionEvent(this));
        floorManager.getPlayer().setIsVisible(false);
        floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.INVISIBILITY.getName(), true);
        this.removeSpell();
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
        if (floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.INVISIBILITY.getName())) {
            if (this.floorLevelSpellCasted != floorManager.getFloorLevel()) {
                floorManager.getPlayer().getInventory().getSpellCasted().replace(SpellType.INVISIBILITY.getName(), false);
                floorManager.getPlayer().setIsVisible(true);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public Integer getNumberInInventory() {
        return this.numberInInventory;
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

}
