package fargoal.model.interactable.pickUpAble.onGround;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.PickUpSword;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * This is the class that implements the Sword of Fargoal, the target of the player.
 */
public class SwordOfFargoal implements Interactable{

    final Position position;
    final Integer mapLevel;
    private Renderer renderer;

    /**
     * This is the constructor of the class. 
     * @param position - the position of the Sword in the map.
     */
    public SwordOfFargoal(final Position position, final RenderFactory renderFactory, final Integer mapLevel) {
        this.position = position;
        this.mapLevel = mapLevel;
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

    /**
     * Getter for the field mapLevel
     * @return the level the sword can be found.
     */
    public Integer getMapLevel() {
        return this.mapLevel;
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
        floorManager.getPlayer().addExperiencePoints(floorManager.getPlayer().getExperiencePoints());
        floorManager.notifyFloorEvent(new PickUpSword(this));
        return this;
    }
    
}
