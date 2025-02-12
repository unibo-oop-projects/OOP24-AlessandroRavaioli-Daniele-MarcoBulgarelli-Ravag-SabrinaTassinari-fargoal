package fargoal.interactable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.model.core.GameEngine;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickupable.inside_chest.impl.ChestImpl;
import fargoal.model.interactable.pickupable.inside_chest.spell.api.SpellType;
import fargoal.model.interactable.pickupable.inside_chest.trap.impl.CeilingTrap;
import fargoal.model.interactable.pickupable.inside_chest.trap.impl.Explosion;
import fargoal.model.interactable.pickupable.inside_chest.trap.impl.Pit;
import fargoal.model.interactable.pickupable.inside_chest.trap.impl.Teleport;
import fargoal.model.interactable.pickupable.on_ground.BeaconOnGround;
import fargoal.model.interactable.pickupable.on_ground.SackOfMoney;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.impl.FloorManagerImpl;

/**
 * This class tests the interactables and the usables of the game.
 */
class TestInteractable {
    private static FloorManager floorManager = new FloorManagerImpl(new GameEngine());
    private static final int N_DAMAGE = 5;

     /**
     * This test checks the creation of an item when a chest is opened.
     */
     @Test
     void checkCreationItem() {
          final ChestImpl chest = new ChestImpl(new Position(0, 0), floorManager.getRenderFactory());
          chest.interact(floorManager);
    }

     /**
     * This test checks if the drift spell works: it checks the amount in the inventory after and before use
     * and it checks that when the player falls in a pit, but the spell is cast, there is no damage.
     */
     @Test
     void checkDriftSpell() {
          final int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
          final int levelFloor = floorManager.getFloorLevel();
          floorManager.getPlayer().getInventory().getDriftSpell().store();
          final int numberBefore = floorManager.getPlayer().getInventory().getDriftSpell().getNumberInInventory();
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

     /**
     * This test checks if the invisibility spell works: it checks the amount in the inventory after and before use
     * and it checks if the player can be seen or not.
     */
     @Test
     void checkInvisibilitySpell() {
          assertTrue(floorManager.getPlayer().isVisible());
          floorManager.getPlayer().getInventory().getInvisibilitySpell().store();
          final int numberBefore = floorManager.getPlayer().getInventory().getInvisibilitySpell().getNumberInInventory();
          floorManager.getPlayer().useInvisibilitySpell();
          assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getInvisibilitySpell().getNumberInInventory());
          assertFalse(floorManager.getPlayer().isVisible());
          assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.INVISIBILITY.getName()));
     }

     /**
     * This test checks if the light spell works: it checks the amount in the inventory after and before use
     * and it checks if the light is on.
     */
     @Test
     void checkLightSpell() {
          floorManager.getPlayer().getInventory().getLightSpell().store();
          final int numberBefore = floorManager.getPlayer().getInventory().getLightSpell().getNumberInInventory();
          floorManager.getPlayer().useLightSpell();
          assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getInvisibilitySpell().getNumberInInventory());
          assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.LIGHT.getName()));
          assertTrue(floorManager.getPlayer().hasLight());
          floorManager.getPlayer().getInventory().getLightSpell().turnLight(floorManager);
          assertFalse(floorManager.getPlayer().hasLight());
     }

     /**
     * This test checks if the regeneration spell works: it checks the amount in the inventory after and before use
     * and it checks if the regeneratin of the hit points is faster.
     */
     @Test
     void checkRegenerationSpell() {
          floorManager.getPlayer().getInventory().getRegenerationSpell().store();
          final int numberBefore = floorManager.getPlayer().getInventory().getRegenerationSpell().getNumberInInventory();
          floorManager.getPlayer().useRegenerationSpell();
          assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getRegenerationSpell().getNumberInInventory());
          assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.REGENERATION.getName()));
     }

     /**
     * This test checks if the shield spell works: it checks the amount in the inventory after and before use.
     */
     @Test
     void checkShieldSpell() {
          floorManager.getPlayer().getInventory().getShieldSpell().store();
          final int numberBefore = floorManager.getPlayer().getInventory().getShieldSpell().getNumberInInventory();
          floorManager.getPlayer().useShieldSpell();
          assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getShieldSpell().getNumberInInventory());
          assertTrue(floorManager.getPlayer().getInventory().getSpellCasted().get(SpellType.SHIELD.getName()));
     }

     /**
     * This test checks if the teleport spell works: it checks the amount in the inventory after and before use
     * and it checks if the player is teleported.
     */
     @Test
     void checkTeleportSpell() {
          final Position positionBefore = floorManager.getPlayer().getPosition();
          floorManager.getPlayer().getInventory().getTeleportSpell().store();
          final int numberBefore = floorManager.getPlayer().getInventory().getTeleportSpell().getNumberInInventory();
          floorManager.getPlayer().useTeleportSpell();
          assertNotEquals(numberBefore, floorManager.getPlayer().getInventory().getTeleportSpell().getNumberInInventory());
          assertNotEquals(positionBefore, floorManager.getPlayer().getPosition());
     }

     /**
     * This test checks if the ceiling trap works: it checks if the player is damaged.
     */
     @Test
     void checkCeilingTrap() {
          final int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
          new CeilingTrap(floorManager);
          assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
     }

     /**
     * This test checks if the explosion trap works: it checks if the player is damaged.
     */
     @Test
     void checkExplosionTrap() {
          final int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
          new Explosion(floorManager);
          assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
     }

     /**
     * This test checks if the pit trap works: it checks if the player is damaged.
     */
     @Test
     void checkPitTrap() {
          final int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
          new Pit(floorManager);
          assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
     }

     /**
     * This test checks if the teleport trap works: it checks if the player is teleported.
     */
     @Test
     void checkTeleportTrap() {
          final Position positionBefore = floorManager.getPlayer().getPosition();
          new Teleport(floorManager);
          assertNotEquals(positionBefore, floorManager.getPlayer().getPosition());
     }

     /**
     * This test checks if the beacon works: it checks the amount of beacon in the inventory before and after use, it checks if 
     * the beacon on ground make the player immune and it check if the player, when he teleport himself, is on the beacon.
     */
     @Test
     void checkBeacon() {
          floorManager.getPlayer().getInventory().getBeacons().store();
          final int numberInInventory = floorManager.getPlayer().getInventory().getBeacons().getNumberInInventory();
          floorManager.getPlayer().useBeacon();
          assertNotEquals(numberInInventory, floorManager.getPlayer().getInventory().getBeacons().getNumberInInventory());
          final FloorElement beacon = floorManager.getAllElements().stream().
               filter(e -> e instanceof BeaconOnGround).findFirst().get();
          assertEquals(floorManager.getPlayer().getPosition(), beacon.getPosition());
          floorManager.getAllElements().stream().filter(e -> e instanceof BeaconOnGround).findFirst().get().update(floorManager);
          assertTrue(floorManager.getPlayer().isImmune());
          floorManager.getPlayer().setPosition(floorManager.getFloorMap().getRandomTile());
          assertNotEquals(floorManager.getPlayer().getPosition(), beacon.getPosition());
          floorManager.getPlayer().useTeleportSpell();
          assertEquals(beacon.getPosition(), floorManager.getPlayer().getPosition());
     }

     /**
     * This test checks if the enchanted weapon works: it checks the amount of beacon in the inventory before and after the
     * player find it and it checks if the skill of the player is increased.
     */
     @Test
     void checkEnchantedWeapon() {
          final int skillBefore = floorManager.getPlayer().getSkill();
          final int numberInInventory = floorManager.getPlayer().getInventory().getEnchantedWeapons().getNumberInInventory();
          floorManager.getPlayer().getInventory().getEnchantedWeapons().store();
          assertNotEquals(skillBefore, floorManager.getPlayer().getSkill());
          assertNotEquals(numberInInventory, floorManager.getPlayer().getInventory().
               getEnchantedWeapons().getNumberInInventory());
     }

     /**
     * This test checks if the healing potion works: it checks the amount of potions in the inventory before and after use and
     * it checks if the health is increased after use.
     */
     @Test
     void checkHealingPotion() {
          assertEquals(1, floorManager.getPlayer().getInventory().getHealingPotions().getNumberInInventory());
          floorManager.getPlayer().getInventory().getHealingPotions().store();
          assertEquals(2, floorManager.getPlayer().getInventory().getHealingPotions().getNumberInInventory());
          floorManager.getPlayer().getHealth().decreaseHealth(N_DAMAGE);
          final int healthBefore = floorManager.getPlayer().getHealth().getCurrentHealth();
          floorManager.getPlayer().useHealingPotion();
          assertNotEquals(healthBefore, floorManager.getPlayer().getHealth().getCurrentHealth());
          assertEquals(1, floorManager.getPlayer().getInventory().getHealingPotions().getNumberInInventory());
     }

     /**
     * This test checks if the magic sack works: it checks the amount of magic sack in the inventory before and after the 
     * player find it and it check how much gold the player can carry.
     */
     @Test
     void checkMagicSack() {
          assertEquals(1, floorManager.getPlayer().getInventory().getMagicSacks().getNumberInInventory());
          assertEquals(100, floorManager.getPlayer().getMaxGoldCapacity());
          floorManager.getPlayer().getInventory().getMagicSacks().store();
          assertEquals(2, floorManager.getPlayer().getInventory().getMagicSacks().getNumberInInventory());
          assertEquals(floorManager.getPlayer().getInventory().getMagicSacks().getNumberInInventory() * 100, 
               floorManager.getPlayer().getMaxGoldCapacity());
     }

     /**
     * This test checks if the map works: it checks the amount of maps in the inventory before and after the player find it and
     * it check if the map has been removed or not.
     */
     @Test
     void checkMap() {
          floorManager.getPlayer().getInventory().getListOfMaps().store();
          assertFalse(floorManager.getPlayer().getInventory().getListOfMaps().getListOfMaps().isEmpty());
          floorManager.getPlayer().getInventory().getListOfMaps().removeUtility();
          assertTrue(floorManager.getPlayer().getInventory().getListOfMaps().getListOfMaps().isEmpty());
     }

     /**
     * This test checks if the sack of moneythe player find on the ground works: it checks the amount of gold
     * in the inventory before and after the sack has been opened.
     */
     @Test
     void checkSackOfMoney() {
          assertEquals(0, floorManager.getPlayer().getCurrentGold());
          final Interactable sackOfGold = floorManager.getInteractables().stream().
               filter(e -> e instanceof SackOfMoney).findFirst().get();
          floorManager.getPlayer().setPosition(sackOfGold.getPosition());
          sackOfGold.interact(floorManager);
          assertNotEquals(0, floorManager.getPlayer().getCurrentGold());
     }
}
