package fargoal.model.manager.api;

import fargoal.model.core.GameContext;

public interface FloorMask {
    
    void resetMask();

    void update(GameContext context, FloorManager manager);
}
