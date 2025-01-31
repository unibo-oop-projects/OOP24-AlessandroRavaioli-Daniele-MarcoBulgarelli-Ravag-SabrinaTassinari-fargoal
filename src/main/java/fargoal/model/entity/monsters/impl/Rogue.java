package fargoal.model.entity.monsters.impl;

import fargoal.model.entity.monsters.api.*;
import fargoal.model.map.api.FloorMap;
import fargoal.api.*;

public class Rogue extends AbstractMonster{

    public Rogue(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.ROGUE);
        setPosition(position);
        setFloorMap(floorMap);
    }

    @Override
    public String getTag() {
        return "ROGUE";
    }
    
}
