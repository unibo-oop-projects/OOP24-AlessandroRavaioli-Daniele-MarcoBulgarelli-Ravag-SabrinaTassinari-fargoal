package fargoal.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.view.api.View;

public class SwingView implements View, KeyListener {

    private static final int FLOOR_LENGTH = 40;
    private static final int FLOOR_HEIGHT = 25;

    private SwingViewCanvas mapPanel;
    private SwingViewCanvas top;
    private SwingViewCanvas bottom;
    private JFrame frame;
    private KeyboardInputController input;

    private int tilePixelDimWidth;
    private int tilePixelDimHeight;

    public SwingView(KeyboardInputController c) {
        this.frame = new JFrame();
        this.mapPanel = new SwingViewCanvas();
        this.top = new SwingViewCanvas();
        this.bottom = new SwingViewCanvas();
        this.mapPanel.setBackground(Color.BLACK);
        this.frame.setLayout(new BorderLayout());
        this.frame.setSize(1500, 1000);
        this.frame.getContentPane().add(mapPanel, BorderLayout.CENTER);
        this.frame.getContentPane().add(this.top, BorderLayout.NORTH);
        this.frame.getContentPane().add(this.bottom, BorderLayout.SOUTH);
        this.top.setPreferredSize(new Dimension(1000, 100));
        this.bottom.setPreferredSize(new Dimension(1000, 270));
        this.top.setBackground(Color.GREEN);
        this.bottom.setBackground(Color.YELLOW);
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.input = c;
        this.frame.addKeyListener(this);

        this.frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                calculateDimensions();
                if (tilePixelDimHeight > tilePixelDimWidth) {
                    tilePixelDimHeight = tilePixelDimWidth * 3/4; 
                } else {
                    tilePixelDimWidth = tilePixelDimHeight * 4/3;
                }
            }
        });

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
        this.mapPanel.enableDraw(true);
        SwingUtilities.invokeLater(() -> {
            this.mapPanel.repaint();
            this.top.repaint();
            this.bottom.repaint();
        });
    }
    
    public void registerDrawingActionMiddle(Consumer<Graphics2D> g2d) {
        this.mapPanel.addToList(g2d);
    }

    public int getMapHeight() {
        return this.mapPanel.getBounds().height;
    }

    public int getMapWidth() {
        return this.mapPanel.getBounds().width;
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

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case 38:
                input.notifyMoveUp();
                break;
            
            case 40:
                input.notifyMoveDown();
                break;

            case 37:
                input.notifyMoveLeft();
                break;

            case 39:
                input.notifyMoveRight();
                break;
        
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { 
        switch (e.getKeyCode()) {

            case 38:
                input.notifyNoMoreMoveUp();
                break;
        
            case 40:
                input.notifyNoMoreMoveDown();
                break;
            
            case 37:
                input.notifyNoMoreMoveLeft();
                break;

            case 39:
                input.notifyNoMoreMoveRight();
                break;

            default:
                break;
        }
    }
}
