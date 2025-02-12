package fargoal.controller.input.api;

import java.util.Optional;

import fargoal.commons.api.Position;
import fargoal.model.entity.player.api.Player;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.SceneManager;

/**
 * Class that refresh everything that the player does or interact with.
 */
public class PlayerInputComponent implements InputComponent {

    /**
     * Method that based on the inputs processed that he received, chooses what action
     * the player has to do.
     * 
     * @param manager - to get all the infos he needs
     * @param player - to move the player or let him interact with FloorElements
     * @param controller - to receive the processed inputs
     */
    @Override
    public void update(final SceneManager sceneManager, final InputController controller) {
        if (!(sceneManager instanceof FloorManager)) {
            throw new IllegalArgumentException("Expected a FloorManager");
        }
        final FloorManager manager = (FloorManager) sceneManager;
        final Player player = manager.getPlayer();
        
        if (controller.isInteracting()) {
            final Optional<Interactable> interacting = manager.getInteractables()
                    .stream()
                    .filter(element -> player.getPosition().equals(element.getPosition()))
                    .findAny();
            interacting.ifPresent(element -> element.interact(manager));
        } else if (controller.isUsingHealingPotion()) {
            if (player.getInventory().getHealingPotions().getNumberInInventory() > 0) {
                player.getInventory().getHealingPotions().use(manager);
            }
        } else if (controller.isPlacingBeacon()) {
            if (player.getInventory().getBeacons().getNumberInInventory() > 0) {
                player.getInventory().getBeacons().use(manager);
            }
        } else if (controller.isUsingDriftSpell()) {
            if (player.getInventory().getDriftSpell().getNumberInInventory() > 0) {
                player.getInventory().getDriftSpell().use(manager);
            }
        } else if (controller.isUsingInvisibilitySpell()) {
            if (player.getInventory().getInvisibilitySpell().getNumberInInventory() > 0) {
                player.getInventory().getInvisibilitySpell().use(manager);
            }
        } else if (controller.isUsingLightSpell()) {
            if (player.getInventory().getLightSpell().getNumberInInventory() > 0) {
                player.getInventory().getLightSpell().use(manager);
            }
        } else  if (controller.isTurningLight()) {
            player.getInventory().getLightSpell().turnLight(manager);
        } else if (controller.isUsingRegenerationSpell()) {
            if (player.getInventory().getRegenerationSpell().getNumberInInventory() > 0) {
                player.getInventory().getRegenerationSpell().use(manager);
            }
        } else if (controller.isUsingShieldSpell()) {
            if (player.getInventory().getShieldSpell().getNumberInInventory() > 0) {
                player.getInventory().getShieldSpell().use(manager);
            }
        } else if (controller.isUsingTeleportSpell()) {
            if (player.getInventory().getTeleportSpell().getNumberInInventory() > 0) {
                player.getInventory().getTeleportSpell().use(manager);
            }
        } else if (controller.isMoveUp() && controller.isMoveRight()) {
            final var pos = player.getPosition().add(new Position(1, -1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if (controller.isMoveRight() && controller.isMoveDown()) {
            final var pos = player.getPosition().add(new Position(1, 1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if (controller.isMoveDown() && controller.isMoveLeft()) {
            final var pos = player.getPosition().add(new Position(-1, 1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if (controller.isMoveLeft() && controller.isMoveUp()) {
            final var pos = player.getPosition().add(new Position(-1, -1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if (controller.isMoveDown()) {
            final var pos = player.getPosition().add(new Position(0, 1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if (controller.isMoveUp()) {
            final var pos = player.getPosition().add(new Position(0, -1));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if (controller.isMoveLeft()) {
            final var pos = player.getPosition().add(new Position(-1, 0));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
                            if (monster.getPosition().equals(player.getPosition())) {
                                monster.receiveDamage();
                                player.receiveDamage(monster);
                                break;
                            }
                        }
                    } else if (manager.getFloorMap().isTile(pos)) {
                        player.setPosition(pos);
                    }
        } else if (controller.isMoveRight()) {
            final var pos = player.getPosition().add(new Position(1, 0));
            if (manager.getMonsters()
                    .stream()
                    .anyMatch(p -> p.getPosition().equals(pos))) {
                        for (final var monster : manager.getMonsters()) {
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
