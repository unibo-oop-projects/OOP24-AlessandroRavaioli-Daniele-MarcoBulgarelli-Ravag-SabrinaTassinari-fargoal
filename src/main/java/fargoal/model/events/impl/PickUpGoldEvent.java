package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;

public class PickUpGoldEvent implements FloorEvent {
    
    private final Integer gold;

    public PickUpGoldEvent(Integer gold) {
        this.gold = gold;
    }

    public Integer GoldFound() {
        return this.gold;
    } 
}
