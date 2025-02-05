package fargoal.model.entity.player.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;

public class PlayerImpl implements Player {

    private Integer level;
    private Health health;
    private Position position;
    private Integer skill;
    
    @Override
    public Health getHealth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHealth'");
    }

    @Override
    public Position getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }

    @Override
    public Integer getSkill() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSkill'");
    }

    @Override
    public String getTag() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTag'");
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public Integer attack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public Integer getLevel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLevel'");
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Integer receiveDamage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveDamage'");
    }
}
