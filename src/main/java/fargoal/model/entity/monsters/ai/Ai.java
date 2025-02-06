package fargoal.model.entity.monsters.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;

/**
 * Class to allow monster to move, trying to reach
 * the player (if in range of visibility).
 */
public final class Ai {

    private static final Integer LIST_SIZE = 2;
    private static final Integer MAX_DISTANCE = 10;
    private static final Integer MAX_TRY = 15;
    private static final List<Integer> list = new ArrayList<>(List.of(-1, 1));
    private static final Random random = new Random();

    private Ai() {

    }

    /**
     * Method that actualy moves the monster towards the
     * player, or otherwise randomly.
     * 
     * @param monster - the monster to be moved
     * @param player - the player to be reached
     */
    public static void move(final Monster monster, final Player player) {
        final int xDistance = Math.abs(monster.getPosition().x() - player.getPosition().x());
        final int yDistance = Math.abs(monster.getPosition().y() - player.getPosition().y());
        boolean xMonsterBigger = false;
        boolean yMonsterBigger = false;
        Position pos;
        boolean check = false;
        if (monster.getPosition().x() >= player.getPosition().x()) {
            xMonsterBigger = true;
        }
        if (monster.getPosition().y() >= player.getPosition().y()) {
            yMonsterBigger = true;
        }
        //controllo se il mostro vede il player
        if (monster.getMonsterType().equals(MonsterType.SPIDER)) {
            if (xDistance < MAX_DISTANCE && yDistance < MAX_DISTANCE) {
                if (xDistance >= yDistance) {
                    if (xMonsterBigger) {
                        pos = monster.getPosition().decreaseX();
                        if (!monster.getFloorMap().isTile(pos)) {
                            monster.setVisibilityOff();
                        } else {
                            monster.setVisibilityOn();
                        }
                    } else {
                        pos = monster.getPosition().increaseX();
                        if (!monster.getFloorMap().isTile(pos)) {
                            monster.setVisibilityOff();
                        } else {
                            monster.setVisibilityOn();
                        }
                    }
                } else {
                    if (yMonsterBigger) {
                        pos = monster.getPosition().decreaseY();
                        if (!monster.getFloorMap().isTile(pos)) {
                            monster.setVisibilityOff();
                        } else {
                            monster.setVisibilityOn();
                        }
                    } else {
                        pos = monster.getPosition().increaseY();
                        if (!monster.getFloorMap().isTile(pos)) {
                            monster.setVisibilityOff();
                        } else {
                            monster.setVisibilityOn();
                        }
                    }
                }
            } else {
                do {
                    pos = monster.getPosition()
                            .add(new Position(list.get(random.nextInt(LIST_SIZE)), list.get(random.nextInt(LIST_SIZE))));
                } while (pos.x() > monster.getFloorMap().getSize().length()
                        && pos.y() > monster.getFloorMap().getSize().height()
                        && pos.x() <= 0
                        && pos.y() <= 0);
                monster.setPosition(pos);
                if (monster.getFloorMap().isTile(pos)) {
                    monster.setVisibilityOn();
                } else {
                    monster.setVisibilityOff();
                }
            }
        } else if (xDistance < MAX_DISTANCE && yDistance < MAX_DISTANCE) {
            //nel caso sia piu lontano nelle ascisse
            if (xDistance >= yDistance) {
                //controllo se l'ascissa del mostro è maggiore di quella del player
                if (xMonsterBigger) {
                    pos = monster.getPosition().decreaseX();
                    if (monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                        check = true;
                        //se la posizione è un muro, allora controllo se mi posso muovere nelle ordinate
                    } else if (yMonsterBigger) {
                        pos = monster.getPosition().decreaseY();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    } else {
                        pos = monster.getPosition().increaseY();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    }
                //se invece è minore
                } else {
                    pos = monster.getPosition().increaseX();
                    if (monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                        check = true;
                        //se la posizione è un muro, allora controllo se mi posso muovere nelle ordinate
                    } else if (yMonsterBigger) {
                        pos = monster.getPosition().decreaseY();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    } else {
                        pos = monster.getPosition().increaseY();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    }
                }
            //se invece è piu lontano nelle ordinate
            } else {
                //controllo se l'ordinata del mostro è maggiore di quella del player
                if (yMonsterBigger) {
                    pos = monster.getPosition().decreaseY();
                    if (monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                        check = true;
                        //se la posizione è un muro, allora controllo se mi posso muovere nelle ascisse
                    } else if (xMonsterBigger) {
                        pos = monster.getPosition().decreaseX();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    } else {
                        pos = monster.getPosition().increaseX();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    }
                //se invece è minore
                } else {
                    pos = monster.getPosition().increaseY();
                    if (monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                        check = true;
                        //se la posizione è un muro, allora controllo se mi posso muovere nelle ascisse
                    } else if (xMonsterBigger) {
                        pos = monster.getPosition().decreaseX();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    } else {
                        pos = monster.getPosition().increaseX();
                        if (monster.getFloorMap().isTile(pos)) {
                            monster.setPosition(pos);
                            check = true;
                        }
                    }
                }
            }
        }
        if (!check) {
            int cont = -1;
            do {
                System.out.println("Non vedo il player, mi muovo a caso");
                pos = monster.getPosition()
                        .add(new Position(list.get(random.nextInt(LIST_SIZE)), list.get(random.nextInt(LIST_SIZE))));
                cont++;
            } while (!monster.getFloorMap().isTile(pos) && cont != MAX_TRY);
            if (cont != MAX_TRY) {
                monster.setPosition(pos);
            }
        } 
    }
}
