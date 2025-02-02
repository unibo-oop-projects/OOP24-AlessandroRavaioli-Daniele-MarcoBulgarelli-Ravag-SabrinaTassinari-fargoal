package fargoal.map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.map.api.FloorConstructor;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;
import fargoal.view.api.SwingRenderFactory;
import fargoal.view.api.View;
import fargoal.view.impl.SwingRenderFactoryImpl;
import fargoal.view.impl.SwingView;

public class TestFloorGeneration {

    private final static FloorConstructor fc= new FloorConstructorImpl();
    private static FloorMap map;
    private final static View view = new SwingView();
    private final static SwingRenderFactory render = new SwingRenderFactoryImpl((SwingView)view);

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
                    TestFloorGeneration.map.isTile(new Position(j, i)) 
                        ? "O"
                        : " ");
            }
            System.out.println();
        }
    }

    @Test
    void graphicallyVisualizeFloor() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 40; j++) {
                (TestFloorGeneration.map.isTile(new Position(j, i)) 
                ? render.tile(new Position(j, i))
                : render.tile(new Position(j, i))).render(view);
            }
        }
        while (true) {
            TestFloorGeneration.view.update();   
        }
    }
}
