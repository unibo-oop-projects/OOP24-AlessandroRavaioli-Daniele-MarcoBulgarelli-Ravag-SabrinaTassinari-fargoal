package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;

public class PickUpSword implements FloorEvent{

    private final FloorElement sword;

    public PickUpSword(final FloorElement sword) {
        this.sword = sword;
    }

    public FloorElement pickedUp() {
        return this.sword;
    }
    
}
