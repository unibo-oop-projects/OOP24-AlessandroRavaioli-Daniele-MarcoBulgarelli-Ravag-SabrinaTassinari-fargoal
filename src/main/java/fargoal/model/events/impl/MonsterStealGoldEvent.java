package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;

public class MonsterStealGoldEvent implements FloorEvent{

    private int gold;
    private FloorElement monster;

    public MonsterStealGoldEvent(int gold, FloorElement monster) {
        this.gold = gold;
        this.monster = monster;
    }

    public Integer HowMuchGold() {
        return this.gold;
    }

    public FloorElement WhoStole() {
        return this.monster;
    }
    
}
