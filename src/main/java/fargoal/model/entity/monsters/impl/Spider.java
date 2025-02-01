package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.map.api.FloorMap;

public class Spider extends AbstractMonster{

    private final int POSSIBLE_DIRECTIONS = 4;

    public Spider(Position position, Integer level, FloorMap floorMap) {
        setMonsterType(MonsterType.SPIDER);
        setPosition(position);
        setFloorMap(floorMap);
        setSkill(level);
    }

    @Override
    public String getTag() {
        return "SPIDER";
    }

    @Override
    public void move() {
        boolean check = false;
        Position add;
        
        do {
            int num = getRandom(POSSIBLE_DIRECTIONS);

            // try to move the spider to the right
            if(num == 0) {
                add = new Position(1, 0);
                var pos = getPosition().add(add);
                if(getFloorMap().isTile(pos)) {
                    setPosition(pos);
                    check = true;
                } else if(pos.x() < getFloorMap().getSize().length() && 
                            pos.y() < getFloorMap().getSize().height() &&
                            pos.x() >= 0 &&
                            pos.y() >= 0) {
                                if(getFloorMap().isTile(pos.add(add))) {
                                    setPosition(pos.add(add));
                                    check = true;
                                }
                            }

            // try to move the spider down
            } else if(num == 1) {
                add = new Position(0, 1);
                var pos = getPosition().add(add);
                if(getFloorMap().isTile(pos)) {
                    setPosition(pos);
                    check = true;
                } else if(pos.x() < getFloorMap().getSize().length() && 
                            pos.y() < getFloorMap().getSize().height() &&
                            pos.x() >= 0 &&
                            pos.y() >= 0) {
                                if(getFloorMap().isTile(pos.add(add))) {
                                    setPosition(pos.add(add));
                                    check = true;
                                }
                            }
            
            // try to move the spider to the left
            } else if(num == 2) {
                add = new Position(-1, 0);
                var pos = getPosition().add(add);
                if(getFloorMap().isTile(pos)) {
                    setPosition(pos);
                    check = true;
                } else if(pos.x() < getFloorMap().getSize().length() && 
                            pos.y() < getFloorMap().getSize().height() &&
                            pos.x() >= 0 &&
                            pos.y() >= 0) {
                                if(getFloorMap().isTile(pos.add(add))) {
                                    setPosition(pos.add(add));
                                    check = true;
                                }
                            }

            // try to move the spider up                     
            } else {
                add = new Position(0, -1);
                var pos = getPosition().add(add);
                if(getFloorMap().isTile(pos)) {
                    setPosition(pos);
                    check = true;
                } else if(pos.x() < getFloorMap().getSize().length() && 
                            pos.y() < getFloorMap().getSize().height() &&
                            pos.x() >= 0 &&
                            pos.y() >= 0) {
                                if(getFloorMap().isTile(pos.add(add))) {
                                    setPosition(pos.add(add));
                                    check = true;
                                }
                            }
            }
        }while(!check);

    }

    @Override
    public void attack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public void steal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }
    
}
