package fargoal.model.map.api;

import fargoal.view.api.RenderFactory;

/**
 * interface for a class that generates a floor.
 */
public interface FloorConstructor {

    /**
     * the method that creates a floor.
     * 
     * @return
     */
    FloorMap createFloor(RenderFactory renderFactory);
}
