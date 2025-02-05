package fargoal.entity.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fargoal.model.entity.player.impl.InventoryImpl;
import fargoal.model.entity.player.api.Inventory;

public class TestInventory {
    
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new InventoryImpl();
    }

    @Test
    void testInitialInventory(){
        assertEquals(0, inventory.getHealingPotions());
        assertEquals(0, inventory.getBeacons());
        assertEquals(0, inventory.getMagicSacks());
        assertEquals(0, inventory.getEnchantedWeapons());
        assertEquals(List.of(), inventory.getListOfMaps());
        assertEquals(0, inventory.getInvisibilityScrolls());
        assertEquals(0, inventory.getTeleportScrolls());
        assertEquals(0, inventory.getShieldScrolls());
        assertEquals(0, inventory.getRegenerationScrolls());
        assertEquals(0, inventory.getDriftScrolls());
        assertEquals(0, inventory.getLightScrolls());
    }

    @Test
    void testAddElement() {
        inventory.addHealingPotion();
        inventory.addBeacon();
        inventory.addMagicSack();
        inventory.addEnchantedWeapon();
        inventory.addFloorMap(5);
        inventory.addInvisibilityScroll();
        inventory.addTeleportScroll();
        inventory.addShieldScroll();
        inventory.addRegenerationScroll();
        inventory.addDriftScroll();
        inventory.addLightScroll();

        assertEquals(1, inventory.getHealingPotions());
        assertEquals(1, inventory.getBeacons());
        assertEquals(1, inventory.getMagicSacks());
        assertEquals(1, inventory.getEnchantedWeapons());
        assertEquals(List.of(5), inventory.getListOfMaps());
        assertEquals(1, inventory.getInvisibilityScrolls());
        assertEquals(1, inventory.getTeleportScrolls());
        assertEquals(1, inventory.getShieldScrolls());
        assertEquals(1, inventory.getRegenerationScrolls());
        assertEquals(1, inventory.getDriftScrolls());
        assertEquals(1, inventory.getLightScrolls());

    }

    @Test
    void mapListTest() {
        inventory.addFloorMap(11);
        inventory.addFloorMap(11);
        assertEquals(List.of(11), inventory.getListOfMaps());

        inventory.removeFloorMap(11);
        inventory.addFloorMap(22);
        inventory.addFloorMap(3);
        assertEquals(List.of(22, 3), inventory.getListOfMaps());
        assertThrows(IllegalArgumentException.class, () -> inventory.addFloorMap(null));
        assertThrows(IllegalArgumentException.class, () -> inventory.addFloorMap(-6));
        assertThrows(IllegalArgumentException.class, () -> inventory.removeFloorMap(null));
        assertThrows(IllegalArgumentException.class, () -> inventory.removeFloorMap(-3));
    }

    @Test
    void removeElement() {
        inventory.removeHealingPotion();
        inventory.removeBeacon();
        inventory.removeFloorMap(5);
        inventory.removeInvisibilityScroll();
        inventory.removeTeleportScroll();
        inventory.removeShieldScroll();
        inventory.removeRegenerationScroll();
        inventory.removeDriftScroll();
        inventory.removeLightScroll();

        assertEquals(0, inventory.getHealingPotions());
        assertEquals(0, inventory.getBeacons());
        assertEquals(0, inventory.getMagicSacks());
        assertEquals(0, inventory.getEnchantedWeapons());
        assertEquals(List.of(), inventory.getListOfMaps());
        assertEquals(0, inventory.getInvisibilityScrolls());
        assertEquals(0, inventory.getTeleportScrolls());
        assertEquals(0, inventory.getShieldScrolls());
        assertEquals(0, inventory.getRegenerationScrolls());
        assertEquals(0, inventory.getDriftScrolls());
        assertEquals(0, inventory.getLightScrolls());
    }

    @Test
    void mixedTest() {
        inventory.addLightScroll();
        inventory.addTeleportScroll();
        inventory.addTeleportScroll();
        inventory.addInvisibilityScroll();
        inventory.addTeleportScroll();
        inventory.addDriftScroll();
        inventory.addFloorMap(3);
        inventory.addLightScroll();
        inventory.addTeleportScroll();
        inventory.addInvisibilityScroll();

        inventory.removeLightScroll();
        inventory.removeLightScroll();
        inventory.removeHealingPotion();
        inventory.removeBeacon();
        inventory.removeDriftScroll();

        assertEquals(0, inventory.getHealingPotions());
        assertEquals(0, inventory.getBeacons());
        assertEquals(0, inventory.getMagicSacks());
        assertEquals(0, inventory.getEnchantedWeapons());
        assertEquals(List.of(3), inventory.getListOfMaps());
        assertEquals(2, inventory.getInvisibilityScrolls());
        assertEquals(4, inventory.getTeleportScrolls());
        assertEquals(0, inventory.getShieldScrolls());
        assertEquals(0, inventory.getRegenerationScrolls());
        assertEquals(0, inventory.getDriftScrolls());
        assertEquals(0, inventory.getLightScrolls());

        assertFalse(inventory.removeHealingPotion());
        assertFalse(inventory.removeBeacon());
        assertTrue(inventory.removeFloorMap(3));
        assertTrue(inventory.removeInvisibilityScroll());
        assertTrue(inventory.removeTeleportScroll());
        assertFalse(inventory.removeShieldScroll());
        assertFalse(inventory.removeRegenerationScroll());
        assertFalse(inventory.removeDriftScroll());
        assertFalse(inventory.removeLightScroll());
    }
}
