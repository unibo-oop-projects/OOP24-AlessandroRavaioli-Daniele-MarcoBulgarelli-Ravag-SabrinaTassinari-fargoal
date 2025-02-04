package fargoal.model.manager.api;

import java.util.List;

import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.map.api.FloorMap;

/**
 * An interface to model the entirety of the floor.
 */
public interface FloorManager {
    
    /**
     * The main method that updates everythin that has happend in the last frame.
     * @param context - the context of the floor
     */
    void update(GameContext context);

    /**
     * A method to return the instance of the Player
     * @return
     */
    Player getPlayer();

    /**
     * A method that returns the list of all the monsters present
     * @return
     */
    List<Monster> getMonsters();

    /**
     * A method to obtain the current map
     * @return
     */
    FloorMap getFloorMap();

    /**
     * A method that returns the current floor level
     * @return
     */
    int getFloorLevel();

}
