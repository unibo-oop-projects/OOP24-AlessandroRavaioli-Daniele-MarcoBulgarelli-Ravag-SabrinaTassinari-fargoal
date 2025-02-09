package fargoal.model.core;

import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.events.api.FloorEventListener;
import fargoal.model.events.impl.MonsterEncounterEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.api.View;
import fargoal.view.impl.SwingRendererTop;
import fargoal.view.impl.SwingView;

public class GameEngine implements FloorEventListener {

    private final List<FloorEvent> eventQueue;
    private static final int PERIOD = 20; 
    private final FloorManager manager;
    private final View view;

    public GameEngine() {
        this.view = new SwingView();
        this.manager = new FloorManagerImpl(new GameContext(view), this);
        this.eventQueue = new LinkedList<>();
    }
    
    public void start() {
        while (true) {
            final long currentCycleStartTime = System.currentTimeMillis();
            manager.update(new GameContext(view));
            checkEvents();
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
        this.eventQueue.stream()
                .forEach(p -> {
                    if (p instanceof MonsterEncounterEvent) {
                        MonsterEncounterEvent event = (MonsterEncounterEvent)p;
                        new SwingRendererTop( g2d -> {
                            g2d.setFont(new Font("Arial", Font.PLAIN, 50));
                            g2d.setColor(Color.MAGENTA);
                            g2d.drawString("Ho incontrato " + event.monsterEncountered().getTag(), 25, 50);
                        }, this.view)
                        .render(); 
                    }
                });
        eventQueue.clear();
    }
}
