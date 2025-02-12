package fargoal.controller.input.api;

import fargoal.model.manager.api.SceneManager;

/**
 * Interface that update the position of FloorElements involved 
 * in changes based on inputs.
 */
public interface InputComponent {
    /**
     * Method that update the position/status of the FloorElements involved
     * in input's changes.
     * 
     * @param manager - to get alla necessary infos
     * @param player - to make changes based on what player does
     * @param c - to check which input to process
     */
    void update(SceneManager manager, InputController c);
}
