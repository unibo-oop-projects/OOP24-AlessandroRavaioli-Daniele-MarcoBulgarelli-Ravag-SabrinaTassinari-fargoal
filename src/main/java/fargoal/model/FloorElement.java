package fargoal.model;

import fargoal.api.Position;

public interface FloorElement {
    
    Position getPosition();

    boolean isColliding();

    String getTag();
}
