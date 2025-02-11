package fargoal.model.interactable.pickUpAble.onGround;

import java.util.Optional;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.PickUpSword;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * This is the class that implements the Sword of Fargoal, the target of the player.
 */
public class SwordOfFargoal implements Interactable {

    private Optional<Position> position;
    private final Integer mapLevel;
    private Renderer renderer;

    /**
     * This is the constructor of the class. 
     * @param renderFactory - the factory from which the renderer needed is taken.
     * @param mapLevel - this is the floor level where the sword is.
     */
    public SwordOfFargoal(final RenderFactory renderFactory, final Integer mapLevel) {
        this.position = Optional.empty();
        this.mapLevel = mapLevel;
        this.setRender(renderFactory.swordRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public final Position getPosition() {
        return this.position.get();
    }

    /**
     * Setter for the position of the sword.
     * @param position - the position of the sword in the levelthe player is.
     */
    public final void setPosition(final Position position) {
        this.position = Optional.of(position);
    }

    /** {@inheritDoc} */
    @Override
    public final String getTag() {
        return "SWORD OF FARGOAL";
    }

    /**
     * Getter for the field mapLevel.
     * @return the level the sword can be found.
     */
    public final Integer getMapLevel() {
        return this.mapLevel;
    }

    /** {@inheritDoc} */
    @Override
    public final void update(final FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public final void render() {
        this.renderer.render();
    }

    /**
     * Setter for field renderer.
     * @param renderer - the new renderer.
     */
    public final void setRender(final Renderer renderer) {
        this.renderer = renderer;
    }

    /** {@inheritDoc} */
    @Override
    public final Interactable interact(final FloorManager floorManager) {
        floorManager.getPlayer().setHasSword(true);
        floorManager.getPlayer().addExperiencePoints(floorManager.getPlayer().getExperiencePoints());
        floorManager.notifyFloorEvent(new PickUpSword(this));
        return this;
    }

}
