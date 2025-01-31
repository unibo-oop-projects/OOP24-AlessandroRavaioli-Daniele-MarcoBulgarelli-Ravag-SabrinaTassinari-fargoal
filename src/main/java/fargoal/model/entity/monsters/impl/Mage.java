package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.map.api.FloorMap;

public class Mage extends AbstractMonster{

    public Mage(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.MAGE);
        setPosition(position);
        setFloorMap(floorMap);
    }

    @Override
    public String getTag() {
        return "MAGE";
    }
    
}
