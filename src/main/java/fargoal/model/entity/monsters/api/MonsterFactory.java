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
     * Generate a Rogue.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Rogue
     */
    AbstractMonster generateRogue(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);

    /**
     * Generate a Barbarian.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Barbarian
     */
    AbstractMonster generateBarbarian(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);

    /**
     * Generate a Monk.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Monk
     */
    AbstractMonster generateMonk(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);

    /**
     * Generate an Assassin.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Assassin
     */
    AbstractMonster generateAssassin(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);

    /**
     * Generate a War Lord.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new War Lord
     */
    AbstractMonster generateWarLord(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);

    /**
     * Generate a Mage.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Mage
     */
    AbstractMonster generateMage(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);

    /**
     * Generate a Spider.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Spider
     */
    AbstractMonster generateSpider(Position position, Integer level, FloorMap floorMap, FloorManager floorManager);
}
