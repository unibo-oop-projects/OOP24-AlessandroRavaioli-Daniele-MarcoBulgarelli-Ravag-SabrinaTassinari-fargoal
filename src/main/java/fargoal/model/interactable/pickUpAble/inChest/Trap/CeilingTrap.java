package fargoal.model.interactable.pickUpAble.inChest.Trap;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the implementation of the Ceiling Trap, which can be found in a chest.
 * It damages the player and there is a chance the player loses his map.
 */
public class CeilingTrap implements ChestItem {

    final Position position;

    /**
     * This is the constructor of the class. When the player find the trap in the chest it damage him right on the instance.
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
