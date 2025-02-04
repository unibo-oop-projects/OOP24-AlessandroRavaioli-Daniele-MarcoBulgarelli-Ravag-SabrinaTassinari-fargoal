package fargoal.model.commons;

import fargoal.commons.api.Position;
import fargoal.model.manager.api.FloorManager;

public interface FloorElement {
    
    Position getPosition();

    String getTag();

    void update(FloorManager floorManager);
}
