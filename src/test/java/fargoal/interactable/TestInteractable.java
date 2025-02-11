package fargoal.interactable;

import org.junit.jupiter.api.Test;

import fargoal.model.core.GameEngine;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.insideChest.impl.ChestImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;

public class TestInteractable {
    
    private static FloorManager floorManager = new FloorManagerImpl(new GameEngine());
    private static Interactable chest;
    private static Interactable item;

   
    @Test
    public void checkItem() {
        chest = new ChestImpl(null, null);
        item = chest.interact(floorManager);
        System.out.println("You found a " + item.getTag());
    }

}
