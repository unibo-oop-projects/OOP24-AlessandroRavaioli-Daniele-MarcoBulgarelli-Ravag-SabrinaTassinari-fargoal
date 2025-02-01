package fargoal.model.map.api;

import fargoal.commons.api.Position;

public interface FloorMap {

    boolean isTile(Position pos);

    Dimension getSize();
}
