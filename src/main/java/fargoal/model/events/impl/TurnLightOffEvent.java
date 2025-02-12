package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;

public class TurnLightOffEvent implements FloorEvent {
    
    public String getLightTurnOff() {
        return "You turned the light off";
    }
}
