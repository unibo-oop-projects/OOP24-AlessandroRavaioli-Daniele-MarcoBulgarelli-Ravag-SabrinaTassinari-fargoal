package fargoal.model.map.api;

import fargoal.model.manager.api.FloorManager;

/**
 * interface for a class that generates a floor.
 */
public interface FloorConstructor {

    /**
     * the method that creates a floor.
     * 
     * @param renderFactory - the factory that is used to obtain the renders that the floor will use
     * @return - a new map of the floor
     */
    FloorMap createFloor(FloorManager manager);
}
