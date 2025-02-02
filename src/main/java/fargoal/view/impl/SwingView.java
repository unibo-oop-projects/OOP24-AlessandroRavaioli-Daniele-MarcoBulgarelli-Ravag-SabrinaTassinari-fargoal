package fargoal.view.impl;

import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.Consumer;
import javax.swing.WindowConstants;

import javax.swing.JFrame;

import fargoal.view.api.View;

public class SwingView implements View {

    private static final int FLOOR_LENGTH = 40;
    private static final int FLOOR_HEIGTH = 25;

    private SwingViewCanvas canvas;
    private JFrame frame;

    private int truePixelHeight;
    private int truePixelWidth;
    private int tilePixelDim;

    public SwingView() {
        this.frame = new JFrame();
        this.canvas = new SwingViewCanvas();
        this.frame.getContentPane().add(canvas);
        this.frame.setResizable(true);
        this.truePixelHeight = this.frame.getBounds().height;
        this.truePixelWidth = this.frame.getBounds().width;
        this.tilePixelDim = Math.min(this.truePixelHeight/FLOOR_HEIGTH, this.truePixelWidth/FLOOR_LENGTH);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
				System.exit(-1);
			}
			public void windowClosed(WindowEvent ev){
				System.exit(-1);
			}
        });
        this.frame.setVisible(true);
    }

    public int getTilePixelDim() {
        return this.tilePixelDim;
    }

    @Override
    public void update() {
        this.canvas.repaint();
    }
    
    @Override
    public void registerDrawingAction(Consumer<Graphics2D> g2d) {
        this.canvas.addToList(g2d);
    }

    public int getHeight() {
        return this.frame.getBounds().height;
    }

    public int getWidth() {
        return this.frame.getBounds().width;
    }
}
