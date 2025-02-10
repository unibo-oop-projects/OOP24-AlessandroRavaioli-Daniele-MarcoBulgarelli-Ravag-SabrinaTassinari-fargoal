package fargoal.controller.input.api;

import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.manager.api.FloorManager;

public interface InputComponent {

    void update(FloorManager manager, PlayerImpl player, InputController c);
}
