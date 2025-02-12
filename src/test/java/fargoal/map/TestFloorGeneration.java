package fargoal.map;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.controller.input.api.KeyboardInputController;
import fargoal.model.map.api.FloorConstructor;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;
import fargoal.view.impl.SwingRenderFactory;
import fargoal.view.impl.SwingView;

class TestFloorGeneration {

    private static FloorConstructor fc = new FloorConstructorImpl();
    private static FloorMap map;

    @BeforeAll
    static void init() {
        map = fc.createFloor(new SwingRenderFactory(new SwingView(new KeyboardInputController())));
    }

    //CHECKSTYLE: MagicNumber OFF
    //The numbers here represent marks that I want to be true
    @Test
    void testRandom() {
        final Position pos = map.getRandomTile();
        int timesHappend = 0;
        for (int i = 0; i < 100; i++) {
            if (map.getRandomTile().equals(pos)) {
                timesHappend++;
            }
        }
        assertTrue(timesHappend < 90);
        assertTrue(timesHappend < 70);
        assertTrue(timesHappend < 50);
        assertTrue(timesHappend < 20); 
    }
    //CHECKSTYLE: MagicNumber ON
}
