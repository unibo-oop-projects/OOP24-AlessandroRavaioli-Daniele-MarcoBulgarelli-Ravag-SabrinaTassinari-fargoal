package fargoal.controller.input.api;

import java.util.Optional;

import fargoal.commons.api.Position;
import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

public class PlayerInputComponent implements InputComponent{

    public void update(FloorManager manager, PlayerImpl player, InputController controller) {
        
        if (controller.isInteracting()) {
            Optional<Interactable> interacting = manager.getInteractables()
                    .stream()
                    .filter(element -> player.getPosition().equals(element.getPosition()))
                    .findAny();
            interacting.ifPresent(element -> element.interact(manager));
        } else if (controller.isUsingHealingPotion()) {
            if (player.getInventory().getHealingPotions().getNumberInInventory() > 0) {
                player.getInventory().getHealingPotions().use(manager);
            }
        } else if(controller.isPlacingBeacon()) {
            if (player.getInventory().getBeacons().getNumberInInventory() > 0) {
                player.getInventory().getBeacons().use(manager);
            }
        } else if(controller.isUsingDriftSpell()) {
            if (player.getInventory().getDriftSpell().getQuantity() > 0) {
                player.getInventory().getDriftSpell().use(manager);
            }
        } else if(controller.isUsingInvisibilitySpell()) {
            if (player.getInventory().getInvisibilitySpell().getQuantity() > 0) {
                player.getInventory().getInvisibilitySpell().use(manager);
            }
        } else if(controller.isUsingLightSpell()) {
            if (player.getInventory().getLightSpell().getQuantity() > 0) {
                player.getInventory().getLightSpell().use(manager);
            }
        } else if(controller.isUsingRegenerationSpell()) {
            if (player.getInventory().getRegenerationSpell().getQuantity() > 0) {
                player.getInventory().getRegenerationSpell().use(manager);
            }
        } else if(controller.isUsingShieldSpell()) {
            if (player.getInventory().getShieldSpell().getQuantity() > 0) {
                player.getInventory().getShieldSpell().use(manager);
            }
        } else if(controller.isUsingTeleportSpell()) {
            if (player.getInventory().getTeleportSpell().getQuantity() > 0) {
                player.getInventory().getTeleportSpell().use(manager);
            }
        } else if(controller.isMoveUp() && controller.isMoveRight()) {
            var pos = player.getPosition().add(new Position(1, -1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if(controller.isMoveRight() && controller.isMoveDown()) {
            var pos = player.getPosition().add(new Position(1, 1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if(controller.isMoveDown() && controller.isMoveLeft()) {
            var pos = player.getPosition().add(new Position(-1, 1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if(controller.isMoveLeft() && controller.isMoveUp()) {
            var pos = player.getPosition().add(new Position(-1, -1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if(controller.isMoveDown()) {
            var pos = player.getPosition().add(new Position(0, 1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if(controller.isMoveUp()) {
            var pos = player.getPosition().add(new Position(0, -1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if(controller.isMoveLeft()) {
            var pos = player.getPosition().add(new Position(-1, 0));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if(controller.isMoveRight()) {
            var pos = player.getPosition().add(new Position(1, 0));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        }

    }

}
