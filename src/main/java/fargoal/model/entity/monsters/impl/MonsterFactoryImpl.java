package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A class that implements every method of the MonsterFactory,
 * and which methods will be called to generate monsters.
 */
public class MonsterFactoryImpl implements MonsterFactory {

    private AbstractMonster monster;

    @Override
    public Monster generate(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        return monster;
    }

    /**
     * Generate a Rogue.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Rogue
     */
    private Monster generateRogue(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Rogue(position, level, floorMap, floorManager);
        return monster;
    }

    /**
     * Generate a Barbarian.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Barbarian
     */
    private AbstractMonster generateBarbarian(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Barbarian(position, level, floorMap, floorManager);
        return monster;
    }

    /**
     * Generate a Monk.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Monk
     */
    private AbstractMonster generateMonk(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Monk(position, level, floorMap, floorManager);
        return monster;
    }

    /**
     * Generate an Assassin.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Assassin
     */
    private AbstractMonster generateAssassin(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Assassin(position, level, floorMap, floorManager);
        return monster;
    }

    /**
     * Generate a War Lord.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new War Lord
     */
    private AbstractMonster generateWarLord(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new WarLord(position, level, floorMap, floorManager);
        return monster;
    }

    /**
     * Generate a Mage.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Mage
     */
    private AbstractMonster generateMage(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Mage(position, level, floorMap, floorManager);
        return monster;
    }

    /**
     * Generate a Spider.
     * 
     * @param position - the starting position
     * @param level - the level of the floor where the monster is located
     * @param floorMap - the floor where the monster is located
     * @param floorManager - to get infos also about other entities
     * @return a new Spider
     */
    private AbstractMonster generateSpider(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Spider(position, level, floorMap, floorManager);
        return monster;
    }
    
}
