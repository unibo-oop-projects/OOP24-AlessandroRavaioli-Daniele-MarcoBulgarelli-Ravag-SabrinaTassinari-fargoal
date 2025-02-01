package fargoal.model.entity.player.api;

import fargoal.model.entity.commons.api.Entity;

public interface Player extends Entity{

    Integer getLevel();
    
    void move();

    void attack();

}
