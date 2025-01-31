package fargoal.model.entity.monsters.api;

public interface MonsterFactory {

    //public AbstractMonster generateMonster(Integer level);
    
    AbstractMonster generateRogue();

    AbstractMonster generateBarbarian();

    AbstractMonster generateMonk();

    AbstractMonster generateAssassin();

    AbstractMonster generateWarLord();

    AbstractMonster generateMage();

    AbstractMonster generateSpider();
}
