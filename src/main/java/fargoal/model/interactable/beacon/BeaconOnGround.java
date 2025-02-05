package fargoal.model.interactable.beacon;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

/**
 * A class that implements the item Beacon, when it is on the ground.
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
    public void interact(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
