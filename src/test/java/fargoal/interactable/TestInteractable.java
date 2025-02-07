package fargoal.interactable;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.core.GameContext;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.impl.ChestImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.impl.SwingView;

public class TestInteractable {
    
    private static FloorManager floorManager;
    private static Interactable chest;
    private static Interactable item;

    @BeforeAll
    static void init() {
        floorManager = new FloorManagerImpl(new GameContext(new SwingView()));
    }

    void visualizeFloor() {
        System.out.print(" ");
        for(int i = 0; i < 40; i++) {
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int i = 0; i < 25; i++) {
            int k = i;
            System.out.print(i + " ");
            for (int j = 0; j < 40; j++) {
                int x = j;
                System.out.print(
                    floorManager.getFloorMap().isTile(new Position(x, k))
                    ? "O" + "  "
                    : " " + "  ");
            }
            System.out.println();
        }
    }

    @Test
    public void checkItem() {
        chest = new ChestImpl(floorManager.getFloorMap().getRandomTile());
        item = chest.interact(floorManager);
        System.out.println("You found a " + item.getTag());
        visualizeFloor();
    }

}
