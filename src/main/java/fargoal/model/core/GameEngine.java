package fargoal.model.core;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.model.manager.api.SceneManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.manager.impl.TitleScreenManager;
import fargoal.view.api.View;
import fargoal.view.impl.SwingView;

public class GameEngine {

    private static final int PERIOD = 20;
    private SceneManager manager;
    private final View view;
    private KeyboardInputController controller;
    private long elapsed;

    public GameEngine() {
        this.controller = new KeyboardInputController();
        this.view = new SwingView(controller);
        this.manager = new TitleScreenManager(this);
    }
    
    public void start() {
        long previousCycleStartTime = System.currentTimeMillis();
        while (true) {
            final long currentCycleStartTime = System.currentTimeMillis();
            elapsed = currentCycleStartTime - previousCycleStartTime;
            manager.update(this);
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

    public void stop() {
        System.exit(0);
    }

    public long getElapsedTime() {
        return this.elapsed;
    }

    public void setSceneManager(SceneManager manager) {
        this.manager = manager;
    }

    public KeyboardInputController getController() {
        return this.controller;
    }

    public View getView() {
        return this.view;
    }
}
