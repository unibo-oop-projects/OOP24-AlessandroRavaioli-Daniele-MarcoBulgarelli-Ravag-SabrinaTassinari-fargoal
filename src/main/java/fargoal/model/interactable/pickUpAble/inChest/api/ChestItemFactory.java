package fargoal.model.interactable.pickUpAble.inChest.api;

/**
 * The interface of the factory of the chest item.
 */
public interface ChestItemFactory {
    
    /**
     * This method generate a Drift Spell, which is a Spell.
     * @return the chest item "Drift Spell".
     */
    public ChestItem generateDriftSpell();

    /**
     * This method generate an Invisibility Spell, which is a Spell.
     * @return the chest item "Invisibility Spell".
     */
    public ChestItem generateInvisibilitySpell();

    /**
     * This method generate a Light Spell, which is a Spell.
     * @return the chest item "Light Spell".
     */
    public ChestItem generateLightSpell();

    /**
     * This method generate a Regeneration Spell, which is a Spell.
     * @return the chest item "Regeneration Spell".
     */
    public ChestItem generateRegenerationSpell();

    /**
     * This method generate a Shield Spell, which is a Spell.
     * @return the chest item "Shield Spell".
     */
    public ChestItem generateShieldSpell();

    /**
     * This method generate a Teleport Spell, which is a Spell.
     * @return the chest item "Teleport Spell".
     */
    public ChestItem generateTeleportSpell();

    /**
     * This method generate a Ceiling Trap, which is a Trap.
     * @return the chest item "Ceiling Trap".
     */
    public ChestItem generateCeilingTrap();

    /**
     * This method generate an Explosion, which is a Trap.
     * @return the chest item "Explosion".
     */
    public ChestItem generateExplosion();

    /**
     * This method generate a Pit, which is a Trap.
     * @return the chest item "Pit".
     */
    public ChestItem generatePit();

    /**
     * This method generate a Teleport, which is a Trap.
     * @return the chest item "Teleport".
     */
    public ChestItem generateTeleport();

    /**
     * This method generate a Beacon, which is an Utility.
     * @return the chest item "Beacon".
     */
    public ChestItem generateBeacon();

    /**
     * This method generate an Enchanted Weapon, which is an Utility.
     * @return the chest item "Enchanted Weapon".
     */
    public ChestItem generateEnchantedWeapon();

    /**
     * This method generate a Healing Potion, which is an Utility.
     * @return the chest item "Healing Potion".
     */
    public ChestItem generateHealingPotion();

    /**
     * This method generate a Map, which is an Utility.
     * @return the chest item "Map".
     */
    public ChestItem generateMap();

    /**
     * This method generate a Magic Sack, which is an Utility.
     * @return the chest item "Magic Sack".
     */
    public ChestItem generateMagicSack();

}
