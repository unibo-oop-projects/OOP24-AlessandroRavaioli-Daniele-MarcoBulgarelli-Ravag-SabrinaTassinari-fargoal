package fargoal.model.core;

import java.util.LinkedList;
import java.util.List;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.events.api.FloorEventListener;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.api.View;
import fargoal.view.impl.SwingView;

public class GameEngine implements FloorEventListener {

    private final List<FloorEvent> eventQueue;
    private static final int PERIOD = 20; 
    private final FloorManager manager;
    private final View view;

    public GameEngine() {
        this.view = new SwingView();
        this.manager = new FloorManagerImpl(new GameContext(view));
        this.eventQueue = new LinkedList<>();
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

    @Override
    public void notifyEvent(FloorEvent floorEvent) {
        this.eventQueue.add(floorEvent);
    }

    private void checkEvents() {
        
    }
}
