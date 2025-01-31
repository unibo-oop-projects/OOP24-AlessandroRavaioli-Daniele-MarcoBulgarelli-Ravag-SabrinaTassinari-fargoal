package fargoal.model.entity.monsters.impl;

import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterFactory;

public class MonsterFactoryImpl implements MonsterFactory{

    private AbstractMonster monster;

    @Override
    public AbstractMonster generateRogue() {
        monster = new Rogue();
        return monster;
    }

    @Override
    public AbstractMonster generateBarbarian() {
        monster = new Barbarian();
        return monster;
    }

    @Override
    public AbstractMonster generateMonk() {
        monster = new Monk();
        return monster;
    }

    @Override
    public AbstractMonster generateAssassin() {
        monster = new Assassin();
        return monster;
    }

    @Override
    public AbstractMonster generateWarLord() {
        monster = new WarLord();
        return monster;
    }

    @Override
    public AbstractMonster generateMage() {
        monster = new Mage();
        return monster;
    }

    @Override
    public AbstractMonster generateSpider() {
        monster = new Spider();
        return monster;
    }
    
}
