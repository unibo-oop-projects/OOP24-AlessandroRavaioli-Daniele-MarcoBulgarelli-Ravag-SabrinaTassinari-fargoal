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

public class TitleScreenManager implements SceneManager, MenuManager {

    private static final int NUMBER_OF_OPTIONS = 2;
    private static final long MILLIS_TO_WAIT = 200;

    private int selected;
    private final MenuInputComponent inputComp;
    private final KeyboardInputController ctrl;
    private Renderer menu;
    private Renderer title;
    private boolean timeToQuit;
    private boolean start;
    private final Timer wait;
    

    public TitleScreenManager(GameEngine engine) {
        this.selected = 1;
        this.inputComp = new MenuInputComponent();
        this.ctrl = engine.getController();
        this.timeToQuit = false;
        this.start = false;
        this.wait = new Timer();
        this.wait.setTime(MILLIS_TO_WAIT);
        createRenderers(engine.getView());
    }

    @Override
    public void update(GameEngine engine) {
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

    @Override
    public void setSceneManager(GameEngine engine) {
        engine.setSceneManager(new FloorManagerImpl(engine));
    }
    
    public void increaseSelected() {
        selected++;
        if (selected > NUMBER_OF_OPTIONS) {
            selected = 1;
        }
    }

    public void decreaseSelected() {
        selected--;
        if (selected < 1) {
            selected = NUMBER_OF_OPTIONS;
        }
    }

    @Override
    public void select() {
        if (this.selected == 1) {
            start = true;
        } else {
            timeToQuit = true;
        }
    }

    private void createRenderers(View view) {
        SwingView sView = (SwingView) view;
        this.menu = new SwingRendererMiddle(g2d -> {
                g2d.setFont(new Font("Arial", Font.BOLD, sView.getFrame().getBounds().height * 3 / 110));
                g2d.setColor((this.selected == 1) ? Color.cyan : Color.red);
                g2d.drawString("START GAME",
                        sView.getMapWidth() * 3/7,
                        sView.getMapHeight() * 1/7);
                g2d.setColor((this.selected == 2) ? Color.cyan : Color.red);
                g2d.drawString("EXIT",
                        sView.getMapWidth() * 3/7,
                        sView.getMapHeight() * 3/7);
        }, view);
        this.title = new SwingRendererTop(g2d -> {
            g2d.setFont(new Font("Arial", Font.BOLD, sView.getEventPanel().getBounds().height * 1/4));
            g2d.setColor(Color.WHITE);
            g2d.drawString("FARGOAL",
                    sView.getMapWidth() * 3/7,
                    sView.getEventPanel().getBounds().height / 2);
        }, view);
    }
}
