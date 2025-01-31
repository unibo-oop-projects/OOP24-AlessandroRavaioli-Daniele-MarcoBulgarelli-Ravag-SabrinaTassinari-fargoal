package fargoal.model.entity.monsters.api;

import fargoal.api.*;
import fargoal.model.map.api.*;

public interface MonsterFactory {

    //public AbstractMonster generateMonster(Integer level);
    
    AbstractMonster generateRogue(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateBarbarian(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateMonk(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateAssassin(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateWarLord(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateMage(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateSpider(Position position, Integer level, FloorMap floorMap);
}
