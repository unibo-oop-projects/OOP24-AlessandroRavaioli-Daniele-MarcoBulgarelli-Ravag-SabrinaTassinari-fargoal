package fargoal.entity.monster;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import fargoal.model.core.GameEngine;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.api.MonsterFactory;
import fargoal.model.entity.monsters.impl.MonsterFactoryImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;

public class TestMonsterGeneration {

    private static FloorManager manager = new FloorManagerImpl(new GameEngine());
    private static MonsterFactory factory = new MonsterFactoryImpl(1);
    private static List<String> monsters = Stream.of(" ").collect(Collectors.toList());
    private static Monster monster;

    @Test
    void FirstFloors() {
        monsters.clear();
        monsters = Stream.of("ROGUE", "BARBARIAN").collect(Collectors.toList());
        for (int i = 0; i < 50; i++) {
            monster = factory.generate(manager.getFloorMap().getRandomTile(), 
                    manager.getFloorMap(), 
                    manager, 
                    manager.getRenderFactory());
            if (i == 10) {
                manager.increaseFloorLevel();
            } else if (i == 25) {
                manager.increaseFloorLevel();
            }
            assertTrue(monsters.stream().anyMatch(p -> p.equals(monster.getTag())));
        }
        for(int i = 0; i < 2; i++) {
            manager.decreaseFloorLevel();
        }
    }
        
    @Test
    void FourthFloor() {
        for(int i = 0; i < 3; i++) {
            manager.increaseFloorLevel();
        }
        for (int i = 0; i < 50; i++) {
            monster = factory.generate(manager.getFloorMap().getRandomTile(), 
                    manager.getFloorMap(), 
                    manager, 
                    manager.getRenderFactory());
            
            assertEquals("MONK", monster.getTag());
        }
        for(int i = 0; i < 3; i++) {
            manager.decreaseFloorLevel();
        }
    }

    @Test
    void FifthAndSixthFloor() {
        monsters.clear();
        monsters = Stream.of("MONK", "WAR_LORD", "SPIDER").collect(Collectors.toList());
        for(int i = 0; i < 4; i++) {
            manager.increaseFloorLevel();
        }
        for (int i = 0; i < 50; i++) {
            monster = factory.generate(manager.getFloorMap().getRandomTile(), 
                    manager.getFloorMap(), 
                    manager, 
                    manager.getRenderFactory());
            if (i == 25) {
                manager.increaseFloorLevel();
            }
            assertTrue(monsters.stream().anyMatch(p -> p.equals(monster.getTag())));
        }
        for(int i = 0; i < 5; i++) {
            manager.decreaseFloorLevel();;
        }
    }

    @Test
    void SeventhAndEighthFloor() {
        monsters.clear();
        monsters = Stream.of("WAR_LORD", "SPIDER", "MAGE").collect(Collectors.toList());
        for(int i = 0; i < 6; i++) {
            manager.increaseFloorLevel();
        }
        for (int i = 0; i < 50; i++) {
            monster = factory.generate(manager.getFloorMap().getRandomTile(), 
                    manager.getFloorMap(), 
                    manager, 
                    manager.getRenderFactory());
            if (i == 25) {
                manager.increaseFloorLevel();
            }
            assertTrue(monsters.stream().anyMatch(p -> p.equals(monster.getTag())));
        }
        for(int i = 0; i < 7; i++) {
            manager.decreaseFloorLevel();;
        }
    }

    @Test
    void NinthPlusFloor() {
        monsters.clear();
        monsters = Stream.of("WAR_LORD", "SPIDER", "MAGE", "ASSASSIN").collect(Collectors.toList());
        for(int i = 0; i < 8; i++) {
            manager.increaseFloorLevel();
        }
        for (int i = 0; i < 50; i++) {
            monster = factory.generate(manager.getFloorMap().getRandomTile(), 
                    manager.getFloorMap(), 
                    manager, 
                    manager.getRenderFactory());
            if (i == 10) {
                manager.increaseFloorLevel();
            } else if (i == 25) {
                manager.increaseFloorLevel();
            } else if (i == 35) {
                manager.increaseFloorLevel();
            } else if (i == 45) {
                manager.increaseFloorLevel();
            }
            assertTrue(monsters.stream().anyMatch(p -> p.equals(monster.getTag())));
        }
        for(int i = 0; i < 12; i++) {
            manager.decreaseFloorLevel();
        }
    }
    
}
