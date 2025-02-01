package fargoal.model;

import fargoal.commons.api.Position;

public interface FloorElement {
    
    Position getPosition();

    boolean isColliding();

    String getTag();
}
