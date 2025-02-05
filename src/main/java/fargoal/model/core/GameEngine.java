package fargoal.model.core;

import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.api.View;
import fargoal.view.impl.SwingView;

public class GameEngine {

    private static final int PERIOD = 20; 
    private final FloorManager manager;
    private final View view;

    public GameEngine() {
        this.view = new SwingView();
        this.manager = new FloorManagerImpl(new GameContext(view));
    }
    
    public void start() {
        while (true) {
            final long currentCycleStartTime = System.currentTimeMillis();
            manager.update(new GameContext(view));
            view.update();
            waitToNextFrame(currentCycleStartTime);
        }
    }

    private void waitToNextFrame(final long startTime) {
        final long delta = System.currentTimeMillis() - startTime;
        if (delta < PERIOD) {
            try {
                Thread.sleep(PERIOD - delta);
            } catch (Exception e) { }
        }
    }
}
