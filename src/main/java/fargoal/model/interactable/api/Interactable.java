package fargoal.model.interactable.api;

import fargoal.model.commons.FloorElement;
import fargoal.model.manager.api.FloorManager;

/**
 * An interectable is an item which the player can interact with. 
 */
public interface Interactable extends FloorElement{

    /**
     * It is the method that let the player interact with the item.
     */
    public Interactable interact(FloorManager floorManager);

}
