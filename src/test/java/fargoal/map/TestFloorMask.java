package fargoal.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.model.core.GameEngine;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.manager.impl.FloorMaskImpl;

public class TestFloorMask {
    
    private static FloorMask mask;
    private static FloorManager manager;

    @BeforeAll
    static void init() {
        mask = new FloorMaskImpl();
        manager = new FloorManagerImpl(new GameEngine());
    }

    @Test
    void testReset() {
        mask.resetMask();
        assertEquals(new FloorMaskImpl(), mask);        
    }

    @Test
    void testUpdate() {
        
    }
}

