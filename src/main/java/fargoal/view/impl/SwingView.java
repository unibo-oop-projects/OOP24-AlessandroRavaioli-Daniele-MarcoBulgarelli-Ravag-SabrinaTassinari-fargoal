package fargoal.view.impl;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.util.function.Consumer;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fargoal.view.api.View;

public class SwingView implements View {

    private static final int FLOOR_LENGTH = 40;
    private static final int FLOOR_HEIGTH = 25;

    private SwingViewCanvas canvas;
    private JFrame frame;

    private int tilePixelDim;

    public SwingView() {
        this.frame = new JFrame();
        this.canvas = new SwingViewCanvas();
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(3500, 3000);
        this.frame.getContentPane().add(canvas, BorderLayout.CENTER);
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calculateDimensions();
        this.frame.setVisible(true);
    }

    public int getTilePixelDim() {
        return this.tilePixelDim;
    }

    @Override
    public void update() {
        calculateDimensions();
        SwingUtilities.invokeLater(() -> this.canvas.repaint());
    }
    
    @Override
    public void registerDrawingAction(Consumer<Graphics2D> g2d) {
        this.canvas.addToList(g2d);
    }

    public int getMapHeight() {
        return this.canvas.getBounds().height;
    }

    public int getMapWidth() {
        return this.canvas.getBounds().width;
    }

    private void calculateDimensions() {
        this.tilePixelDim = Math.min(this.getMapHeight()/FLOOR_HEIGTH, this.getMapWidth()/FLOOR_LENGTH);
    }
}
