package fargoal.model.manager.api;

import java.util.List;

import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;

public interface FloorManager {
    
    void update(GameContext context);

    Player getPlayer();

    List<Monster> getMonsters();
}
