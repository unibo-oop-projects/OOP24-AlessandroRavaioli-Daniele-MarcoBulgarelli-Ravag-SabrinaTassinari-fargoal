package fargoal.model.interactable.pickUpAble.insideChest.api;

import fargoal.model.manager.api.FloorManager;

/**
 * The interface of the factory of the chest item.
 */
public interface ChestItemFactory {
    
    /**
     * This method generate a Drift Spell, which is a Spell.
     * @param floorManager - it contains all the element of the floor. 
     * @return the chest item "Drift Spell".
     */
    ChestItem generateDriftSpell(FloorManager floorManager);

    /**
     * This method generate an Invisibility Spell, which is a Spell.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Invisibility Spell".
     */
    ChestItem generateInvisibilitySpell(FloorManager floorManager);

    /**
     * This method generate a Light Spell, which is a Spell.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Light Spell".
     */
    ChestItem generateLightSpell(FloorManager floorManager);

    /**
     * This method generate a Regeneration Spell, which is a Spell.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Regeneration Spell".
     */
    ChestItem generateRegenerationSpell(FloorManager floorManager);

    /**
     * This method generate a Shield Spell, which is a Spell.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Shield Spell".
     */
    ChestItem generateShieldSpell(FloorManager floorManager);

    /**
     * This method generate a Teleport Spell, which is a Spell.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Teleport Spell".
     */
    ChestItem generateTeleportSpell(FloorManager floorManager);

    /**
     * This method generate a Ceiling Trap, which is a Trap.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Ceiling Trap".
     */
    ChestItem generateCeilingTrap(FloorManager floorManager);

    /**
     * This method generate an Explosion, which is a Trap.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Explosion".
     */
    ChestItem generateExplosion(FloorManager floorManager);

    /**
     * This method generate a Pit, which is a Trap.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Pit".
     */
    ChestItem generatePit(FloorManager floorManager);

    /**
     * This method generate a Teleport, which is a Trap.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Teleport".
     */
    ChestItem generateTeleport(FloorManager floorManager);

    /**
     * This method generate a Beacon, which is an Utility.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Beacon".
     */
    ChestItem generateBeacon(FloorManager floorManager);

    /**
     * This method generate an Enchanted Weapon, which is an Utility.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Enchanted Weapon".
     */
    ChestItem generateEnchantedWeapon(FloorManager floorManager);

    /**
     * This method generate a Healing Potion, which is an Utility.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Healing Potion".
     */
    ChestItem generateHealingPotion(FloorManager floorManager);

    /**
     * This method generate a Map, which is an Utility.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Map".
     */
    ChestItem generateMap(FloorManager floorManager);

    /**
     * This method generate a Magic Sack, which is an Utility.
     * @param floorManager - it contains all the element of the floor.
     * @return the chest item "Magic Sack".
     */
    ChestItem generateMagicSack(FloorManager floorManager);

}
