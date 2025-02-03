package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
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

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateRogue(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Rogue(position, level, floorMap, floorManager);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateBarbarian(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Barbarian(position, level, floorMap, floorManager);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateMonk(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Monk(position, level, floorMap, floorManager);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateAssassin(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Assassin(position, level, floorMap, floorManager);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateWarLord(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new WarLord(position, level, floorMap, floorManager);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateMage(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Mage(position, level, floorMap, floorManager);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateSpider(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        monster = new Spider(position, level, floorMap, floorManager);
        return monster;
    }
    
}
