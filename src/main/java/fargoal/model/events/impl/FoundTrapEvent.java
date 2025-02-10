package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;

public class FoundTrapEvent implements FloorEvent {
    
    private final ChestItem chestItem;

    public FoundTrapEvent(ChestItem chestItem) {
        this.chestItem = chestItem;
    }

    public ChestItem TypeOfTrap() {
        return this.chestItem;
    }
}
