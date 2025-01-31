package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.*;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.map.api.FloorMap;

public class Monk extends AbstractMonster{

    public Monk(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.MONK);
        setPosition(position);
        setFloorMap(floorMap);
    }

    @Override
    public String getTag() {
        return "MONK";
    }
    
}
