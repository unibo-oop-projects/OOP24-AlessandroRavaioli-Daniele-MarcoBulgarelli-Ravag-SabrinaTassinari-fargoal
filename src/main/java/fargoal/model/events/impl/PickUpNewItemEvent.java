package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;

public class PickUpNewItemEvent implements FloorEvent{
    
    private final ChestItem item;

    public PickUpNewItemEvent(ChestItem item) {
        this.item = item;
    }

    public ChestItem PickedUpWhat() {
        return this.item;
    }
}
