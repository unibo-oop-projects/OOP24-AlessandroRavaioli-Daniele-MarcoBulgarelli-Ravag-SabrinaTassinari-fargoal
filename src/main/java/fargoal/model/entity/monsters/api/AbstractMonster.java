package fargoal.model.entity.monsters.api;

import fargoal.api.Position;
import fargoal.model.entity.commons.api.*;


public abstract class AbstractMonster implements Monster{

    private MonsterType monsterType;
    private Health health;
    private Position position;
    private Integer skill;
    
    @Override
    public MonsterType getMonsterType() {
        return this.monsterType;
    }

    @Override
    public Integer getHealth() {
        return this.health.getCurrentHealth();
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Integer getSkill() {
        return this.skill;
    }

    public boolean isColliding() {
        return false;
    }

    public abstract void move();
    
}
