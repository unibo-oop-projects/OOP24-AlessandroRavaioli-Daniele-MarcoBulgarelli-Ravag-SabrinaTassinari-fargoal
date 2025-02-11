package fargoal.model.events.api;

/**
 * Interface that notifies which events are happening.
 */
public interface FloorEventListener {
    /**
     * Method that working with the View, displays
     * on the screen the events that are happening.
     * 
     * @param floorEvent
     */
    void notifyEvent(FloorEvent floorEvent);
}
