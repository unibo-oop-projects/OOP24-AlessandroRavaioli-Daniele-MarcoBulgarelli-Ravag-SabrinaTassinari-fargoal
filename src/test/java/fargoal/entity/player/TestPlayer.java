package fargoal.entity.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.ModuleLayer.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.controller.input.api.KeyboardInputController;
import fargoal.model.core.GameEngine;
import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;
import fargoal.view.impl.InventoryInformationRenderer;
import fargoal.view.impl.PlayerInformationRenderer;

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
        player.move(new Position(0, 0));
        assertEquals(0, player.getPosition().x());
        assertEquals(0, player.getPosition().y());
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
        player.move(new Position(1, 0));
        assertEquals(1, player.getPosition().x());
        assertEquals(0, player.getPosition().y());
    }
}
