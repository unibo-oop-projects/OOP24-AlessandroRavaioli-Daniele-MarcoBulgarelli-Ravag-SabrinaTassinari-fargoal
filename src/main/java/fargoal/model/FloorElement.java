package fargoal.model;

import fargoal.commons.api.Position;
import fargoal.model.manager.api.FloorManager;

public interface FloorElement {
    
    Position getPosition();

    boolean isColliding();

    String getTag();

    void update(FloorManager floorManager);
}
