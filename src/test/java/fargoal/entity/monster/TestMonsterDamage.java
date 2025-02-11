package fargoal.entity.monster;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.core.GameEngine;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.entity.monsters.impl.MonsterFactoryImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;

public class TestMonsterDamage {

    private static FloorManager floorManager = new FloorManagerImpl(new GameEngine());
    private static Monster monster;
    private static MonsterFactory factory = new MonsterFactoryImpl(1);
    private static Random random = new Random(); 
    
    @BeforeAll
    static void setup() {
        List<Position> positions;
        do {
        monster = factory.generate(floorManager.getFloorMap().getRandomTile(),  
                floorManager, 
                floorManager.getRenderFactory());
        positions = Stream.of(new Position(-1, -1), new Position(0, -1), new Position(1, -1),
                new Position(-1, 0), new Position(1, 0),
                new Position(-1, 1), new Position(0, 1), new Position(1, 1))
                .map(p -> p.add(monster.getPosition()))
                .filter(p -> floorManager.getFloorMap().isTile(p))
                .collect(Collectors.toList());
        } while (positions.isEmpty());
        floorManager.getPlayer().setPosition(positions.get(random.nextInt(positions.size())));
    }

    @Test
    void attack() {
        assertEquals(floorManager.getPlayer().getHealth().getCurrentHealth(), 
                floorManager.getPlayer().getHealth().getMaxHealth());
        
        floorManager.getPlayer().receiveDamage(monster);
        assertNotEquals(floorManager.getPlayer().getHealth().getCurrentHealth(), 
                floorManager.getPlayer().getHealth().getMaxHealth());

        assertEquals(monster.getHealth().getCurrentHealth(), monster.getHealth().getMaxHealth());
        monster.receiveDamage();
        assertNotEquals(monster.getHealth().getCurrentHealth(), monster.getHealth().getMaxHealth());
        if (monster.getHealth().getCurrentHealth() < 0) {
            assertTrue(monster.isDead());
        } else {
            assertTrue(!monster.isDead());
        }
    }

    
}
