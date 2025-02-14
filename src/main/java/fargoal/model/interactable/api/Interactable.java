package fargoal.model.interactable.api;

import fargoal.model.commons.FloorElement;
import fargoal.model.manager.api.FloorManager;

/**
 * An interectable is an item which the player can interact with. The item is 
 * on the ground.
 */
public interface Interactable extends FloorElement {

    /**
     * It is the method that let the player interact with the item.
     * @param floorManager - it contains all the elements of the floor.
     * @return the interectable with which the player has interacted.
     */
    Interactable interact(FloorManager floorManager);

    boolean exists();

}
