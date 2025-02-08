package fargoal.controller.input.api;

import fargoal.model.commons.FloorElement;

public class PlayerInputComponent implements InputComponent{

    public void update(FloorElement player, InputController controller) {
        
        if(controller.isInteracting()) {
            //TODO
        } else if(controller.isUsingHealingPotion()) {
            //TODO
        } else if(controller.isPlacingBeacon()) {
            //TODO
        } else if(controller.isUsingDriftSpell()) {
            //TODO
        } else if(controller.isUsingInvisibilitySpell()) {
            //TODO
        } else if(controller.isUsingLightSpell()) {
            //TODO
        } else if(controller.isUsingRegenerationSpell()) {
            //TODO
        } else if(controller.isUsingShieldSpell()) {
            //TODO
        } else if(controller.isUsingTeleportSpell()) {
            //TODO
        } else if(controller.isMoveUp() && controller.isMoveRight()) {
            //TODO
        } else if(controller.isMoveRight() && controller.isMoveDown()) {
            //TODO
        } else if(controller.isMoveDown() && controller.isMoveLeft()) {
            //TODO
        } else if(controller.isMoveLeft() && controller.isMoveUp()) {
            //TODO
        } else if(controller.isMoveDown()) {
            //TODO
        } else if(controller.isMoveUp()) {
            //TODO
        } else if(controller.isMoveLeft()) {
            //TODO
        } else if(controller.isMoveRight()) {
            //TODO
        }

    }

}
