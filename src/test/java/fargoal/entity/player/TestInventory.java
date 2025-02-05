package fargoal.entity.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fargoal.model.entity.player.impl.InventoryImpl;

public class TestInventory {
    
    private InventoryImpl inventory;

    @BeforeEach
    void setUp(){
        inventory = new InventoryImpl();
    }

    @Test
    void testInitialInventory(){
        assertEquals(inventory.getHealingPotions(), 0);
        assertEquals(inventory.getBeaconScrolls(), 0);
        assertEquals(inventory.getShieldScrolls(), 0);
        assertEquals(inventory.getTeleportScrolls(), 0);
        assertEquals(inventory.getInvisibilityScrolls(), 0);
    }

    @Test
    void testAddElement() {
        inventory.addBeaconScroll();
        inventory.addHealingPotion();
        inventory.addInvisibilityScroll();
        inventory.addShieldScroll();
        inventory.addTeleportScroll();

        assertEquals(inventory.getBeaconScrolls(), 1);
        assertEquals(inventory.getHealingPotions(), 1);
        assertEquals(inventory.getInvisibilityScrolls(), 1);
        assertEquals(inventory.getShieldScrolls(), 1);
        assertEquals(inventory.getTeleportScrolls(), 1);
    }

    @Test
    void removeElement() {
        inventory.removeHealingPotion();
        inventory.removeBeaconScroll();
        inventory.removeInvisibilityScroll();
        inventory.removeShieldScroll();
        inventory.removeTeleportScroll();

        assertEquals(inventory.getBeaconScrolls(), 0);
        assertEquals(inventory.getHealingPotions(), 0);
        assertEquals(inventory.getInvisibilityScrolls(), 0);
        assertEquals(inventory.getShieldScrolls(), 0);
        assertEquals(inventory.getTeleportScrolls(), 0);
    }

    @Test
    void mixedTest() {
        inventory.addBeaconScroll();
        inventory.addBeaconScroll();
        inventory.addShieldScroll();
        inventory.removeBeaconScroll();
        inventory.removeHealingPotion();

        assertEquals(inventory.getBeaconScrolls(), 1);
        assertEquals(inventory.getHealingPotions(), 0);
        assertEquals(inventory.getInvisibilityScrolls(), 0);
        assertEquals(inventory.getShieldScrolls(), 1);
        assertEquals(inventory.getTeleportScrolls(), 0);
    }
}
