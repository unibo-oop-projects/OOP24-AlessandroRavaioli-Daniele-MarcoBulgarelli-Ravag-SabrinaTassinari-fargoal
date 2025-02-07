package fargoal.model.interactable.pickUpAble.onGround;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.Renderer;

/**
 * This is the class that implements the Sword of Fargoal, the target of the player.
 */
public class SwordOfFargoal implements Interactable{

    final Position position;
    private Renderer renderer;

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
    }

    /**
     * Getter for the field renderer.
     * @return the renderer.
     */
    public Renderer getRenderer() {
        return this.renderer;
    }

    /**
     * Setter for field renderer.
     * @param renderer - the new renderer.
     */
    public void setRender(final Renderer renderer) {
        this.renderer = renderer;
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.getPlayer().setHasSword(true);
        //guarda cosa fa la spada a chi la prende (quanta esperienza o skill dà)
        return this;
    }
    
}
