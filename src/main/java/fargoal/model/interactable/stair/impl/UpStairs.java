package fargoal.model.interactable.stair.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.manager.api.FloorManager;

/**
 * A class that implements an object that allows to go back up the dungeon
 */
public class UpStairs implements Stairs {

    private final Position position;

    public UpStairs(Position pos) {
        this.position = pos;
    }

    @Override
    public void interact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public boolean isColliding() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isColliding'");
    }

    @Override
    public String getTag() {
        return "UpStairs";
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
