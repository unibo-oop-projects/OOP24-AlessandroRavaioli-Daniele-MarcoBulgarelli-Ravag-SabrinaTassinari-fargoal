package fargoal.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.function.Consumer;
import javax.swing.WindowConstants;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.view.api.View;

/**
 * Class that create and keeps up to date the screen and his
 * {@link SwingViewCanvas}.
 */
public class SwingView implements View, KeyListener {

    private static final int MINIMUM_TILE_WIDTH = 16;
    private static final int MINIMUM_TILE_HEIGHT = 12;
    private static final int FRAME_WIDTH = 650;
    private static final int FRAME_HEIGHT = 550;
    private static final int CONSTANT_FOUR = 4;
    private static final int PANELS_DIVISOR_HEIGHT = 55;
    private static final int EVENT_PANEL_MULTIPLIER_HEIGHT = 11;
    private static final int INFORMATION_PANEL_MULTIPLIER_HEIGHT = 13;
    private static final int FLOOR_LENGTH = 40;
    private static final int FLOOR_HEIGHT = 25;
    private static final int ARROW_UP = 38;
    private static final int ARROW_DOWN = 40;
    private static final int ARROW_LEFT = 37;
    private static final int ARROW_RIGHT = 39;
    private static final int SPACE_BAR = 32;
    private static final int LETTER_H = 72;
    private static final int LETTER_B = 66;
    private static final int LETTER_T = 84;
    private static final int LETTER_S = 83;
    private static final int LETTER_D = 68;
    private static final int LETTER_R = 82;
    private static final int LETTER_I = 73;
    private static final int LETTER_L = 76;
    private static final int LETTER_O = 79;

    private final SwingViewCanvas mapPanel;
    private final SwingViewCanvas eventPanel;
    private final SwingViewCanvas informationPanel;
    private final JFrame frame;
    private final KeyboardInputController input;

    private int tilePixelDimWidth;
    private int tilePixelDimHeight;
    private int margin;

    /**
     * Constructor that create the {@link SwingViewCanvas} panels, the main {@link JFrame}
     * and set the default dimensions.
     * 
     * @param c - to recognize the input on the panels
     */
    public SwingView(final KeyboardInputController c) {
        this.frame = new JFrame();
        this.mapPanel = new SwingViewCanvas();
        this.eventPanel = new SwingViewCanvas();
        this.informationPanel = new SwingViewCanvas();
        this.mapPanel.setBackground(Color.DARK_GRAY);
        this.frame.setLayout(new BorderLayout());
        this.frame.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.frame.getContentPane().add(mapPanel, BorderLayout.CENTER);
        this.frame.getContentPane().add(this.eventPanel, BorderLayout.NORTH);
        this.frame.getContentPane().add(this.informationPanel, BorderLayout.SOUTH);
        this.eventPanel.setBackground(Color.BLACK);
        this.informationPanel.setBackground(Color.GRAY);
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.input = c;
        this.frame.addKeyListener(this);
        this.frame.addComponentListener(new ComponentAdapter() {

            /** {@inheritDoc} */
            @Override
            public void componentResized(final ComponentEvent e) {
                calculateDimensions();
            }
        });
        this.frame.addWindowStateListener(new WindowStateListener() {

            @Override
            public void windowStateChanged(final WindowEvent e) {
                calculateDimensions();
            }
        });
        tilePixelDimHeight = MINIMUM_TILE_HEIGHT;
        tilePixelDimWidth = MINIMUM_TILE_WIDTH;
        this.eventPanel.setPreferredSize(new Dimension(this.frame.getBounds().width, 
                this.frame.getBounds().height * EVENT_PANEL_MULTIPLIER_HEIGHT / PANELS_DIVISOR_HEIGHT));
        this.informationPanel.setPreferredSize(new Dimension(this.frame.getBounds().width, 
                this.frame.getBounds().height * INFORMATION_PANEL_MULTIPLIER_HEIGHT / PANELS_DIVISOR_HEIGHT));
        this.frame.setVisible(true);
    }

    /**
     * Method that returns the main and only {@link JFrame}.
     * 
     * @return the local field {@link #frame}
     */
    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * Method that returns the height in pixels of a tile.
     * 
     * @return the local field {@link #tilePixelDimHeight}
     */
    public int getTilePixelHeight() {
        return this.tilePixelDimHeight;
    }

    /**
     * Method that returns the width in pixels of a tile.
     * 
     * @return the local field {@link #tilePixelDimWidth}
     */
    public int getTilePixelWidth() {
        return this.tilePixelDimWidth;
    }

    /** {@inheritDoc} */
    @Override
    public void update() {
        this.eventPanel.enableDraw(true);
        this.informationPanel.enableDraw(true);
        this.mapPanel.enableDraw(true);
        SwingUtilities.invokeLater(() -> {
            this.mapPanel.repaint();
            this.eventPanel.repaint();
            this.informationPanel.repaint();
        });
    }
    /**
     * Method that add to the list of things to draw of the
     * middle part a {@link Graphics2D}.
     * 
     * @param g2d - the {@link Graphics2D} to add in the queue
     */
    public void registerDrawingActionMiddle(final Consumer<Graphics2D> g2d) {
        this.mapPanel.addToList(g2d);
    }

    /**
     * Method that returns the height in pixels of the map.
     * 
     * @return the height value of the local field {@link #mapPanel}
     */
    public int getMapHeight() {
        return this.mapPanel.getBounds().height;
    }

    /**
     * Method that returns the width in pixels of the map.
     * 
     * @return the width value of the local field {@link #mapPanel}
     */
    public int getMapWidth() {
        return this.mapPanel.getBounds().width;
    }

    /**
     * Method that set the dimension of a single tile
     * and of the {@link #eventPanel} and {@link #informationPanel}.
     */
    private void calculateDimensions() {
        this.tilePixelDimHeight = (this.getMapHeight() / FLOOR_HEIGHT);
        this.tilePixelDimWidth = (this.getMapWidth() / FLOOR_LENGTH);
        this.eventPanel.setPreferredSize(new Dimension(this.frame.getBounds().width, 
                this.frame.getBounds().height * EVENT_PANEL_MULTIPLIER_HEIGHT / PANELS_DIVISOR_HEIGHT));
        this.informationPanel.setPreferredSize(new Dimension(this.frame.getBounds().width, 
                this.frame.getBounds().height * INFORMATION_PANEL_MULTIPLIER_HEIGHT / PANELS_DIVISOR_HEIGHT));
        if (tilePixelDimHeight > tilePixelDimWidth) {
            tilePixelDimHeight = tilePixelDimWidth * 3 / CONSTANT_FOUR; 
        } else {
            tilePixelDimWidth = tilePixelDimHeight * CONSTANT_FOUR / 3;
        }
        margin = (this.getMapWidth() - tilePixelDimWidth * FLOOR_LENGTH) / 2;
    }

    /**
     * Method that add to the list of things to draw of the
     * top part a {@link Graphics2D}.
     * 
     * @param g2d - the {@link Graphics2D} to add in the queue
     */
    public void registerDrawingActionTop(final Consumer<Graphics2D> g2d) {
        this.eventPanel.addToList(g2d);
    }

    /**
     * Method that add to the list of things to draw of the
     * top part a {@link Graphics2D}.
     * 
     * @param g2d - the {@link Graphics2D} to add in the queue
     */
    public void registerDrawingActionBottom(final Consumer<Graphics2D> g2d) {
        this.informationPanel.addToList(g2d);
    }

    /**
     * Method that returns the {@link #informationPanel}.
     * 
     * @return the local field {@link #informationPanel}
     */
    public SwingViewCanvas getInformationPanel() {
        return this.informationPanel;
    }

    /**
     * Method that returns the {@link #eventPanel}.
     * 
     * @return the local field {@link #eventPanel}
     */
    public SwingViewCanvas getEventPanel() {
        return this.eventPanel;
    }

    public int getMargin() {
        return this.margin;
    }

    /** {@inheritDoc} */
    @Override
    public void keyTyped(final KeyEvent e) { }

    /** {@inheritDoc} */
    @Override
    public void keyPressed(final KeyEvent e) {
        switch (e.getKeyCode()) {

            case ARROW_UP:
                input.notifyMoveUp();
                break;
            case ARROW_DOWN:
                input.notifyMoveDown();
                break;

            case ARROW_LEFT:
                input.notifyMoveLeft();
                break;

            case ARROW_RIGHT:
                input.notifyMoveRight();
                break;
            case SPACE_BAR:
                input.notifyInteracting();
                break;

            case LETTER_H:
                input.notifyUsingHealingPotion();
                break;

            case LETTER_B:
                input.notifyPlacingBeacon();
                break;
            case LETTER_T:
                input.notifyUsingTeleportSpell();
                break;

            case LETTER_S:
                input.notifyUsingShieldSpell();
                break;

            case LETTER_D:
                input.notifyUsingDriftSpell();
                break;

            case LETTER_R:
                input.notifyUsingRegenerationSpell();
                break;

            case LETTER_I:
                input.notifyUsingInvisibilitySpell();
                break;

            case LETTER_L:
                input.notifyUsingLightSpell();
                break;

            case LETTER_O:
                input.notifyTurnLight();
                break;
            default:
                break;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void keyReleased(final KeyEvent e) { 
        switch (e.getKeyCode()) {

            case ARROW_UP:
                input.notifyNoMoreMoveUp();
                break;
            case ARROW_DOWN:
                input.notifyNoMoreMoveDown();
                break;
            case ARROW_LEFT:
                input.notifyNoMoreMoveLeft();
                break;

            case ARROW_RIGHT:
                input.notifyNoMoreMoveRight();
                break;

            case SPACE_BAR:
                input.notifyNoMoreInteracting();
                break;

            case LETTER_H:
                input.notifyNoMoreUsingHealingPotion();
                break;

            case LETTER_B:
                input.notifyNoMorePlacingBeacon();
                break;

            case LETTER_T:
                input.notifyNoMoreUsingTeleportSpell();
                break;
            case LETTER_S:
                input.notifyNoMoreUsingShieldSpell();
                break;

            case LETTER_D:
                input.notifyNoMoreUsingDriftSpell();
                break;
            case LETTER_R:
                input.notifyNoMoreUsingRegenerationSpell();
                break;

            case LETTER_I:
                input.notifyNoMoreUsingInvisibilitySpell();
                break;
            case LETTER_L:
                input.notifyNoMoreUsingLightSpell();
                break;

            case LETTER_O:
                input.notifyNotTurnLight();
                break;
            default:
                break;
        }
    }
}
