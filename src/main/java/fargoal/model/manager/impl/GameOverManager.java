package fargoal.model.manager.impl;

import fargoal.model.core.GameEngine;
import fargoal.model.manager.api.SceneManager;

public class GameOverManager implements SceneManager{

    private static final int NUMBER_OF_OPTIONS = 2;

    private int selected;

    @Override
    public void update(GameEngine engine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void setSceneManager(GameEngine engine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSceneManager'");
    }
    
    public void increaseSelected() {
        this.selected++;
        if (this.selected > NUMBER_OF_OPTIONS) {
            this.selected = 1;
        }
    }

    public void decreaseSelected() {
        this.selected--;
        if (this.selected < 1) {
            this.selected = NUMBER_OF_OPTIONS;
        }
    }
}
