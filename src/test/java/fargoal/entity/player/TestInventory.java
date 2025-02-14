package fargoal.entity.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fargoal.model.entity.player.impl.InventoryImpl;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;
import fargoal.model.core.GameEngine;
import fargoal.model.entity.player.api.Inventory;
import fargoal.model.entity.player.api.Player;

class TestInventory {
    private Inventory inventory;
    private final FloorManager manager = new FloorManagerImpl(new GameEngine());
    private final Player player = manager.getPlayer();
    private final Inventory playerInventory = player.getInventory();

    /**
     * Configurates the inventory before each test.
     * If this class gets extended, make sure to call {@code super.setup()}
     * to maintain the configuration.
     */
    @BeforeEach
    void setUp() {
        inventory = new InventoryImpl(manager);
    }

    @Test
    void testInitialInventory() {
        assertEquals(1, inventory.getHealingPotions().getNumberInInventory());
        assertEquals(0, inventory.getBeacons().getNumberInInventory());
        assertEquals(1, inventory.getMagicSacks().getNumberInInventory());
        assertEquals(0, inventory.getEnchantedWeapons().getNumberInInventory());
        assertEquals(0, inventory.getInvisibilitySpell().getNumberInInventory());
        assertEquals(1, inventory.getTeleportSpell().getNumberInInventory());
        assertEquals(0, inventory.getShieldSpell().getNumberInInventory());
        assertEquals(0, inventory.getRegenerationSpell().getNumberInInventory());
        assertEquals(0, inventory.getDriftSpell().getNumberInInventory());
        assertEquals(0, inventory.getLightSpell().getNumberInInventory());
        assertNotNull(inventory.getListOfMaps());
    }

    @Test
    void testSpellControl() {
        assertTrue(player.getInventory().areThereSpells());
        //CHECKSTYLE: MagicNumber OFF
        //10 is a random number to set the number of invisibility spells for test porpouses.
        playerInventory.getInvisibilitySpell().setNumberInInventory(10);
        //CHECKSTYLE: MagicNumber ON
        playerInventory.getInvisibilitySpell().removeSpell();

        //CHECKSTYLE: MagicNumber OFF
        //9 is the expected number of invisibility spells the player has after getting 10 and using one.
        assertEquals(9, playerInventory.getInvisibilitySpell().getNumberInInventory());
        //CHECKSTYLE: MagicNumber ON
    }
}
