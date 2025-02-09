package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;

public class ReceiveAttackEvent implements FloorEvent {
    
    private final FloorElement floorElement;

    public ReceiveAttackEvent(FloorElement floorElement) {
        this.floorElement = floorElement;
    }

    public FloorElement AttackedFrom() {
        return this.floorElement;
    }
}
