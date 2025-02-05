package fargoal.model.interactable.pickUpAble.onGround;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the class that implements the Sword of Fargoal, the target of the player.
 */
public class SwordOfFargoal implements Interactable{

    final Position position;

    /**
     * This is the constructor of the class. 
     * @param position - the position of the Sword in the map.
     */
    public SwordOfFargoal(final Position position) {
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
        return "SWORD OF FARGOAL";
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.getPlayer().setHasSword(true);
        
        return this;
    }
    
}
