package fargoal.view.api;

import java.awt.Graphics2D;
import java.util.function.Consumer;

public interface View {
    
    void update();

    void registerDrawingAction(Consumer<Graphics2D> g2d);
}
