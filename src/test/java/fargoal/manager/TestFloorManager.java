package fargoal.manager;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.model.core.GameEngine;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Map;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.manager.impl.FloorMaskImpl;
import fargoal.model.map.api.FloorMap;

public class TestFloorManager {
    
    private static FloorManager manager;

    @BeforeAll
    static void init() {
        manager = new FloorManagerImpl(new GameEngine());
    }

    //Test to see if increaseFloorLevel and decreaseFloorLevel work appropriatly
    @Test
    void TestFloorLevel() {
        System.out.println("primo test");
        assertEquals(1, manager.getFloorLevel());
        manager.increaseFloorLevel();
        manager.increaseFloorLevel();
        manager.increaseFloorLevel();
        assertEquals(4, manager.getFloorLevel());
        manager.decreaseFloorLevel();
        manager.decreaseFloorLevel();
        assertEquals(2, manager.getFloorLevel());
        manager.decreaseFloorLevel();
        assertThrows(IllegalStateException.class, () -> manager.decreaseFloorLevel());
        resetConditions();
    }

    //This test is aimed at seeing if everything gets a correct position associated with them,
    //basically it is trying to see if any element gets assigned a position where another element already was
    @Test
    void testInitFloor() {
        for (long k = 0; k < 20; k++) {
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
            assertTrue(manager.getInteractables().size() > 11);
            assertTrue(manager.getInteractables().size() <= 41);
            var item = manager.getInteractables();
            for (int i = 0; i < manager.getInteractables().size(); i++) {
                for(int j = 0; j < manager.getInteractables().size(); j++) {
                    if (i != j) {
                        assertNotEquals(item.get(i).getPosition(), manager.getInteractables().get(j).getPosition());   
                    }
                }
            }
            assertTrue(manager.getFloorMap().isTile(manager.getTemple().getPosition()));
        }
        resetConditions();
    }

    @Test
    void testFloorChange() {
        //I need to test that the map, the monsters and the items change after every floor
        FloorMap map = manager.getFloorMap();
        List<Monster> monsters = List.copyOf(manager.getMonsters());
        List<Interactable> items = List.copyOf(manager.getInteractables());
        manager.increaseFloorLevel();
        assertNotEquals(map, manager.getFloorMap());
        assertNotEquals(monsters, manager.getMonsters());
        assertNotEquals(items, manager.getInteractables());

        //I need to test if the floor for which a map was found gets cleared
        Map testMap = new Map(manager);
        testMap.store();
        FloorMask mask = new FloorMaskImpl();
        mask.clearMask();
        for(int i = 0; i < 20; i++) {
            if (testMap.getListOfMaps().contains(manager.getFloorLevel())) {
                assertEquals(mask, manager.getFloorMask());
            }
        }
        resetConditions();
    }

    //Test to see if it can exit when the player has the sword
    //This has already given issue
    @Test
    void testExitWithSword() {
        System.out.println("Quarto test");
        manager.getPlayer().setHasSword(true);
        assertDoesNotThrow(()-> manager.decreaseFloorLevel());
        manager.getPlayer().setHasSword(false);
        resetConditions();
    }

    private void resetConditions() {
        while (manager.getFloorLevel() != 1) {
            if (manager.getFloorLevel() > 1) {
                manager.decreaseFloorLevel();
            } else {
                manager.increaseFloorLevel();
            }
        }
    }
}
