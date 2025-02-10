package fargoal.model.interactable.pickUpAble.insideChest.Spell.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Teleport Spell from the interface spell.
 * When the player cast this spell he teleports himself near a beacon he had 
 * previously put on the ground. If there is not a beacon he is teleported in a random position.
*/
public class TeleportSpell implements Spell {

    private int numberInInventory;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public TeleportSpell(FloorManager floorManager) {
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
        return SpellType.TELEPORT.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        this.addSpell();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        Position newPlayerPosition;
        if (floorManager.getInteractables().stream().filter(i -> i.getTag() == "BEACON").count() > 0) {
            newPlayerPosition = 
                floorManager.getInteractables().stream().filter(i -> i.getTag() == "BEACON").toList().getFirst().getPosition();
        } else {
            newPlayerPosition = floorManager.getFloorMap().getRandomTile();
        }
        floorManager.getPlayer().setPosition(newPlayerPosition);
        this.removeSpell();
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
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
