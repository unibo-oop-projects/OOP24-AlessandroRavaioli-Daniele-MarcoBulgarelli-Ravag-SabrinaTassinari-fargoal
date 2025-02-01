package fargoal.view.impl;

import java.util.function.Consumer;
import java.awt.Graphics2D;

import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class SwingRenderer implements Renderer {

    Consumer<Graphics2D> drawingAction;

    public SwingRenderer(Consumer<Graphics2D> drawing) {
        this.drawingAction = drawing;
    }

    @Override
    public void render(View view) {
        SwingView sview = (SwingView)view;
        sview.registerDrawingAction(drawingAction);
    }
    
}
