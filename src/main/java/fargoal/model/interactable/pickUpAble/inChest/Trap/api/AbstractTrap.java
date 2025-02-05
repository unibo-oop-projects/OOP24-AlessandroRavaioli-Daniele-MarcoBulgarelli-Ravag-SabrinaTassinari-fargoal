package fargoal.model.interactable.pickUpAble.inChest.Trap.api;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;

public abstract class AbstractTrap implements ChestItem {
    
    public void damage() {
        int damage = new Random().nextInt(14) + 1; 
    }

}
