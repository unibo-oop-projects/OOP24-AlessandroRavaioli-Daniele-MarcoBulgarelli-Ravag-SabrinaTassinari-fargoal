package fargoal.model.entity.player.api;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Entity;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.monsters.api.Monster;

public interface Player extends Entity {

    Integer getLevel();

    Integer getExperiencePoints();

    Inventory getInventory();

    boolean hasSword();

    void move();

    Integer doDamage(Monster monster);


}
