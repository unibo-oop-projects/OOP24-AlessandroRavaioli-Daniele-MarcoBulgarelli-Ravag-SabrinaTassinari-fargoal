package fargoal.model.interactable.stair.impl;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.WalkOverEvent;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * A class that models an object that allows to go further down the dungeon.
 */
public class DownStairs implements Stairs {

    private final Position position;
    private Renderer renderer;
    private Position lastPlayerPosition;

    /**
     * This is the constructor of the class. It set the position of the stair.
     * @param pos - the position of the stairs.
     * @param renderFactory - a factory to create the renderer of all the elements of the floor.
     */
    public DownStairs(final Position pos, final RenderFactory renderFactory) {
        this.position = pos;
        this.setRenderer(renderFactory);
    }

    /** {@inheritDoc} */
    @Override
    public final Interactable interact(final FloorManager floorManager) {
        floorManager.increaseFloorLevel();
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public final String getTag() {
        return "Stairs going down";
    }

    /** {@inheritDoc} */
    @Override
    public final void render() {
        this.renderer.render();
    }

    /** {@inheritDoc} */
    @Override
    public final void update(final FloorManager floorManager) {
        if (!floorManager.getPlayer().getPosition().equals(lastPlayerPosition)
                && floorManager.getPlayer().getPosition().equals(this.position)) {
            floorManager.notifyFloorEvent(new WalkOverEvent(this));
        }
        this.lastPlayerPosition = floorManager.getPlayer().getPosition();
    }

    private void setRenderer(final RenderFactory rf) {
        this.renderer = rf.downstairRenderer(this);
    }

    @Override
    public boolean exists() {
        return true;
    }

}
