package fargoal.model.interactable.pickUpAble.insideChest.Trap.api;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the abstract class for the traps. 
 */
public abstract class AbstractTrap implements ChestItem {
    
    /** {@inheritDoc} */
    @Override 
    public String getChestItemType() {
        return ChestItemType.TRAP.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        int chanceOfMapLost = new Random().nextInt(4);
        if (chanceOfMapLost == 0) {
            floorManager.getFloorMask().resetMask();
        }
        this.effect(floorManager);
    }

    /**
     * This method damage or teleport the player.
     * @param floorManager
     */
    public abstract void effect(FloorManager floorManager);

}
