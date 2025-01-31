package fargoal.model.entity.monsters.impl;

import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.api.*;
import fargoal.model.map.api.*;

public class Barbarian extends AbstractMonster{

    public Barbarian(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.BARBARIAN);
        setPosition(position);
        setFloorMap(floorMap);
    }

    @Override
    public String getTag() {
        return "BARBARIAN";
    }
    
}
