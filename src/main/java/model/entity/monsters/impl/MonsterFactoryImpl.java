package model.entity.monsters.impl;

import model.entity.monsters.api.AbstractMonster;
import model.entity.monsters.api.MonsterFactory;

public class MonsterFactoryImpl implements MonsterFactory{

    private AbstractMonster monster;

    @Override
    public AbstractMonster generateRogue() {
        monster = new Rogue();
        return monster;
    }

    @Override
    public AbstractMonster generateBarbarian() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateBarbarian'");
    }

    @Override
    public AbstractMonster generateMonk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateMonk'");
    }

    @Override
    public AbstractMonster generateAssassin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateAssassin'");
    }

    @Override
    public AbstractMonster generateWarLord() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateWarLord'");
    }

    @Override
    public AbstractMonster generateMage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateMage'");
    }
    
}
