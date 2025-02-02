package fargoal.model.manager.api;

import fargoal.controller.input.api.Command;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;

public interface FloorManager {
    
    void update(Command input);

    Player getPlayer();
}
