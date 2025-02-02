package fargoal.model.entity.monsters.ai;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.impl.Spider;
import fargoal.model.entity.player.api.Player;

public class Ai {

    private final static Integer POSSIBLE_DIRECTIONS = 2;

    public static void move(AbstractMonster monster, Player player) {
        Position pos;
        if(monster.getPosition().x() - player.getPosition().x() < 10
                && monster.getPosition().y() - player.getPosition().y() < 10) {
                    //nel caso sia piu lontano nelle ascisse
                    if(Math.abs(monster.getPosition().x() - player.getPosition().x()) >= Math.abs(monster.getPosition().y() - player.getPosition().y())) {
                        if(monster.getPosition().x() > player.getPosition().x()) {
                            pos = monster.getPosition().increaseX();
                            if(monster.getFloorMap().isTile(pos)) {
                                monster.setPosition(pos);
                            }
                        } else {
                            pos = monster.getPosition().decreaseX();
                            if(monster.getFloorMap().isTile(pos)) {
                                monster.setPosition(pos);
                            }
                        }
                    //se invece è piu lontano nelle ordinate
                    } else {
                        
                    }


                } else {
                    do {
                        pos = monster.getPosition().add(new Position(monster.getRandom(POSSIBLE_DIRECTIONS), monster.getRandom(POSSIBLE_DIRECTIONS)));
                    } while (monster.getFloorMap().isTile(pos));
                    monster.setPosition(pos);
                }
    }

    public static void moveSpider(Spider spider, Player player) {

    }
    
}
