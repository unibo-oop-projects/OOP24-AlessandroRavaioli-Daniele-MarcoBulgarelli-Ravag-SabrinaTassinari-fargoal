package fargoal.model.interactable.stair.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * A class that models an object that allows to go further down the dungeon
 */
public class DownStairs implements Stairs {

    private final Position position;
    private Renderer renderer;

    /**
     * This is the constructor of the class. It set the position of the stair.
     * @param pos - the position of the stairs.
     * @param renderFactory - a factory to create the renderer of all the elements of the floor.
     */
    public DownStairs(Position pos, RenderFactory renderFactory) {
        this.position = pos;
        this.setRender(renderFactory.downstairRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.increaseFloorLevel();
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
        return "DownStairs";
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
    public void update(FloorManager floorManager) {
        
    }
    
}
