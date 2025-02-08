package fargoal.model.interactable.pickUpAble.insideChest.Trap;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the implementation of the Ceiling Trap, which can be found in a chest.
 * It damages the player and there is a chance the player loses his map.
 */
public class CeilingTrap implements ChestItem {

    final Position position;

    /**
     * This is the constructor of the class. When the player finds the trap in the chest it damages him immediately.
     * @param floorManager - it contains all the element of the floor the trap was found.
     * @param position - this is the position of the chest that contained the trap.
     */
    public CeilingTrap(FloorManager floorManager, final Position position) {
        this.interact(floorManager);
        this.position = position;
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
    public Interactable interact(FloorManager floorManager) {
        int damage = new Random().nextInt(9) + floorManager.getFloorLevel();
        int chanceOfMapLost = new Random().nextInt(4);
        if (chanceOfMapLost == 0) {
            floorManager.getFloorMask().resetMask();
        }
        floorManager.getPlayer().getHealth().decreaseHealth(damage);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return this.getChestItemName();
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        
    }

    /** {@inheritDoc} */
    @Override
    public void render() {}
    
}
