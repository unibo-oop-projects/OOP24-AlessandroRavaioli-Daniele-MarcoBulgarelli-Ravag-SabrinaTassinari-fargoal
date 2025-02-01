package fargoal.model.core;

import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;

public class GameEngine {

    private static final int period = 20; 
    private final FloorManager manager;

    public GameEngine() {
        this.manager = new FloorManagerImpl();
    }
    
    public void start() {
        long previousCycleStartTime = System.currentTimeMillis();
        while (true) {
            long currentCycleStartTime = System.currentTimeMillis();
            manager.update(null);
            waitToNextFrame(currentCycleStartTime);
            System.out.println("Sono partito");
            previousCycleStartTime = currentCycleStartTime;
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
