package fargoal.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.entity.monsters.impl.MonsterFactoryImpl;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;
import fargoal.view.impl.SwingView;

public class TestMonsters {

    private static FloorManager manager;
    private static FloorMap map;
    private static Monster monster;
    private static final MonsterFactory monsterFactory = new MonsterFactoryImpl(7);

    @BeforeAll
    static void init() {
        manager = new FloorManagerImpl(new GameContext(new SwingView()));
        map = new FloorConstructorImpl().createFloor();
        for(int i = 0; i < 3; i++) {
            manager.increaseFloorLevel();
        }
        monster = monsterFactory.generate(new Position(2, 3), map, manager);
    }

    @Test
    void visualizeMonster() {
        System.out.println(monster.getSkill() + " " + monster.getHealth() + " " + monster.getPosition() + " " + monster.getTag());
        assertEquals("MONK", monster.getTag());
        Ai.move((AbstractMonster)monster, manager.getPlayer());
        System.out.println(monster.getPosition());
    }
    
}
