package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Teleport Spell from the interface spell.
 * When the player cast this spell he teleports himself near a beacon he had 
 * previously put on the ground. If there is not a beacon he is teleported in a random position.
*/
public class TeleportSpell implements Spell {

    final Position position;

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     */
    public TeleportSpell(FloorManager floorManager, final Position position) {
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
        Position newPlayerPosition;
        if (floorManager.getItems().stream().filter(i -> i.getTag() == "BEACON").count() > 0) {
            newPlayerPosition = 
                floorManager.getItems().stream().filter(i -> i.getTag() == "BEACON").toList().getFirst().getPosition();
        } else {
            newPlayerPosition = floorManager.getFloorMap().getRandomTile();
        }
        floorManager.getPlayer().setPosition(newPlayerPosition);
        floorManager.getPlayer().getInventory().removeTeleportScroll();
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
    }
    
    /** {@inheritDoc} */
    @Override
    public void Render() {}
}
