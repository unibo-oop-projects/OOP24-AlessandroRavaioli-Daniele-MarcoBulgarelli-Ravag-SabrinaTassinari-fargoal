package fargoal.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.core.GameEngine;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.manager.impl.FloorMaskImpl;

class TestFloorMask {
    
    private static FloorMask mask;
    private static FloorManager manager;
    private static Map<Position, Boolean> checkMap;

    @BeforeAll
    static void init() {
        mask = new FloorMaskImpl();
        manager = new FloorManagerImpl(new GameEngine());
        checkMap = new HashMap<>();
        resetCheck();
    }

    @Test
    void testResetandClear() {
        mask.resetMask();
        assertEquals(new FloorMaskImpl(), mask);
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 25; j++) {
                checkMap.put(new Position(i, j), true);
            }
        }
        mask.clearMask();
        assertEquals(new FloorMaskImpl(checkMap), mask);
    }

    @Test
    void testUpdate() {
        //test with light disabled
        mask.resetMask();
        resetCheck();
        manager.getPlayer().setPosition(new Position(3, 3));
        mask.update(manager);
        for (int i = 2; i <= 4; i++) {
            for (int j = 2; j <= 4; j++) {
                checkMap.replace(new Position(i, j), true);
            }
        }
        assertEquals(new FloorMaskImpl(checkMap), mask);

        //Test with light enabled
        mask.resetMask();
        manager.getPlayer().setHasLight(true);
        mask.update(manager);
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                checkMap.replace(new Position(i, j), true);
            }
        }
        assertEquals(new FloorMaskImpl(checkMap), mask);
    }

    static void resetCheck() {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 25; j++) {
                checkMap.put(new Position(i, j), false);
            }
        }
    }
}

