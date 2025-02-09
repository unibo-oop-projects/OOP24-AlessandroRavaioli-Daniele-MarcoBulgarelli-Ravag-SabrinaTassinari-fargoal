package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.interactable.api.Usable;

public class PickUpNewItemEvent implements FloorEvent{
    
    private final Usable item;

    public PickUpNewItemEvent(Usable item) {
        this.item = item;
    }

    public Usable PickedUpWhat() {
        return this.item;
    }
}
