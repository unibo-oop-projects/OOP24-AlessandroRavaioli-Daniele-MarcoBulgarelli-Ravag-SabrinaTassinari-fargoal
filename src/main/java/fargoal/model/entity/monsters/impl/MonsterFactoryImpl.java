package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.map.api.FloorMap;

/**
 * A class that implements every method of the MonsterFactory,
 * and which methods will be called to generate monsters.
 */
public class MonsterFactoryImpl implements MonsterFactory {

    private AbstractMonster monster;

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateRogue(Position position, Integer level, FloorMap floorMap) {
        monster = new Rogue(position, level, floorMap);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateBarbarian(Position position, Integer level, FloorMap floorMap) {
        monster = new Barbarian(position, level, floorMap);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateMonk(Position position, Integer level, FloorMap floorMap) {
        monster = new Monk(position, level, floorMap);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateAssassin(Position position, Integer level, FloorMap floorMap) {
        monster = new Assassin(position, level, floorMap);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateWarLord(Position position, Integer level, FloorMap floorMap) {
        monster = new WarLord(position, level, floorMap);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateMage(Position position, Integer level, FloorMap floorMap) {
        monster = new Mage(position, level, floorMap);
        return monster;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractMonster generateSpider(Position position, Integer level, FloorMap floorMap) {
        monster = new Spider(position, level, floorMap);
        return monster;
    }
    
}
