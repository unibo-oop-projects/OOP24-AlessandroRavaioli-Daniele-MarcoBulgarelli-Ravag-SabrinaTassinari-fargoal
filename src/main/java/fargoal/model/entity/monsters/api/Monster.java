package model.entity.monsters.api;

import model.entity.commons.api.Entity;

public interface Monster extends Entity{
    
    MonsterType getMonsterType();
}
