package fargoal.model.events.impl;

import fargoal.model.commons.FloorElement;
import fargoal.model.events.api.FloorEvent;

public class MonsterEncounterEvent implements FloorEvent{
    
    private final FloorElement floorElement;

    public MonsterEncounterEvent(FloorElement floorElement) {
        this.floorElement = floorElement;
    }

    public FloorElement monsterEncountered() {
        return this.floorElement;
    }
}
