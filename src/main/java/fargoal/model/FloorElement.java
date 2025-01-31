package model;

import commons.api.Position;

public interface FloorElement {
    
    Position getPosition();

    boolean isColliding();

    String getTag();
}
