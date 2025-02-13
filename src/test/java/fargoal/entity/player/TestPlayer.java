package fargoal.entity.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import fargoal.commons.api.Position;
import fargoal.model.core.GameEngine;
import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.interactable.pickupable.inside_chest.spell.api.SpellType;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.monsters.impl.MonsterFactoryImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;

class TestPlayer {

    private FloorManager manager = new FloorManagerImpl(new GameEngine());
    private PlayerImpl player = (PlayerImpl) manager.getPlayer();

    @Test
    void TestInitialization() {
        assertEquals(1, player.getLevel());
        assertEquals(0, player.getExperiencePoints());
        assertEquals(200, player.getExperiencePointsRequired());
        assertNotNull(player.getHealth());
        assertNotNull(player.getSkill());
        assertEquals(0, player.getCurrentGold());
        assertEquals(100, player.getMaxGoldCapacity());
        assertNotNull(player.getInventory());
        assertEquals(0, player.getNumberOfSlainFoes());
        assertNotNull(player.getPlayerGold());
        assertEquals("PLAYER", player.getTag());
        assertFalse(player.hasSword());
        assertFalse(player.isFighting());
        assertFalse(player.isAttacked());
        assertTrue(player.isVisible());
        assertFalse(player.hasLight());
        assertFalse(player.isImmune());
        assertFalse(player.isDead());       
    }

    @Test
    void TestSetters() {
        player.setPlayerSkill(0);
        assertEquals(0, player.getSkill());
        player.setIsAttacked(true);
        assertTrue(player.isAttacked());
        player.setHasSword(true);
        assertTrue(player.hasSword());
        player.setIsVisible(false);
        assertFalse(player.isVisible());
        player.setHasLight(true);
        assertTrue(player.hasLight());
        player.setIsImmune(true);
        assertTrue(player.isImmune());
    }

    @Test
    void TestIncreasePlayerValues() {
        player.setPlayerSkill(0);
        player.increasePlayerSkill(10);
        assertEquals(10, player.getSkill());
        player.addExperiencePoints(22);
        assertEquals(22, player.getExperiencePoints());
        for(int i = 0; i < 10; i++) {
            player.increaseNumberOfSlainFoes();
        }
        assertEquals(10, player.getNumberOfSlainFoes());
    }

    @Test
    void TestLevelUp() {
        assertEquals(1, player.getLevel());
        assertEquals(0, player.getExperiencePoints());
        assertEquals(200, player.getExperiencePointsRequired());
        player.addExperiencePoints(200);
        player.levelUp();
        assertEquals(2, player.getLevel());
        assertEquals(200, player.getExperiencePoints());
        assertEquals(400, player.getExperiencePointsRequired());
        player.addExperiencePoints(1000);
        player.levelUp();
        player.levelUp();
        assertEquals(4, player.getLevel());
        assertEquals(1200, player.getExperiencePoints());
        assertEquals(1600, player.getExperiencePointsRequired());
        player.addExperiencePoints(399);
        player.levelUp();
        assertEquals(4, player.getLevel());
        assertEquals(1599, player.getExperiencePoints());
        assertEquals(1600, player.getExperiencePointsRequired());
    }

    @Test
    void TestMovement() {
        player.move(new Position(0, 0));
        assertEquals(0, player.getPosition().x());
        assertEquals(0, player.getPosition().y());
        player.move(new Position(1, 0));
        assertEquals(1, player.getPosition().x());
        assertEquals(0, player.getPosition().y());
        player.move(new Position(1, 1));
        assertEquals(1, player.getPosition().x());
        assertEquals(1, player.getPosition().y());
        player.move(new Position(15, 15));
        assertEquals(15, player.getPosition().x());
        assertEquals(15, player.getPosition().y());
    }

    @Test
    void TestBattleWon() {
        var monsterFactory = new MonsterFactoryImpl(1);
        Monster monster = monsterFactory.generate(new Position(0, 0), manager, manager.getRenderFactory());
        assertNotNull(monster);
        
        monster.getHealth().setHealth(1);
        int initialExp = player.getExperiencePoints();
        int initialFoes = player.getNumberOfSlainFoes();

        player.battle(monster);

        assertFalse(player.isFighting());
        assertFalse(player.isAttacked());
        assertTrue(player.getExperiencePoints() > initialExp);
        assertEquals(initialFoes + 1, player.getNumberOfSlainFoes());
    }

    @Test 
    void TestBattleLost() {
        var monsterFactory = new MonsterFactoryImpl(1);
        Monster monster = monsterFactory.generate(new Position(0, 0), manager, manager.getRenderFactory());
        assertNotNull(monster);

        player.getHealth().setHealth(1);

        player.battle(monster);

        assertFalse(player.isFighting());
    }

    @Test
    void TestPlayerDamage() {
        var monsterFactory = new MonsterFactoryImpl(1);
        Monster monster = monsterFactory.generate(new Position(0, 0), manager, manager.getRenderFactory());
        assertNotNull(monster);

        int damage = player.doDamage(monster);
        assertNotNull(damage);

        monster.receiveDamage();
        assertFalse(monster.getHealth().isHealthy());

        player.receiveDamage(monster);
        assertFalse(player.getHealth().isHealthy());
    }

    @Test
    void TestPlayerDeath() {
        player.getHealth().setHealth(0);
        assertTrue(player.isDead());
    }

    @Test
    void TestRegenerationNormalCondition() {
        player.getHealth().decreaseHealth(1);
        int hpBefore = player.getHealth().getCurrentHealth();
        
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.passiveRegeneration();
        int hpAfter = player.getHealth().getCurrentHealth();

        assertEquals(hpBefore + 1, hpAfter);
    }

    @Test
    void TestRegenerationSpellandTemple() {
        player.getHealth().decreaseHealth(1);
        int hpBefore = player.getHealth().getCurrentHealth();
        
        player.getInventory().getSpellCasted().put(SpellType.REGENERATION.getName(), true);
        player.move(manager.getTemple().getPosition());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        player.passiveRegeneration();
        int hpAfter = player.getHealth().getCurrentHealth();

        assertEquals(hpBefore + 1, hpAfter);
    }

    @Test
    void TestUseItems() {
        int invisibilityBefore = player.getInventory().getInvisibilitySpell().getNumberInInventory();
        int teleportBefore = player.getInventory().getTeleportSpell().getNumberInInventory();
        int shieldBefore = player.getInventory().getShieldSpell().getNumberInInventory();
        int regenerationBefore = player.getInventory().getRegenerationSpell().getNumberInInventory();
        int driftBefore = player.getInventory().getDriftSpell().getNumberInInventory();
        int lightBefore = player.getInventory().getLightSpell().getNumberInInventory();
        int potionBefore = player.getInventory().getHealingPotions().getNumberInInventory();
        int beaconBefore = player.getInventory().getBeacons().getNumberInInventory();

        player.useInvisibilitySpell();
        player.useTeleportSpell();
        player.useShieldSpell();
        player.useRegenerationSpell();
        player.useDriftSpell();
        player.useLightSpell();
        player.useBeacon();
        player.useHealingPotion();

        int invisibilityAfter = player.getInventory().getInvisibilitySpell().getNumberInInventory();
        int teleportAfter = player.getInventory().getTeleportSpell().getNumberInInventory();
        int shieldAfter = player.getInventory().getShieldSpell().getNumberInInventory();
        int regenerationAfter = player.getInventory().getRegenerationSpell().getNumberInInventory();
        int driftAfter = player.getInventory().getDriftSpell().getNumberInInventory();
        int lightAfter = player.getInventory().getLightSpell().getNumberInInventory();
        int potionAfter = player.getInventory().getHealingPotions().getNumberInInventory();
        int beaconAfter = player.getInventory().getBeacons().getNumberInInventory();

        assertEquals(Math.max(0, invisibilityBefore - 1), invisibilityAfter);
        assertEquals(Math.max(0, teleportBefore - 1), teleportAfter);
        assertEquals(Math.max(0, shieldBefore - 1), shieldAfter);
        assertEquals(Math.max(0, regenerationBefore - 1), regenerationAfter);
        assertEquals(Math.max(0, driftBefore - 1), driftAfter);
        assertEquals(Math.max(0, lightBefore - 1), lightAfter);
        assertEquals(Math.max(0, potionBefore - 1), potionAfter);
        assertEquals(Math.max(0, beaconBefore - 1), beaconAfter);

    }
}
