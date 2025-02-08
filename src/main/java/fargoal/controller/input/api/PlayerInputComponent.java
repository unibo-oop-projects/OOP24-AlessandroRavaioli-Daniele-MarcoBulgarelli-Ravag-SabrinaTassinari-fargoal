package fargoal.controller.input.api;

import java.util.Optional;

import fargoal.model.commons.FloorElement;
import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

public class PlayerInputComponent implements InputComponent{

    public void update(FloorManager manager, PlayerImpl player, InputController controller) {
        
        if(controller.isInteracting()) {
            Optional<Interactable> interacting = manager.getInteractables().stream().filter(element -> player.getPosition().equals(element.getPosition())).findAny();
            interacting.ifPresent(element -> element.interact(manager));
        } else if(controller.isUsingHealingPotion()) {
            if(player.getInventory().getHealingPotions() > 0) {
                //TODO
            }
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
