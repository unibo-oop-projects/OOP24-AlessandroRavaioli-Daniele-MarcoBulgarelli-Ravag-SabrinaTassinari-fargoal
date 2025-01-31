package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.map.api.FloorMap;

public class Assassin extends AbstractMonster{

    public Assassin(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.ASSASSIN);
        setPosition(position); 
        setFloorMap(floorMap); 
    }

    @Override
    public String getTag() {
        return "ASSASSIN";
    }
    
}
