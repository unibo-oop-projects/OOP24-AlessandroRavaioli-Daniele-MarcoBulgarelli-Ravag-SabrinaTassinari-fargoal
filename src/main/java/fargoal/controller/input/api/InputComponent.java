package fargoal.controller.input.api;

import fargoal.model.commons.FloorElement;

public interface InputComponent {

    void update(FloorElement player, InputController c);
}
