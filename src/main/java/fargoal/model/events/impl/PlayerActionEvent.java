package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;

public class PlayerActionEvent implements FloorEvent{

    private ChestItem item;

    public PlayerActionEvent(ChestItem item) {
        this.item = item;
    }

    public ChestItem WhatPlayerUsed() {
        return this.item;
    }
    
}
