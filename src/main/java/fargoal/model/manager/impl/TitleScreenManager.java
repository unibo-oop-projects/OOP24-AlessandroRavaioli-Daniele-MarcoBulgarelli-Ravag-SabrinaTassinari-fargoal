package fargoal.model.manager.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.controller.input.api.MenuInputComponent;
import fargoal.model.core.GameEngine;
import fargoal.model.manager.api.MenuManager;
import fargoal.model.manager.api.SceneManager;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;
import fargoal.view.impl.SwingRendererMiddle;
import fargoal.view.impl.SwingView;

public class TitleScreenManager implements SceneManager, MenuManager {

    private static final int NUMBER_OF_OPTIONS = 2;

    private int selected;
    private final MenuInputComponent inputComp;
    private final KeyboardInputController ctrl;
    private Renderer menu;
    private Renderer title;
    private boolean timeToQuit;
    private boolean start;
    

    public TitleScreenManager(GameEngine engine) {
        this.selected = 1;
        this.inputComp = new MenuInputComponent();
        this.ctrl = engine.getController();
        this.timeToQuit = false;
        this.start = false;
        createRenderers(engine.getView());
    }

    @Override
    public void update(GameEngine engine) {
        if (timeToQuit) {
            engine.stop();
        } else if (start) {
            setSceneManager(engine);
        }
        this.inputComp.update(this, this.ctrl);
        this.menu.render();
        // this.title.render();
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
                g2d.setColor((this.selected == 1) ? Color.cyan : Color.yellow);
                g2d.drawString("START GAME",
                        sView.getMapWidth() * 3/7,
                        sView.getMapHeight() * 1/7);
                g2d.setColor((this.selected == 2) ? Color.cyan : Color.yellow);
                g2d.drawString("EXIT",
                        sView.getMapWidth() * 3/7,
                        sView.getMapHeight() * 3/7);
        }, view);
    }
}
