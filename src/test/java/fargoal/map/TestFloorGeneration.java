package fargoal.map;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.map.api.FloorConstructor;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;

public class TestFloorGeneration {

    private static FloorConstructor fc = new FloorConstructorImpl();
    private static FloorMap map;

    @BeforeAll
    static void init() {
        map = fc.createFloor();
    }

    @Test
    void visualizeFloor() {
        for (int i = 0; i < 25; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < 40; j++) {
                System.out.print(
                    map.isTile(new Position(j, i)) 
                        ? "O"
                        : " ");
            }
            System.out.println();
        }
    }

    @Test
    void testRandom() {
        Position pos = map.getRandomTile();
        int timesHappend = 0;
        for(int i = 0; i < 100; i++) {
            if (map.getRandomTile().equals(pos)) {
                timesHappend++;
            }
        }
        assertTrue(timesHappend < 90);
        assertTrue(timesHappend < 70);
        assertTrue(timesHappend < 50);
        assertTrue(timesHappend < 20); 
    }    
}
