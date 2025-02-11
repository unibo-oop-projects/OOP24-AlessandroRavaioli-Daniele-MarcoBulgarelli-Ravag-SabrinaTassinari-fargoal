package fargoal.model.manager.api;

import fargoal.model.core.GameEngine;

public interface SceneManager {
    
    void update(GameEngine engine);

    void setSceneManager(GameEngine engine);
}
