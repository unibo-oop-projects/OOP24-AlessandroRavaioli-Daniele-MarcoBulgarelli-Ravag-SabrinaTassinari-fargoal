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
        setSkill(level); 
        setVisibilityOff();
    }

    @Override
    public String getTag() {
        return "ASSASSIN";
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
