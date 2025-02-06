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
        System.out.println("ciao");
        for(int i = 0; i < 3; i++) {
            manager.increaseFloorLevel();
        }
        System.out.println("ho passato il floorlevel");
        monster = monsterFactory.generate(manager.getFloorMap().getRandomTile(), manager.getFloorMap(), manager);
        System.out.println("porcaccio");
    }

    @Test
    void visualizeFloor() {
        System.out.print(" ");
        for(int i = 0; i < 40; i++) {
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int i = 0; i < 25; i++) {
            int k = i;
            System.out.print(i + " ");
            for (int j = 0; j < 40; j++) {
                int x = j;
                System.out.print(
                    monster.getPosition().equals(new Position(x, k))
                    ? "*" + " "
                    : manager.getPlayer().getPosition().equals(new Position(x, k))
                    ? "X" + "  "
                    : manager.getMonsters().stream().anyMatch(p -> p.getPosition().equals(new Position(x, k)))
                    ? "@" + "  "
                    : manager.getFloorMap().isTile(new Position(x, k))
                    ? "O" + "  "
                    : " " + "  ");
            }
            System.out.println();
        }
    }

    @Test
    void visualizeMonster() {
        System.out.println(monster.getSkill() + " " + monster.getHealth().getCurrentHealth() + " " + monster.getPosition() + " " + monster.getTag());
        assertEquals("MONK", monster.getTag());
        System.out.println(manager.getPlayer().getPosition());
        for(int i = 0; i < 15; i++) {
            Ai.move(monster, manager.getPlayer());
            System.out.println("ciao2");
            System.out.println(monster.getPosition());
        }
        System.out.println(monster.getPosition());
    }
    
}
