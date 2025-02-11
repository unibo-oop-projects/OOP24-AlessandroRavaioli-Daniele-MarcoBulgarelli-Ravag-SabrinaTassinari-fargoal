package fargoal.controller.input.api;

import fargoal.model.manager.api.MenuManager;

public class MenuInputComponent {
    
    public void update(MenuManager manager, KeyboardInputController ctrl) {
        
        if (ctrl.isInteracting()) {
            manager.select();
        } else if (ctrl.isMoveDown()) {
            manager.decreaseSelected();
        } else if (ctrl.isMoveUp()) {
            manager.increaseSelected();
        }
    }
}
