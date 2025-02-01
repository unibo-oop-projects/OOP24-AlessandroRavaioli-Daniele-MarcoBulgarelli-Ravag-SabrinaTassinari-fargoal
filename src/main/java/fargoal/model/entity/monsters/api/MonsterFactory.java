package fargoal.model.entity.monsters.api;

import fargoal.commons.api.Position;
import fargoal.model.map.api.FloorMap;

public interface MonsterFactory {

    AbstractMonster generateRogue(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateBarbarian(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateMonk(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateAssassin(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateWarLord(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateMage(Position position, Integer level, FloorMap floorMap);

    AbstractMonster generateSpider(Position position, Integer level, FloorMap floorMap);
}
