package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.*;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.map.api.FloorMap;

public class Monk extends AbstractMonster{

    public Monk(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.MONK);
        setPosition(position);
        setFloorMap(floorMap);
        setSkill(level);
    }

    @Override
    public String getTag() {
        return "MONK";
    }

    @Override
    public void steal(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }

    private void heal() {
        this.getHealth().setToMaxHealth();
    }
    
}
