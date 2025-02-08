package fargoal.model.manager.api;

import java.util.List;

import fargoal.model.commons.FloorElement;
import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.temple.Temple;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.RenderFactory;

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
     * A method to return the instance of the Player.
     * @return - the instance of the player
     */
    Player getPlayer();

    /**
     * A method that returns the list of all the monsters present.
     * @return - the list of monsters
     */
    List<Monster> getMonsters();

    /**
     * A method to obtain the current map.
     * @return - the current floor map
     */
    FloorMap getFloorMap();

    /**
     * A method that returns the current floor level.
     * @return - the current floor level
     */
    int getFloorLevel();

    /**
     * A method that return the list of all the items present.
     */
    List<Interactable> getInteractables();

    /**
     * Method to increase the level of the floor
     */
    void increaseFloorLevel();

    /**
     * Method to decrease the level of the floor
     */
    void decreaseFloorLevel();

    /**
     * A method to obtain the mask of the floor 
     * @return - the current mask
     */
    FloorMask getFloorMask();

    /**
     * A method to obtain the temple
     * @return - the temple
     */
    Temple getTemple();

    /**
     * A method to obtain all the FloorElements present at the current moment in the floor
     * @return - a list of all the current FloorElements
     */
    List<FloorElement> getAllElements();

    /**
     * A method to obtain a factory to all the renderers currently used
     * @return - the render factory
     */
    RenderFactory getRenderFactory();
}
