package fargoal.map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.entity.monsters.impl.MonsterFactoryImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;

public class TestMonsters {

    private static FloorManager manager;
    private static FloorMap map;
    private static AbstractMonster monster;
    private static final MonsterFactory monsterFactory = new MonsterFactoryImpl();

    @BeforeAll
    static void init() {
        manager = new FloorManagerImpl();
        map = new FloorConstructorImpl().createFloor();
        monster = monsterFactory.generateRogue(new Position(0, 0), 2, map, manager);
    }

    @Test
    void visualizeMonster() {
        System.out.println(monster.getSkill() + " " + monster.getHealth() + " " + monster.getPosition());
        monster.move(manager);
        System.out.println(monster.getPosition());
    }
    
}
