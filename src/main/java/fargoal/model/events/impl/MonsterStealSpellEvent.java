package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;

public class MonsterStealSpellEvent implements FloorEvent{
    
    private final FloorElement monster;
    private final ChestItem item;

    public MonsterStealSpellEvent(ChestItem item, FloorElement monster) {
        this.item = item;
        this.monster = monster;
    }

    public ChestItem WhatMonsterStole() {
        return this.item;
    }

    public FloorElement WhoStole() {
        return this.monster;
    }

}
