package fargoal.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.model.core.GameContext;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.impl.SwingView;

public class TestFloorManager {
    
    private static FloorManager manager;

    @BeforeAll
    void init() {
        manager = new FloorManagerImpl(new GameContext(new SwingView()));
    }

    @Test
    void TestFloorLevel() {
        assertEquals(1, manager.getFloorLevel());
        manager.increaseFloorLevel();
        manager.increaseFloorLevel();
        manager.increaseFloorLevel();
        assertEquals(4, manager.getFloorLevel());
        manager.decreaseFloorLevel();
        manager.decreaseFloorLevel();
        assertEquals(2, manager.getFloorLevel());
        manager.decreaseFloorLevel();
        manager.decreaseFloorLevel();
        try {
            manager.decreaseFloorLevel();
        } catch (IllegalStateException e) {
            System.out.println("Passato");
        }
    }
}
