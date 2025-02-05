package fargoal.model.interactable.pickUpAble.inChest.Trap.api;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

public abstract class AbstractTrap implements ChestItem {
    
    public void damage(FloorManager floorManager) {
        int damage = new Random().nextInt(14) + 1; 
    }

}
