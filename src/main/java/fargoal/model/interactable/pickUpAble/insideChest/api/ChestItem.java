package fargoal.model.interactable.pickUpAble.insideChest.api;

import fargoal.model.interactable.api.Usable;

/**
 * The interface for the items in the chest, such as spells, traps and utilities. 
 */
public interface ChestItem extends Usable{

    /**
     * With this method, the type of the chest item is known.
     * @return the type of the chest item (if it is a trap, a spell or a utility).
     */
    String getChestItemType();

    /**
     * with this method, the name of the chest item is known.
     * @return the name of the chest item.
     */
    String getChestItemName();
    
}
