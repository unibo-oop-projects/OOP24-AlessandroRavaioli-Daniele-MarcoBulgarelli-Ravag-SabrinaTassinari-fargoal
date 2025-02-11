package fargoal.controller.input.api;

public class KeyboardInputController implements InputController {

    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isMoveLeft;
    private boolean isMoveRight;
    private boolean isInteracting;

    private boolean isUsingHealingPotion;
    private boolean isPlacingBeacon;
    private boolean isUsingTeleportSpell;
    private boolean isUsingShieldSpell;
    private boolean isUsingDriftSpell;
    private boolean isUsingRegenerationSpell;
    private boolean isUsingInvisibilitySpell;
    private boolean isUsingLightSpell;
    private boolean isTurningLight;

    public KeyboardInputController() {
        this.reset();
    }

    public void reset() {
        this.notifyNoMoreMoveDown();
        this.notifyNoMoreInteracting();
        this.notifyNoMoreMoveLeft();
        this.notifyNoMoreMoveRight();
        this.notifyNoMoreMoveUp();
        this.notifyNoMorePlacingBeacon();
        this.notifyNoMoreUsingDriftSpell();
        this.notifyNoMoreUsingHealingPotion();
        this.notifyNoMoreUsingInvisibilitySpell();
        this.notifyNoMoreUsingLightSpell();
        this.notifyNotTurnLight();
        this.notifyNoMoreUsingRegenerationSpell();
        this.notifyNoMoreUsingShieldSpell();
        this.notifyNoMoreUsingTeleportSpell();
    }

    @Override
    public boolean isInteracting() {
        return isInteracting;
    }

    @Override
    public boolean isMoveDown() {
        return isMoveDown;
    }

    @Override
    public boolean isMoveLeft() {
        return isMoveLeft;
    }

    @Override
    public boolean isMoveRight() {
        return isMoveRight;
    }

    @Override
    public boolean isMoveUp() {
        return isMoveUp;
    }

    @Override
    public boolean isPlacingBeacon() {
        return isPlacingBeacon;
    }

    @Override
    public boolean isUsingDriftSpell() {
        return isUsingDriftSpell;
    }

    @Override
    public boolean isUsingHealingPotion() {
        return isUsingHealingPotion;
    }

    @Override
    public boolean isUsingInvisibilitySpell() {
        return isUsingInvisibilitySpell;
    }

    @Override
    public boolean isUsingLightSpell() {
        return isUsingLightSpell;
    }

    @Override
    public boolean isTurningLight() {
        return isTurningLight;
    }

    @Override
    public boolean isUsingRegenerationSpell() {
        return isUsingRegenerationSpell;
    }

    @Override
    public boolean isUsingShieldSpell() {
        return isUsingShieldSpell;
    }

    @Override
    public boolean isUsingTeleportSpell() {
        return isUsingTeleportSpell;
    } 

    public void notifyInteracting() {
        isInteracting = true;
    }

    public void notifyNoMoreInteracting() {
        isInteracting = false;
    }

    public void notifyMoveDown() {
        isMoveDown = true;
    }

    public void notifyNoMoreMoveDown() {
        isMoveDown = false;
    }

    public void notifyMoveLeft() {
        isMoveLeft = true;
    }

    public void notifyNoMoreMoveLeft() {
        isMoveLeft = false;
    }

    public void notifyMoveRight() {
        isMoveRight = true;
    }

    public void notifyNoMoreMoveRight() {
        isMoveRight = false;
    }

    public void notifyMoveUp() {
        isMoveUp = true;
    }

    public void notifyNoMoreMoveUp() {
        isMoveUp = false;
    }

    public void notifyPlacingBeacon() {
        isPlacingBeacon = true;
    }

    public void notifyNoMorePlacingBeacon() {
        isPlacingBeacon = false;
    }

    public void notifyUsingDriftSpell() {
        isUsingDriftSpell = true;
    }

    public void notifyNoMoreUsingDriftSpell() {
        isUsingDriftSpell = false;
    }

    public void notifyUsingHealingPotion() {
        isUsingHealingPotion = true;
    }

    public void notifyNoMoreUsingHealingPotion() {
        isUsingHealingPotion = false;
    }

    public void notifyUsingInvisibilitySpell() {
        isUsingInvisibilitySpell = true;
    }

    public void notifyNoMoreUsingInvisibilitySpell() {
        isUsingInvisibilitySpell = false;
    }

    public void notifyUsingLightSpell() {
        isUsingLightSpell = true;  
    }

    public void notifyNoMoreUsingLightSpell() {
        isUsingLightSpell = false;;
    }

    public void notifyTurnLight() {
        isTurningLight = true;
    }

    public void notifyNotTurnLight() {
        isTurningLight = false;
    }

    public void notifyUsingRegenerationSpell() {
        isUsingRegenerationSpell = true;
    }

    public void notifyNoMoreUsingRegenerationSpell() {
        isUsingRegenerationSpell = false;
    }

    public void notifyUsingShieldSpell() {
        isUsingShieldSpell = true;
    }

    public void notifyNoMoreUsingShieldSpell() {
        isUsingShieldSpell = false;
    }

    public void notifyUsingTeleportSpell() {
        isUsingTeleportSpell = true;
    } 

    public void notifyNoMoreUsingTeleportSpell() {
        isUsingTeleportSpell = false;
    } 

}
