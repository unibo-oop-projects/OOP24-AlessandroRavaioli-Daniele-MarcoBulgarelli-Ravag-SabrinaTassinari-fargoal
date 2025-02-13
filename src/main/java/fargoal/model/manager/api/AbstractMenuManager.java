package fargoal.model.manager.api;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.controller.input.api.MenuInputComponent;
import fargoal.model.commons.Timer;
import fargoal.model.core.GameEngine;

public abstract class AbstractMenuManager implements MenuManager{
    
    private static final int MILLIS_TO_WAIT = 150;

    private final Timer selectionTimer;
    private final MenuInputComponent inputComponent;
    private final KeyboardInputController ctrl;
    private int selected;

    public AbstractMenuManager(final GameEngine engine, final MenuInputComponent inputComponent) {
        resetSelected();
        this.inputComponent = inputComponent;
        this.selectionTimer = new Timer();
        this.ctrl = engine.getController();
        this.selectionTimer.setTime(MILLIS_TO_WAIT);
    }

    @Override
    public void increaseSelected() {
        this.selected++;
        if (resetCondition()) {
            resetSelected();
        }
    }

    @Override
    public void decreaseSelected() {
        this.selected--;
        if (resetCondition()) {
            resetSelected();
        }
    }

    @Override
    public void update(final GameEngine engine){
        if (this.selectionTimer.updateTime(engine.getElapsedTime()) == 0) {
            this.inputComponent.update(this, this.ctrl);
            this.selectionTimer.setTime(MILLIS_TO_WAIT); 
        }
    }

    public int getSelected() {
        return this.selected;
    }

    public void setSelected(final int newValue) {
        this.selected = newValue;
    }

    public abstract boolean resetCondition();

    public abstract void resetSelected();
}
