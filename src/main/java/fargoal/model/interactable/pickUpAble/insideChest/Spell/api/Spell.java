package fargoal.model.interactable.pickUpAble.insideChest.Spell.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the interface for the spells the player can find in a chest.
 */
public interface Spell extends ChestItem {

    /**
     * This method put the spell the player found in a chest in his inventory.
     */
    void store(FloorManager floorManager);
    
}
