/*package fargoal.entity.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.ModuleLayer.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fargoal.controller.input.api.KeyboardInputController;
import fargoal.model.core.GameEngine;
import fargoal.model.entity.player.impl.PlayerImpl;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.view.api.View;
import fargoal.view.impl.InventoryInformationRenderer;
import fargoal.view.impl.PlayerInformationRenderer;

public class TestPlayer {

    private FloorManager manager = new FloorManagerImpl(new GameEngine());
    private Player player = manager.getPlayer(); 

    @Test
    void TestInitialization() {
        assertEquals(1, player.getLevel());
        assertEquals(0, player.getExperiencePoints());
        assertEquals(200, player.getExperiencePointsRequired());
        assertEquals(0, player.getCurrentGold());
        assertEquals(100, player.getMaxGoldCapacity());
        assertNotNull(player.getHealth());
        assertNotNull(player.getInventory());
        assertNotNull(player.getPosition());
        assertNotNull(player.getSkill());
        assertEquals("PLAYER", player.getTag());
        assertFalse(player.hasLight());
        assertFalse(player.hasSword());
        assertEquals(0, player.getNumberOfSlainFoes());
        assertFalse(player.isImmune());
        assertTrue(player.isVisible());
    }
}
*/