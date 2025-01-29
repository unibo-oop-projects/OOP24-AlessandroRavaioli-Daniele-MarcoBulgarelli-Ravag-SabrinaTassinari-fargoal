package model.map;

import commons.api.Position;

public interface FloorMap {
    
    boolean isTile(Position pos);

    boolean isVisible(Position pos);

    void resetVisibility();

    void setVisible(Position pos);
}
