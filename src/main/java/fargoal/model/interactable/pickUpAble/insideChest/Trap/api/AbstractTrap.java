package fargoal.model.interactable.pickUpAble.insideChest.Trap.api;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

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

    public abstract void effect(FloorManager floorManager);

}
