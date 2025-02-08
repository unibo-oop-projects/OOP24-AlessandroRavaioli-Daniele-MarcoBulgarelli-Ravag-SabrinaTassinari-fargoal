package fargoal.model.interactable.pickUpAble.insideChest.api;

import fargoal.commons.api.Position;
import fargoal.model.manager.api.FloorManager;

/**
 * The interface of the factory of the chest item.
 */
public interface ChestItemFactory {
    
    /**
     * This method generate a Drift Spell, which is a Spell.
     * @param floorManager - 
     * @param position - 
     * @return the chest item "Drift Spell".
     */
    ChestItem generateDriftSpell(FloorManager floorManager, final Position position);

    /**
     * This method generate an Invisibility Spell, which is a Spell.
     * @param floorManager -
     * @param position - 
     * @return the chest item "Invisibility Spell".
     */
    ChestItem generateInvisibilitySpell(FloorManager floorManager, final Position position);

    /**
     * This method generate a Light Spell, which is a Spell.
     * @return the chest item "Light Spell".
     */
    ChestItem generateLightSpell(FloorManager floorManager, final Position position);

    /**
     * This method generate a Regeneration Spell, which is a Spell.
     * @return the chest item "Regeneration Spell".
     */
    ChestItem generateRegenerationSpell(FloorManager floorManager, final Position position);

    /**
     * This method generate a Shield Spell, which is a Spell.
     * @return the chest item "Shield Spell".
     */
    ChestItem generateShieldSpell(FloorManager floorManager, final Position position);

    /**
     * This method generate a Teleport Spell, which is a Spell.
     * @return the chest item "Teleport Spell".
     */
    ChestItem generateTeleportSpell(FloorManager floorManager, final Position position);

    /**
     * This method generate a Ceiling Trap, which is a Trap.
     * @return the chest item "Ceiling Trap".
     */
    ChestItem generateCeilingTrap(FloorManager floorManager, final Position position);

    /**
     * This method generate an Explosion, which is a Trap.
     * @return the chest item "Explosion".
     */
    ChestItem generateExplosion(FloorManager floorManager, final Position position);

    /**
     * This method generate a Pit, which is a Trap.
     * @return the chest item "Pit".
     */
    ChestItem generatePit(FloorManager floorManager, final Position position);

    /**
     * This method generate a Teleport, which is a Trap.
     * @return the chest item "Teleport".
     */
    ChestItem generateTeleport(FloorManager floorManager, final Position position);

    /**
     * This method generate a Beacon, which is an Utility.
     * @return the chest item "Beacon".
     */
    ChestItem generateBeacon(FloorManager floorManager, final Position position);

    /**
     * This method generate an Enchanted Weapon, which is an Utility.
     * @return the chest item "Enchanted Weapon".
     */
    ChestItem generateEnchantedWeapon(FloorManager floorManager, final Position position);

    /**
     * This method generate a Healing Potion, which is an Utility.
     * @return the chest item "Healing Potion".
     */
    ChestItem generateHealingPotion(FloorManager floorManager, final Position position);

    /**
     * This method generate a Map, which is an Utility.
     * @return the chest item "Map".
     */
    ChestItem generateMap(FloorManager floorManager, final Position position);

    /**
     * This method generate a Magic Sack, which is an Utility.
     * @return the chest item "Magic Sack".
     */
    ChestItem generateMagicSack(FloorManager floorManager, final Position position);

}
