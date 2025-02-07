package fargoal.model.interactable.stair.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.Renderer;

/**
 * A class that implements an object that allows to go back up the dungeon
 */
public class UpStairs implements Stairs {

    private final Position position;
    private Renderer renderer;

    public UpStairs(Position pos) {
        this.position = pos;
    }

    @Override
    public Interactable interact(FloorManager floorManager) {
        floorManager.decreaseFloorLevel();
        return this;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public String getTag() {
        return "UpStairs";
    }

    /**
     * Getter for field renderer.
     * @return the renderer.
     */
    public Renderer getRenderer() {
        return this.renderer;
    }

    /**
     * Setter for field renderer.
     * @param renderer - the new renderer.
     */
    public void setRenderer(final Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
