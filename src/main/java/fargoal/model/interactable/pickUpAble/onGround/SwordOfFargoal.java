package fargoal.model.interactable.pickUpAble.onGround;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
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
    public SwordOfFargoal(final Position position, final RenderFactory renderFactory) {
        this.position = position;
        this.setRender(renderFactory.swordRenderer(this));
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

    /** {@inheritDoc} */
    @Override
    public void render() {
        this.renderer.render();
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
