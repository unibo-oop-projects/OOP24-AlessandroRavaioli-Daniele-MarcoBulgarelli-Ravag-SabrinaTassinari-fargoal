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

public class GameOverManager implements SceneManager, MenuManager {

    private static final int NUMBER_OF_OPTIONS = 2;
    private static final long MILLIS_TO_WAIT = 200;

    private int selected;
    private final MenuInputComponent inputComp;
    private final KeyboardInputController ctrl;
    private final String text;
    private Renderer result;
    private Renderer menu;
    private boolean quit;
    private boolean backToMenu;
    private final Timer wait;

    public GameOverManager(GameEngine engine, String text) {
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

    @Override
    public void update(GameEngine engine) {
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

    @Override
    public void setSceneManager(GameEngine engine) {
        engine.setSceneManager(new TitleScreenManager(engine));
    }
    
    public void increaseSelected() {
        this.selected++;
        if (this.selected > NUMBER_OF_OPTIONS) {
            this.selected = 1;
        }
    }

    public void decreaseSelected() {
        this.selected--;
        if (this.selected < 1) {
            this.selected = NUMBER_OF_OPTIONS;
        }
    }

    @Override
    public void select() {
        if (this.selected == 1) {
            this.backToMenu = true;
        } else {
            this.quit = true;
        }
    }

    private void setRenderers(View view) {
        SwingView sView = (SwingView) view;
        this.menu = new SwingRendererMiddle(g2d -> {
                g2d.setFont(new Font("Arial", Font.BOLD, sView.getFrame().getBounds().height * 3 / 110));
                g2d.setColor((this.selected == 1) ? Color.cyan : Color.red);
                g2d.drawString("RETURN TO TITLE",
                        sView.getMapWidth() * 3/7,
                        sView.getMapHeight() * 1/7);
                g2d.setColor((this.selected == 2) ? Color.cyan : Color.red);
                g2d.drawString("EXIT",
                        sView.getMapWidth() * 3/7,
                        sView.getMapHeight() * 3/7);
        }, view);
        this.result = new SwingRendererTop(g2d -> {
            g2d.setFont(new Font("Arial", Font.BOLD, sView.getEventPanel().getBounds().height * 1/4));
            g2d.setColor(Color.WHITE);
            g2d.drawString(this.text,
                    sView.getMapWidth() * 3/7,
                    sView.getEventPanel().getBounds().height / 2);
        }, view);
    }
}
