package fargoal.controller.input.api;

import fargoal.model.manager.api.MenuManager;

/**
 * Class that work to receive and process the inputs
 * from the TitleScreen.
 */
public class MenuInputComponent {
    /**
     * Method that updates the TitleScreen based on the input that receives.
     * 
     * @param manager - to get the necessary infos
     * @param ctrl - to get the inputs
     */
    public void update(final MenuManager manager, final KeyboardInputController ctrl) {
        if (ctrl.isInteracting()) {
            manager.select();
        } else if (ctrl.isMoveDown()) {
            manager.decreaseSelected();
        } else if (ctrl.isMoveUp()) {
            manager.increaseSelected();
        }
    }
}
