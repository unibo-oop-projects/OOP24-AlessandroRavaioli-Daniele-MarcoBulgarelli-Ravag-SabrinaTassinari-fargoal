package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;

public class TurnLightOnEvent implements FloorEvent {
    
    public String getTurnLightOn() {
        return "You turned the light off";
    }
}
