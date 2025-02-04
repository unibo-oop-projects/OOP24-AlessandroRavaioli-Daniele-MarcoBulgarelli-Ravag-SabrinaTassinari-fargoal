package fargoal.model.entity.monsters.api;

import fargoal.commons.api.Position;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A factory to generate any type of monster that may be present
 * on the map.
 */
public interface MonsterFactory {

    /**
     * Method to generate a random monster, based on the floor where the 
     * player is currently located
     * 
     * @param position - the starting position
     * @param floorMap - the floormap where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a Monster
     */
    Monster generate(Position position, FloorMap floorMap, FloorManager floorManager);

}
