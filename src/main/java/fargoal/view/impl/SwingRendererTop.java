package fargoal.view.impl;

import java.awt.Graphics2D;
import java.util.function.Consumer;

import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class SwingRendererTop implements Renderer{
    
    private final Consumer<Graphics2D> drawingAction;
    private final SwingView view;

    public SwingRendererTop(Consumer<Graphics2D> drawing, View view) {
        this.drawingAction = drawing;
        this.view = (SwingView)view;
    }

    @Override
    public void render() {
        this.view.registerDrawingActionTop(drawingAction);
    }
}
