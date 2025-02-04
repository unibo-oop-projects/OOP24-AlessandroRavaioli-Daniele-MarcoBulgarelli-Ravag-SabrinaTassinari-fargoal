package fargoal.model.entity.monsters.ai;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.impl.Spider;
import fargoal.model.entity.player.api.Player;

/**
 * Class to allow monster to move, trying to reach
 * the player (if in range of visibility).
 */
public class Ai {

    private static final Integer POSSIBLE_DIRECTIONS = 2;
    private static final Integer MAX_DISTANCE = 10;
    private static final Integer MAX_TRY = 15;

    /**
     * Method that actualy moves the monster towards the
     * player, or otherwise randomly.
     * 
     * @param monster - the monster to be moved
     * @param player - the player to be reached
     */
    public static void move(final AbstractMonster monster, final Player player) {
        int xDistance = Math.abs(monster.getPosition().x() - player.getPosition().x());
        int yDistance = Math.abs(monster.getPosition().y() - player.getPosition().y());
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
        if (xDistance < MAX_DISTANCE && yDistance < MAX_DISTANCE) {
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
                pos = monster.getPosition()
                        .add(new Position(monster.getRandom(POSSIBLE_DIRECTIONS), monster.getRandom(POSSIBLE_DIRECTIONS)));
                cont++;
            } while (monster.getFloorMap().isTile(pos) || cont == MAX_TRY);
            if (cont != MAX_TRY) {
                monster.setPosition(pos);
            }
        } 
    }

    /**
     * Method to make the spiders move, which unlike other monsters
     * can also climb walls.
     * 
     * @param spider - the spider to be moved
     * @param player - the player to be reached
     */
    public static void moveSpider(final Spider spider, final Player player) {
        int xDistance = Math.abs(spider.getPosition().x() - player.getPosition().x());
        int yDistance = Math.abs(spider.getPosition().y() - player.getPosition().y());
        boolean xMonsterBigger = false;
        boolean yMonsterBigger = false;
        Position pos;

        if (spider.getPosition().x() >= player.getPosition().x()) {
            xMonsterBigger = true;
        }
        if (spider.getPosition().y() >= player.getPosition().y()) {
            yMonsterBigger = true;
        }

        if (xDistance < MAX_DISTANCE && yDistance < MAX_DISTANCE) {
            if (xDistance >= yDistance) {
                if (xMonsterBigger) {
                    pos = spider.getPosition().decreaseX();
                    if (!spider.getFloorMap().isTile(pos)) {
                        spider.setVisibilityOff();
                    } else {
                        spider.setVisibilityOn();
                    }
                } else {
                    pos = spider.getPosition().increaseX();
                    if (!spider.getFloorMap().isTile(pos)) {
                        spider.setVisibilityOff();
                    } else {
                        spider.setVisibilityOn();
                    }
                }
            } else {
                if (yMonsterBigger) {
                    pos = spider.getPosition().decreaseY();
                    if (!spider.getFloorMap().isTile(pos)) {
                        spider.setVisibilityOff();
                    } else {
                        spider.setVisibilityOn();
                    }
                } else {
                    pos = spider.getPosition().increaseY();
                    if (!spider.getFloorMap().isTile(pos)) {
                        spider.setVisibilityOff();
                    } else {
                        spider.setVisibilityOn();
                    }
                }
            }
        } else {
            do {
                pos = spider.getPosition()
                        .add(new Position(spider.getRandom(POSSIBLE_DIRECTIONS), spider.getRandom(POSSIBLE_DIRECTIONS)));
            } while (pos.x() < spider.getFloorMap().getSize().length()
                    && pos.y() < spider.getFloorMap().getSize().height()
                    && pos.x() >= 0
                    && pos.y() >= 0);
            spider.setPosition(pos);
            if (spider.getFloorMap().isTile(pos)) {
                spider.setVisibilityOn();
            } else {
                spider.setVisibilityOff();
            }
        }
    }   
}
