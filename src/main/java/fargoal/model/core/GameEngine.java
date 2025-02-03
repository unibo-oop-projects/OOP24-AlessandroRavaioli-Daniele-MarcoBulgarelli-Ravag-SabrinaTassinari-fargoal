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
        this.manager = new FloorManagerImpl();
        this.view = new SwingView();
    }
    
    public void start() {
        while (true) {
            long currentCycleStartTime = System.currentTimeMillis();
            manager.update(null);
            view.update();
            waitToNextFrame(currentCycleStartTime);
            System.out.println("Sono partito");
            System.exit(0);
        }
    }

    private void waitToNextFrame(long startTime) {
        long delta = System.currentTimeMillis() - startTime;
        if (delta < period) {
            try {
                Thread.sleep(period - delta);
            } catch (Exception e) { }
        }
    }
}
