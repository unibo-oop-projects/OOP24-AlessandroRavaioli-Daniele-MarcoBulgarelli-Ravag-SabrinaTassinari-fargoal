package fargoal.model.core;

import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.api.View;
import fargoal.view.impl.SwingView;

public class GameEngine {

    private static final int period = 20; 
    private final FloorManager manager;
    private final View view;

    public GameEngine() {
        this.view = new SwingView();
        this.manager = new FloorManagerImpl(new GameContext(view));
    }
    
    public void start() {
        while (true) {
            long currentCycleStartTime = System.currentTimeMillis();
            manager.update(new GameContext(view));
            view.update();
            waitToNextFrame(currentCycleStartTime);
        }
    }

    private void waitToNextFrame(final long startTime) {
        long delta = System.currentTimeMillis() - startTime;
        if (delta < period) {
            try {
                Thread.sleep(period - delta);
            } catch (Exception e) { }
        }
    }
}
