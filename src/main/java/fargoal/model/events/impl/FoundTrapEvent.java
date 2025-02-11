package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;

public class FoundTrapEvent implements FloorEvent {
    
    private final ChestItem chestItem;
    private boolean mapLost;

    public FoundTrapEvent(ChestItem chestItem, boolean mapLost) {
        this.chestItem = chestItem;
        this.mapLost = mapLost;
    }

    public ChestItem TypeOfTrap() {
        return this.chestItem;
    }

    public boolean HasLostMap() {
        return this.mapLost;
    }
}
