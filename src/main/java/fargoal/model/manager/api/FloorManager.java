package fargoal.model.manager.api;

import java.util.List;

import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.map.api.FloorMap;

public interface FloorManager {
    
    void update(GameContext context);

    Player getPlayer();

    List<Monster> getMonsters();

    FloorMap getFloorMap();
}
