package fargoal.model.entity.monsters.ai;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.impl.Spider;
import fargoal.model.entity.player.api.Player;

public class Ai {

    private final static Integer POSSIBLE_DIRECTIONS = 2;
    private final static Integer MAX_DISTANCE = 10;

    public static void move(AbstractMonster monster, Player player) {
        Integer xDistance = Math.abs(monster.getPosition().x() - player.getPosition().x());
        Integer yDistance = Math.abs(monster.getPosition().y() - player.getPosition().y());
        boolean xMonsterBigger = false;
        boolean yMonsterBigger = false;
        Position pos;
        
        if(monster.getPosition().x() >= player.getPosition().x()) {
            xMonsterBigger = true;
        }
        if(monster.getPosition().y() >= player.getPosition().y()) {
            yMonsterBigger = true;
        }
        //controllo se il mostro vede il player
        if(xDistance < MAX_DISTANCE && yDistance < MAX_DISTANCE) {
            //nel caso sia piu lontano nelle ascisse
            if(xDistance >= yDistance) {
                //controllo se l'ascissa del mostro è maggiore di quella del player
                if(xMonsterBigger) {
                    pos = monster.getPosition().decreaseX();
                    if(monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                    }
                //se invece è minore
                } else {
                    pos = monster.getPosition().increaseX();
                    if(monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                    }
                }
            //se invece è piu lontano nelle ordinate
            } else {
                //controllo se l'ordinata del mostro è maggiore di quella del player
                if(yMonsterBigger) {
                    pos = monster.getPosition().decreaseY();
                    if(monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                    }
                //se invece è minore
                } else {
                    pos = monster.getPosition().increaseY();
                    if(monster.getFloorMap().isTile(pos)) {
                        monster.setPosition(pos);
                    } else {

                    }
                }
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
