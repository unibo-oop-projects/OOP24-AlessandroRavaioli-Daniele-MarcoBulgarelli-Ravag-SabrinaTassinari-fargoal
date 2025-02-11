package fargoal.model.interactable.pickUpAble.insideChest.Spell.impl;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.PlayerActionEvent;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.AbstractSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.SpellType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the Teleport Spell. It extends the abstract class AbstractSpell.
 * When the player cast this spell he teleports himself near a beacon he had 
 * previously put on the ground. If there is not a beacon he is teleported in a random position.
*/
public class TeleportSpell extends AbstractSpell {

    /**
     * The constructor of the class. When The spell is found in a chest 
     * it is stored immediately in the player's inventory.
     * @param floorManager - it contains al the element in the floor.
     */
    public TeleportSpell(final FloorManager floorManager) {
        this.store(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return SpellType.TELEPORT.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public void effect(final FloorManager floorManager) {
        Position newPlayerPosition;
        floorManager.notifyFloorEvent(new PlayerActionEvent(this));
        if (floorManager.getInteractables().stream().filter(i -> i.getTag() == "BEACON").count() > 0) {
            newPlayerPosition = 
                floorManager.getInteractables().stream().filter(i -> i.getTag() == "BEACON").toList().getFirst().getPosition();
        } else {
            newPlayerPosition = floorManager.getFloorMap().getRandomTile();
        }
        floorManager.getPlayer().setPosition(newPlayerPosition);
        this.removeSpell();
    }
}
