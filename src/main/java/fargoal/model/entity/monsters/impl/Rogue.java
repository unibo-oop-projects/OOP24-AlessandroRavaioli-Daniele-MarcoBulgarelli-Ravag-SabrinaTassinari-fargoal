package fargoal.model.entity.monsters.impl;

import fargoal.model.entity.monsters.api.*;

public class Rogue extends AbstractMonster{

    monsterType = monsterType.ROGUE;

    @Override
    public String getTag() {
        return "ROGUE";
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
