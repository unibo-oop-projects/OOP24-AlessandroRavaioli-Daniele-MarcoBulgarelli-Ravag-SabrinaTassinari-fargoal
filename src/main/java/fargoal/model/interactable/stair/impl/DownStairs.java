package fargoal.model.interactable.stair.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.stair.api.Stairs;
import fargoal.model.manager.api.FloorManager;

/**
 * A class that models an object that allows to go further down the dungeon
 */
public class DownStairs implements Stairs {

    private final Position position;

    public DownStairs(Position pos) {
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
        return "DownStairs";
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
