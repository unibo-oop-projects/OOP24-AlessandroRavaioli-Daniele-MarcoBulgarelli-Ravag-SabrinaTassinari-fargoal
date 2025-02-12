package fargoal.model.events.impl;

import fargoal.model.events.api.FloorEvent;

/**
 * Blessed is a class called everytime that the player
 * is blessed in the temple.
 */
public class BlessedEvent implements FloorEvent {
    
    public String getBlessed() {
        return "You are blessed!";
    }
}
