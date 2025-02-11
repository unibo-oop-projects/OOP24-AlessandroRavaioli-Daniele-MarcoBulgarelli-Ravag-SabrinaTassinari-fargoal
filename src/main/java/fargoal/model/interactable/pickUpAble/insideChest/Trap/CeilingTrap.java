package fargoal.model.interactable.pickUpAble.insideChest.Trap;

import java.util.Random;

import fargoal.model.events.impl.FoundTrapEvent;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the implementation of the Ceiling Trap, which can be found in a chest.
 * It damages the player and there is a chance the player loses his map.
 */
public class CeilingTrap implements ChestItem {

    /**
     * This is the constructor of the class. When the player finds the trap in the chest it damages him immediately.
     * @param floorManager - it contains all the element of the floor the trap was found.
     * @param position - this is the position of the chest that contained the trap.
     */
    public CeilingTrap(FloorManager floorManager) {
        this.use(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.TRAP.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return TrapType.CEILING_TRAP.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        boolean mapLost = false;
        int damage = new Random().nextInt(9) + floorManager.getFloorLevel();
        int chanceOfMapLost = new Random().nextInt(4);
        if (chanceOfMapLost == 0) {
            floorManager.getFloorMask().resetMask();
            mapLost = true;
        }
        floorManager.getPlayer().getHealth().decreaseHealth(damage);
        floorManager.notifyFloorEvent(new FoundTrapEvent(this, mapLost));
    }
    
}
