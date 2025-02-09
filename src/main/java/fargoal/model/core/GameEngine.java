package fargoal.model.core;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.api.View;
import fargoal.view.impl.SwingView;

public class GameEngine {

    private static final int PERIOD = 20;
    private final FloorManager manager;
    private final View view;
    private KeyboardInputController controller;

    public GameEngine() {
        this.view = new SwingView(controller);
        this.manager = new FloorManagerImpl(new GameContext(view), controller);
    }
    
    public void start() {
        long previousCycleStartTime = System.currentTimeMillis();
        while (true) {
            final long currentCycleStartTime = System.currentTimeMillis();
            long elapsed = currentCycleStartTime - previousCycleStartTime;
            manager.update(new GameContext(view), elapsed);
            view.update();
            waitToNextFrame(currentCycleStartTime);
            previousCycleStartTime = currentCycleStartTime;
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
