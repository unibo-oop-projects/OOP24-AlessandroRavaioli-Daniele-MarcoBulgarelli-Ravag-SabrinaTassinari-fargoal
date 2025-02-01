package fargoal.view.impl;

import java.awt.Graphics2D;
import java.util.function.Consumer;

import javax.swing.JFrame;

import fargoal.view.api.View;

public class SwingView implements View {

    private SwingViewCanvas canvas;
    private JFrame frame;

    public SwingView() {
        this.frame = new JFrame();
        this.canvas = new SwingViewCanvas();
        this.frame.add(canvas);
    }

    @Override
    public void update() {
        this.canvas.repaint();
    }
    
    @Override
    public void registerDrawingAction(Consumer<Graphics2D> g2d) {
        this.canvas.addToList(g2d);
    }
}
