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


    public DownStairs(Position pos, RenderFactory renderFactory) {
        this.position = pos;
        this.setRender(renderFactory.downstairRenderer(this));
    }

    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.increaseFloorLevel();
        return this;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

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

    @Override
    public void update(FloorManager floorManager) {
        
    }
    
}
