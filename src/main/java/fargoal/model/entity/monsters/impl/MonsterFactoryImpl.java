package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.*;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.map.api.FloorMap;

public class MonsterFactoryImpl implements MonsterFactory{

    private AbstractMonster monster;

    @Override
    public AbstractMonster generateRogue(Position position, Integer level, FloorMap floorMap) {
        monster = new Rogue(position, level, floorMap);
        return monster;
    }

    @Override
    public AbstractMonster generateBarbarian(Position position, Integer level, FloorMap floorMap) {
        monster = new Barbarian(position, level, floorMap);
        return monster;
    }

    @Override
    public AbstractMonster generateMonk(Position position, Integer level, FloorMap floorMap) {
        monster = new Monk(position, level, floorMap);
        return monster;
    }

    @Override
    public AbstractMonster generateAssassin(Position position, Integer level, FloorMap floorMap) {
        monster = new Assassin(position, level, floorMap);
        return monster;
    }

    @Override
    public AbstractMonster generateWarLord(Position position, Integer level, FloorMap floorMap) {
        monster = new WarLord(position, level, floorMap);
        return monster;
    }

    @Override
    public AbstractMonster generateMage(Position position, Integer level, FloorMap floorMap) {
        monster = new Mage(position, level, floorMap);
        return monster;
    }

    @Override
    public AbstractMonster generateSpider(Position position, Integer level, FloorMap floorMap) {
        monster = new Spider(position, level, floorMap);
        return monster;
    }
    
}
