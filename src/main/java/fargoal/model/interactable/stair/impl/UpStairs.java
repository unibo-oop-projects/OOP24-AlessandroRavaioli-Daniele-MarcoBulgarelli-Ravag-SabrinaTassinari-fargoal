package fargoal.model.interactable.stair.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * A class that implements an object that allows to go back up the dungeon
 */
public class UpStairs implements Stairs {

    private final Position position;
    private Renderer renderer;

    /**
     * This is the constructor of the class. It set the position of the stair.
     * @param pos - the position of the stairs.
     * @param renderFactory - a factory to create the renderer of all the elements of the floor.
     */
    public UpStairs(Position pos, final RenderFactory renderFactory) {
        this.position = pos;
        this.setRenderer(renderFactory.upstairRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.decreaseFloorLevel();
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "UpStairs";
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
    public void setRenderer(final Renderer renderer) {
        this.renderer = renderer;
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        
    }
}
