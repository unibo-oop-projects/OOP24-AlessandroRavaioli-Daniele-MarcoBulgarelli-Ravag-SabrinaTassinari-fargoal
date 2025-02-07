package fargoal.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.map.api.FloorMap;
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

    @Test
    void testInitFloor() {
        for (long k = 0; k < 1000; k++) {
            FloorMap map = manager.getFloorMap();
            manager.increaseFloorLevel();
            assertNotEquals(map, manager.getFloorMap());
            List<Monster> monsters = manager.getMonsters();
            assertEquals(7, monsters.size());
            for (int i = 0; i < monsters.size(); i++) {
                for (int j = 0; j < monsters.size(); j++) {
                    if (i != j) {
                        assertNotEquals(monsters.get(i).getPosition(), monsters.get(j).getPosition());
                    }
                }
            }
            assertTrue(manager.getItems().size() > 3);
            var item = manager.getItems();
            for (int i = 0; i < manager.getItems().size(); i++) {
                for(int j = 0; j < manager.getItems().size(); j++) {
                    if (i != j) {
                        assertNotEquals(item.get(i).getPosition(), manager.getItems().get(j).getPosition());   
                    }
                }
            }
        }
    }
}
