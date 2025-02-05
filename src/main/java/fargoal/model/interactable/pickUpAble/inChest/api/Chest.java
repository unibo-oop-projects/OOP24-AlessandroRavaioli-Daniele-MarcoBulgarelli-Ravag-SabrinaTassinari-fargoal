package fargoal.model.interactable.pickUpAble.inChest.api;

import fargoal.model.interactable.api.Interactable;

/**
 * A chest is an item on the ground, which do not move. Inside a chest the player can found spells, utilities or traps.
 */
public interface Chest extends Interactable{
    
    /**
     * Generate randomly an item in the chest
     * @return the name of the item that is in the chest
     */
    public String getChestItem();

}
