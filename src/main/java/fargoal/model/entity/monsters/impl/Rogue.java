package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.*;
import fargoal.model.entity.monsters.api.*;
import fargoal.model.map.api.FloorMap;

public class Rogue extends AbstractMonster{

    public Rogue(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.ROGUE);
        setPosition(position);
        setFloorMap(floorMap);
        setSkill(level);
    }

    @Override
    public String getTag() {
        return "ROGUE";
    }

    @Override
    public void attack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public void steal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }
    
}
