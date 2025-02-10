package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;

public class WalkOverEvent implements FloorEvent {
    
    private final FloorElement element;

    public WalkOverEvent(FloorElement element) {
        this.element = element;
    }

    public FloorElement getOnWhat() {
        return this.element;
    }
}
