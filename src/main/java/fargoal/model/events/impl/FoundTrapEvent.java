package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;

public class FoundTrapEvent implements FloorEvent {
    
    private final FloorElement floorElement;

    public FoundTrapEvent(FloorElement floorElement) {
        this.floorElement = floorElement;
    }

    public FloorElement TypeOfTrap() {
        return this.floorElement;
    }
}
