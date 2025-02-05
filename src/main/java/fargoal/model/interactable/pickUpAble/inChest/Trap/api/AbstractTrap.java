package fargoal.model.interactable.pickUpAble.inChest.Trap.api;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the abstract class that implements the traps, which can be found in a chest
 */
public abstract class AbstractTrap implements ChestItem {
    
    /**
     * With this method the player is damaged. It is common to all the traps.
     * @param floorManager - it contains all the element of the floor.
     */
    public void damage(FloorManager floorManager) {
        int damage = getDamage();

    }

    private int getDamage() {
        return new Random().nextInt(14) + 1; 
    }

}
