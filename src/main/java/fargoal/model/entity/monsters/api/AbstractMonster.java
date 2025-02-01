package fargoal.model.entity.monsters.api;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.*;
import fargoal.model.entity.player.api.Player;
import fargoal.model.map.api.*;

public abstract class AbstractMonster implements Monster{

    private final Integer POSSIBLE_DIRECTIONS = 2;
    private FloorMap floorMap;
    private MonsterType monsterType;
    private Health health;
    private Position position;
    private Integer skill;
    private boolean isVisible = false;
    private final Random random = new Random();
    
    @Override
    public MonsterType getMonsterType() {
        return this.monsterType;
    }

    @Override
    public Health getHealth() {
        return this.health;
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

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSkill(Integer level) {
        this.skill = level * getRandom(level);
    }

    public Integer getRandom(int num) {
        return random.nextInt(num);
    }

    public void setFloorMap(FloorMap floorMap) {
        this.floorMap = floorMap;
    }

    public FloorMap getFloorMap() {
        return this.floorMap;
    }

    public void setVisibilityOn() {
        this.isVisible = true;
    }

    public void setVisibilityOff() {
        this.isVisible = false;
    }

    public void move() {
        Position pos;
        do {
            pos = getPosition().add(new Position(getRandom(POSSIBLE_DIRECTIONS), getRandom(POSSIBLE_DIRECTIONS)));
        } while(getFloorMap().isTile(pos));
        setPosition(pos);
    }

    public void attack(Player player) {
        var ratio = player.getSkill()/this.getSkill();
        player.getHealth().decreaseHealth(getRandom(4 * player.getLevel() * ratio));
    }

    public abstract void steal(Player player);
    
}
