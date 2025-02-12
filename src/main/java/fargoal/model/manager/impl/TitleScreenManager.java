package fargoal.model.manager.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.controller.input.api.MenuInputComponent;
import fargoal.model.commons.Timer;
import fargoal.model.core.GameEngine;
import fargoal.model.manager.api.MenuManager;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;
import fargoal.view.impl.SwingRendererMiddle;
import fargoal.view.impl.SwingRendererTop;
import fargoal.view.impl.SwingView;

/**
 * Class that work and implements methods to allow the Title screen
 * to work correctly.
 */
public class TitleScreenManager implements MenuManager {

    private static final int NUMBER_OF_OPTIONS = 2;
    private static final long MILLIS_TO_WAIT = 150;
    private static final int POSSIBILITIES_DIVISOR_WIDTH = 50;
    private static final int POSSIBILITIES_DIVISOR_HEIGHT = 7;
    private static final int GAME_START_MULTIPLIER_WIDTH = 21;
    private static final int GAME_EXIT_MULTIPLIER_WIDTH = 23;
    private static final int TITLE_DIVISION_WIDTH = 5;
    private static final int DIVISOR_FONT_TOP_HEIGHT = 4;
    private static final int DIVISOR_FONT_MIDDLE_HEIGHT = 100;

    private int selected;
    private final MenuInputComponent inputComp;
    private final KeyboardInputController ctrl;
    private Renderer menu;
    private Renderer title;
    private boolean timeToQuit;
    private boolean start;
    private final Timer wait;
    /**
     * Constructor that set all the local fields to the starting values.
     * 
     * @param engine - to get the priority in the scene
     */
    public TitleScreenManager(final GameEngine engine) {
        this.selected = 1;
        this.inputComp = new MenuInputComponent();
        this.ctrl = engine.getController();
        this.timeToQuit = false;
        this.start = false;
        this.wait = new Timer();
        this.wait.setTime(MILLIS_TO_WAIT);
        createRenderers(engine.getView());
    }

    /** {@inheritDoc} */
    @Override
    public void update(final GameEngine engine) {
        if (timeToQuit) {
            engine.stop();
        } else if (start) {
            setSceneManager(engine);
        }
        if (this.wait.updateTime(engine.getElapsedTime()) == 0) {
            this.inputComp.update(this, this.ctrl);
            this.wait.setTime(MILLIS_TO_WAIT);
        }
        this.menu.render();
        this.title.render();
    }

    /** {@inheritDoc} */
    @Override
    public void setSceneManager(final GameEngine engine) {
        engine.setSceneManager(new FloorManagerImpl(engine));
    }
    /** {@inheritDoc} */
    @Override
    public void increaseSelected() {
        selected++;
        if (selected > NUMBER_OF_OPTIONS) {
            selected = 1;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void decreaseSelected() {
        selected--;
        if (selected < 1) {
            selected = NUMBER_OF_OPTIONS;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void select() {
        if (this.selected == 1) {
            start = true;
        } else {
            timeToQuit = true;
        }
    }

    /**
     * Method that create and set the renderer of the top and middle part about
     * what they have to display.
     * 
     * @param view - the view of entire game
     */
    private void createRenderers(final View view) {
        final SwingView sView = (SwingView) view;
        this.menu = new SwingRendererMiddle(g2d -> {
                g2d.setFont(new Font("Arial", Font.BOLD, sView.getFrame().getBounds().height * 3 / DIVISOR_FONT_MIDDLE_HEIGHT));
                g2d.setColor((this.selected == 1) ? Color.cyan : Color.red);
                g2d.drawString("START GAME",
                        sView.getMapWidth() * GAME_START_MULTIPLIER_WIDTH / POSSIBILITIES_DIVISOR_WIDTH,
                        sView.getMapHeight() * 1 / POSSIBILITIES_DIVISOR_HEIGHT);
                g2d.setColor((this.selected == 2) ? Color.cyan : Color.red);
                g2d.drawString("EXIT",
                        sView.getMapWidth() * GAME_EXIT_MULTIPLIER_WIDTH / POSSIBILITIES_DIVISOR_WIDTH,
                        sView.getMapHeight() * 3 / POSSIBILITIES_DIVISOR_HEIGHT);
        }, view);
        this.title = new SwingRendererTop(g2d -> {
            g2d.setFont(new Font("Arial", Font.BOLD, sView.getEventPanel().getBounds().height * 1 / DIVISOR_FONT_TOP_HEIGHT));
            g2d.setColor(Color.WHITE);
            g2d.drawString("FARGOAL",
                    sView.getMapWidth() * 2 / TITLE_DIVISION_WIDTH,
                    sView.getEventPanel().getBounds().height / 2);
        }, view);
    }
}
