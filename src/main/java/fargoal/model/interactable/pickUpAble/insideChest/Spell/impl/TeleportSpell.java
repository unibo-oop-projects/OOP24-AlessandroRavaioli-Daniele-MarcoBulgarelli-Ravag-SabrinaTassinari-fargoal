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
        floorManager.getPlayer().getInventory().addTeleportScroll(this);
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
        floorManager.getPlayer().getInventory().removeTeleportScroll();
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
    }
    
}
