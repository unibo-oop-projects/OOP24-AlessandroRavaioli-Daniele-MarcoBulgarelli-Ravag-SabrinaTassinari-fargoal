package fargoal.model.core;

import fargoal.view.api.View;

public class GameContext {
    
    private final View view;

    public GameContext(View view) {
        this.view = view;
    }

    public View getView() {
        return this.view;
    }
}
