package fargoal.model.entity.monsters.api;

import fargoal.commons.api.Position;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A factory to generate any type of monster that may be present
 * on the map.
 */
public interface MonsterFactory {

    Monster generate(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);

}
