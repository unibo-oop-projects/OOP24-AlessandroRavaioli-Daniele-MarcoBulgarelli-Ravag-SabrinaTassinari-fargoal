package fargoal.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.function.Consumer;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import fargoal.view.api.View;

public class SwingView implements View {

    private static final int FLOOR_LENGTH = 40;
    private static final int FLOOR_HEIGHT = 25;

    private SwingViewCanvas canvas;
    private SwingViewCanvas top;
    private SwingViewCanvas bottom;
    private JFrame frame;

    private int tilePixelDimWidth;
    private int tilePixelDimHeight;

    public SwingView() {
        this.frame = new JFrame();
        this.canvas = new SwingViewCanvas();
        this.top = new SwingViewCanvas();
        this.top.setFont(new Font("Arial", Font.PLAIN, 10));
        this.bottom = new SwingViewCanvas();
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(1500, 1000);
        this.frame.getContentPane().add(canvas, BorderLayout.CENTER);
        this.frame.getContentPane().add(this.top, BorderLayout.NORTH);
        this.frame.getContentPane().add(this.bottom, BorderLayout.SOUTH);
        this.top.setPreferredSize(new Dimension(1000, 100));
        this.bottom.setPreferredSize(new Dimension(1000, 270));
        this.top.setBackground(Color.GREEN);
        this.bottom.setBackground(Color.YELLOW);
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calculateDimensions();
        this.frame.setVisible(true);
    }

    public int getTilePixelHeight() {
        return this.tilePixelDimHeight;
    }

    public int getTilePixelWidth() {
        return this.tilePixelDimWidth;
    }

    @Override
    public void update() {
        this.top.enableDraw(true);
        this.bottom.enableDraw(true);
        this.canvas.enableDraw(true);
        calculateDimensions();
        SwingUtilities.invokeLater(() -> {
            this.canvas.repaint();
            this.top.repaint();
            this.bottom.repaint();
        });
    }
    
    public void registerDrawingActionMiddle(Consumer<Graphics2D> g2d) {
        this.canvas.addToList(g2d);
    }

    public int getMapHeight() {
        return this.canvas.getBounds().height;
    }

    public int getMapWidth() {
        return this.canvas.getBounds().width;
    }

    private void calculateDimensions() {
        this.tilePixelDimHeight = (int) (this.getMapHeight() / FLOOR_HEIGHT);
        this.tilePixelDimWidth = (int) (this.getMapWidth() / FLOOR_LENGTH);
    }

    public void registerDrawingActionTop(Consumer<Graphics2D> g2d) {
        this.top.addToList(g2d);
    }

    public void registerDrawingActionBottom(Consumer<Graphics2D> g2d) {
        this.bottom.addToList(g2d);
    }
}
