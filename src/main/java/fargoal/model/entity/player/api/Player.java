package fargoal.model.entity.player.api;

import fargoal.model.entity.commons.api.Entity;
import fargoal.model.entity.player.impl.InventoryImpl;

public interface Player extends Entity {

    Integer getLevel();
    
    void move();

    Integer attack();

    Inventory getInventory();
}
