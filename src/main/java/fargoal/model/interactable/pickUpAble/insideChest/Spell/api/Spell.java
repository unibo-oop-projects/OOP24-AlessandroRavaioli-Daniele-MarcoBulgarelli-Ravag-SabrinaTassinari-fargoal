package fargoal.model.interactable.pickUpAble.insideChest.Spell.api;

import fargoal.model.interactable.pickUpAble.insideChest.api.ItemsForInventory;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the interface for the spells the player can find in a chest.
 */
public interface Spell extends ItemsForInventory {

    void update(FloorManager floorManager);

    Integer getQuantity();

    void addSpell();

    void removeSpell();
}
