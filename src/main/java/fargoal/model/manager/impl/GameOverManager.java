package fargoal.model.manager.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.controller.input.api.MenuInputComponent;
import fargoal.model.commons.Timer;
import fargoal.model.core.GameEngine;
import fargoal.model.manager.api.MenuManager;
import fargoal.model.manager.api.SceneManager;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;
import fargoal.view.impl.SwingRendererMiddle;
import fargoal.view.impl.SwingRendererTop;
import fargoal.view.impl.SwingView;

/**
 * Class that work and implements methods to allow the Menu screen
 * to work correctly.
 */
public class GameOverManager implements SceneManager, MenuManager {

    private static final int NUMBER_OF_OPTIONS = 2;
    private static final long MILLIS_TO_WAIT = 150;
    private static final int TITLE_DIVISION_WIDTH = 20;
    private static final int RETURN_MULTIPLIER_WIDTH = 19;
    private static final int POSSIBILITIES_DIVISOR_WIDTH = 50;
    private static final int CONSTANT_SEVEN = 7;
    private static final int GAME_EXIT_MULTIPLIER_WIDTH = 20;
    private static final int DIVISOR_FONT_TOP_HEIGHT = 4;
    private static final int DIVISOR_FONT_MIDDLE_HEIGHT = 110;

    private int selected;
    private final MenuInputComponent inputComp;
    private final KeyboardInputController ctrl;
    private final String text;
    private Renderer result;
    private Renderer menu;
    private boolean quit;
    private boolean backToMenu;
    private final Timer wait;

    /**
     * Constructor that set all the local fields to the starting values,
     * also based on the result of the game.
     * 
     * @param engine - to get the priority in the scene
     * @param text - to know what to display
     */
    public GameOverManager(final GameEngine engine, final String text) {
        this.text = text;
        this.selected = 1;
        this.quit = false;
        this.backToMenu = false;
        this.wait = new Timer();
        this.inputComp = new MenuInputComponent();
        this.ctrl = engine.getController();
        this.wait.setTime(MILLIS_TO_WAIT);
        setRenderers(engine.getView());
    }

    /** {@inheritDoc} */
    @Override
    public void update(final GameEngine engine) {
        if (quit) {
            engine.stop();
        } else if (backToMenu) {
            setSceneManager(engine);
        }
        if (this.wait.updateTime(engine.getElapsedTime()) == 0) {
            this.inputComp.update(this, this.ctrl);
            this.wait.setTime(MILLIS_TO_WAIT); 
        }
        this.menu.render();
        this.result.render();
    }

    /** {@inheritDoc} */
    @Override
    public void setSceneManager(final GameEngine engine) {
        engine.setSceneManager(new TitleScreenManager(engine));
    }
    /** {@inheritDoc} */
    @Override
    public void increaseSelected() {
        this.selected++;
        if (this.selected > NUMBER_OF_OPTIONS) {
            this.selected = 1;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void decreaseSelected() {
        this.selected--;
        if (this.selected < 1) {
            this.selected = NUMBER_OF_OPTIONS;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void select() {
        if (this.selected == 1) {
            this.backToMenu = true;
        } else {
            this.quit = true;
        }
    }

    /**
     * Method that set the renderer of the top and middle part about
     * what they have to display.
     * 
     * @param view - the view of entire game
     */
    private void setRenderers(final View view) {
        final SwingView sView = (SwingView) view;
        this.menu = new SwingRendererMiddle(g2d -> {
                g2d.setFont(new Font("Arial", Font.BOLD, sView.getFrame().getBounds().height * 3 / DIVISOR_FONT_MIDDLE_HEIGHT));
                g2d.setColor((this.selected == 1) ? Color.cyan : Color.red);
                g2d.drawString("RETURN TO TITLE",
                        sView.getMapWidth() * RETURN_MULTIPLIER_WIDTH / POSSIBILITIES_DIVISOR_WIDTH,
                        sView.getMapHeight() * 1 / CONSTANT_SEVEN);
                g2d.setColor((this.selected == 2) ? Color.cyan : Color.red);
                g2d.drawString("EXIT",
                        sView.getMapWidth() * GAME_EXIT_MULTIPLIER_WIDTH / POSSIBILITIES_DIVISOR_WIDTH,
                        sView.getMapHeight() * 3 / CONSTANT_SEVEN);
        }, view);
        this.result = new SwingRendererTop(g2d -> {
            g2d.setFont(new Font("Arial", Font.BOLD, sView.getEventPanel().getBounds().height / DIVISOR_FONT_TOP_HEIGHT));
            g2d.setColor(Color.WHITE);
            g2d.drawString(this.text,
                    sView.getMapWidth() * CONSTANT_SEVEN / TITLE_DIVISION_WIDTH,
                    sView.getEventPanel().getBounds().height / 2);
        }, view);
    }
}
