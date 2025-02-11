package fargoal.interactable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.core.GameEngine;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.SpellType;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.impl.CeilingTrap;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.impl.Explosion;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.impl.Pit;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.impl.Teleport;
import fargoal.model.interactable.pickUpAble.insideChest.impl.ChestImpl;
import fargoal.model.interactable.pickUpAble.onGround.BeaconOnGround;
import fargoal.model.interactable.pickUpAble.onGround.SackOfMoney;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;

public class TestInteractable {
    
    private static FloorManager floorManager = new FloorManagerImpl(new GameEngine());
    private static Interactable chest;

   
    @Test
    void checkCreationItem() {
        chest = new ChestImpl(new Position(0, 0), floorManager.getRenderFactory());
        chest.interact(floorManager);        
    }

   @Test
   void checkDriftSpell() {
        int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
        int levelFloor = floorManager.getFloorLevel();
        floorManager.getPlayer().getInventory().getDriftSpell().store(floorManager);
        int numberBefore = floorManager.getPlayer().getInventory().getDriftSpell().getNumberInInventory();
        floorManager.getPlayer().useDriftSpell();
        assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getDriftSpell().getNumberInInventory());
        assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.DRIFT.getName()));
        new Pit(floorManager);
        assertEquals(floorManager.getFloorLevel(), levelFloor);
        assertFalse(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.DRIFT.getName()));
        assertEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
        new Pit(floorManager);
        assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
   }

   @Test
   void checkInvisibilitySpell() {
        assertTrue(floorManager.getPlayer().isVisible());
        floorManager.getPlayer().getInventory().getInvisibilitySpell().store(floorManager);
        int numberBefore = floorManager.getPlayer().getInventory().getInvisibilitySpell().getNumberInInventory();
        floorManager.getPlayer().useInvisibilitySpell();
        assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getInvisibilitySpell().getNumberInInventory());
        assertFalse(floorManager.getPlayer().isVisible());
        assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.INVISIBILITY.getName()));
   }

   @Test
   void checkLightSpell() {
        floorManager.getPlayer().getInventory().getLightSpell().store(floorManager);
        int numberBefore = floorManager.getPlayer().getInventory().getLightSpell().getNumberInInventory();
        floorManager.getPlayer().useLightSpell();
        assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getInvisibilitySpell().getNumberInInventory());
        assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.LIGHT.getName()));
        assertTrue(floorManager.getPlayer().hasLight());
        floorManager.getPlayer().getInventory().getLightSpell().turnLight(floorManager);
        assertFalse(floorManager.getPlayer().hasLight());
   }

   @Test
   void checkRegenerationSpell() {
        floorManager.getPlayer().getInventory().getRegenerationSpell().store(floorManager);
        int numberBefore = floorManager.getPlayer().getInventory().getLightSpell().getNumberInInventory();
        floorManager.getPlayer().useRegenerationSpell();
        assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getRegenerationSpell().getNumberInInventory());
        assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.REGENERATION.getName()));
   }

   @Test
   void checkShieldSpell() {
        floorManager.getPlayer().getInventory().getShieldSpell().store(floorManager);
        int numberBefore = floorManager.getPlayer().getInventory().getShieldSpell().getNumberInInventory();
        floorManager.getPlayer().useShieldSpell();
        assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getShieldSpell().getNumberInInventory());
        assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.SHIELD.getName()));
   }

   @Test
   void checkTeleportSpell() {
        Position positionBefore = floorManager.getPlayer().getPosition();
        floorManager.getPlayer().getInventory().getTeleportSpell().store(floorManager);
        int numberBefore = floorManager.getPlayer().getInventory().getTeleportSpell().getNumberInInventory();
        floorManager.getPlayer().useTeleportSpell();
        assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getTeleportSpell().getNumberInInventory());
        assertNotEquals(positionBefore, floorManager.getPlayer().getPosition());
   }

   @Test
   void checkCeilingTrap() {
        int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
        new CeilingTrap(floorManager);
        assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
   }

   @Test
   void checkExplosionTrap() {
        int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
        new Explosion(floorManager);
        assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
   }

   @Test
   void checkPitTrap() {
        int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
        new Pit(floorManager);
        assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
   }

   @Test
   void checkTeleportTrap() {
        Position positionBefore = floorManager.getPlayer().getPosition();
        new Teleport(floorManager);
        assertNotEquals(positionBefore, floorManager.getPlayer().getPosition());
   }

   @Test
   void checkBeacon() {
        floorManager.getPlayer().getInventory().getBeacons().store(floorManager);
        int numberInInventory = floorManager.getPlayer().getInventory().getBeacons().getNumberInInventory();
        floorManager.getPlayer().useBeacon();
        assertNotEquals(numberInInventory, floorManager.getPlayer().getInventory().getBeacons().getNumberInInventory());
        assertEquals(floorManager.getPlayer().getPosition(), floorManager.getAllElements().stream().
            filter(e -> e instanceof BeaconOnGround).findFirst().get().getPosition());
        floorManager.getAllElements().stream().filter(e -> e instanceof BeaconOnGround).findFirst().get().update(floorManager);
        assertTrue(floorManager.getPlayer().isImmune());
    }

    @Test
   void checkEnchantedWeapon() {
        int skillBefore = floorManager.getPlayer().getSkill();
        int numberInInventory = floorManager.getPlayer().getInventory().getEnchantedWeapons().getNumberInInventory();
        floorManager.getPlayer().getInventory().getEnchantedWeapons().store(floorManager);
        assertNotEquals(skillBefore, floorManager.getPlayer().getSkill());
        assertNotEquals(numberInInventory, floorManager.getPlayer().getInventory().getEnchantedWeapons().getNumberInInventory());
    }

    @Test
    void checkHealingPotion() {
        assertTrue(floorManager.getPlayer().getInventory().getHealingPotions().getNumberInInventory() == 1);
        floorManager.getPlayer().getInventory().getHealingPotions().store(floorManager);
        assertTrue(floorManager.getPlayer().getInventory().getHealingPotions().getNumberInInventory() == 2);
        floorManager.getPlayer().getHealth().decreaseHealth(5);
        int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
        floorManager.getPlayer().useHealingPotion();
        assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
        assertTrue(floorManager.getPlayer().getInventory().getHealingPotions().getNumberInInventory() == 1);
    }

    @Test
    void checkMagicSack() {
        assertTrue(floorManager.getPlayer().getInventory().getMagicSacks().getNumberInInventory() == 1);
        assertTrue(floorManager.getPlayer().getMaxGoldCapacity() == 100);
        floorManager.getPlayer().getInventory().getMagicSacks().store(floorManager);
        assertTrue(floorManager.getPlayer().getInventory().getMagicSacks().getNumberInInventory() == 2);
        assertTrue(floorManager.getPlayer().getInventory().getMagicSacks().getNumberInInventory() * 100 == floorManager.getPlayer().getMaxGoldCapacity());
    }

    @Test
    void checkMap() {
        floorManager.getPlayer().getInventory().getListOfMaps().store(floorManager);
        assertFalse(floorManager.getPlayer().getInventory().getListOfMaps().getListOfMaps().isEmpty());
        floorManager.getPlayer().getInventory().getListOfMaps().removeUtility();
        assertTrue(floorManager.getPlayer().getInventory().getListOfMaps().getListOfMaps().isEmpty());
    }

    @Test
    void checkSackOfMoney() {
        assertEquals(0, floorManager.getPlayer().getCurrentGold());
        Interactable sackOfGold = floorManager.getInteractables().stream().filter(e -> e instanceof SackOfMoney).findFirst().get();
        floorManager.getPlayer().setPosition(sackOfGold.getPosition());
        sackOfGold.interact(floorManager);
        assertNotEquals(0, floorManager.getPlayer().getCurrentGold());
    }

}
