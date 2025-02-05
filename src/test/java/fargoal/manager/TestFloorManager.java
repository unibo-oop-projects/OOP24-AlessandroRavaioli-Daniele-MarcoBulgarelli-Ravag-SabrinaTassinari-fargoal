package fargoal.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.model.core.GameContext;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.impl.SwingView;

public class TestFloorManager {
    
    private static FloorManager manager;

    @BeforeAll
    static void init() {
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
        assertThrows(IllegalStateException.class, () -> manager.decreaseFloorLevel());
    }
}
