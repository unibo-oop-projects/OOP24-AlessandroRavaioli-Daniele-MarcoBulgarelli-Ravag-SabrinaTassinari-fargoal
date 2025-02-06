package fargoal.model.interactable.pickUpAble.onGround;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

/**
 * A class that implements the item Beacon, when it is on the ground.
 * When the player is near it he can not be attacked by monster. 
 * When the player cast a teleport spell he is teleported near it.
 */
public class BeaconOnGround implements Interactable{

    final Position position; 

    /**
     * The constructor of the class. When the player put on the ground a beacon that he has in the inventory 
     * it assign the position in which he had been put.
     * @param position - the position where the player put the beacon.
     */
    public BeaconOnGround(final Position position) {
        this.position = position;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "BEACON";
    }

    /** {@inheritDoc} */
    //unattackable
    @Override
    public Interactable interact(FloorManager floorManager) {
        while (floorManager.getPlayer().getPosition() == this.position) {
            floorManager.getPlayer().setIsImmune(true);
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
    }
    
}
