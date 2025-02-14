package fargoal.model.entity.player.api;

import java.util.List;
import java.util.Map;

import fargoal.model.interactable.pickupable.inside_chest.spell.api.Spell;

/**
 * Represents the player's inventory, managing various items, spells and resources.
 * <p>
 * Implementing classes should provide mechanisms to track and modify 
 * the player's inventory dynamically during gameplay.
 * </p>
 */
public interface Inventory {

    Integer numberHealingPotions();

    void useHealingPotion();

    void removeHealingPotion();

    void addHealingPotion();

    Integer numberBeacons();

    void useBeacon();

    void removeBeacon();

    void addBeacon();

    Integer numberMagicSacks();

    void addMagicSack();

    Integer numberEnchantedWeapons();

    void addEnchantedWeapon();

    /**
     * Retrieves the list of floor maps collected by the player.
     *
     * @return a {@link List} of {@link Integer} representing the floor numbers of the collected maps.
     */
    fargoal.model.interactable.pickupable.inside_chest.utility.impl.Map getListOfMaps();

    /**
     * Retrieves the current status of casted spells.
     * 
     * @return a {@link Map} where the {@code keys} are spell names and the {@code values} indicate
     * whether the spell is currently active (true) or not (false).
     */
    Map<String, Boolean> getSpellCasted();


    Integer numberInvisibilitySpells();

    void addInvisibilitySpell();

    void removeInvisibilitySpell();

    void useInvisibilitySpell();

    Integer numberTeleportSpells();

    void addTeleportSpell();

    void removeTeleportSpell();

    void useTeleportSpell();

    Integer numberShieldSpells();

    void addShieldSpell();

    void removeShieldSpell();

    void useShieldSpell();

    Integer numberRegenerationSpell();

    void addRegenerationSpell();

    void removeRegenerationSpell();

    void useRegenerationSpell();

    Integer numberDriftSpells();

    void addDriftSpell();

    void removeDriftSpell();

    void useDriftSpell();

    Integer numberLightSpells();

    void addLightSpell();

    void removeLightSpell();

    void useLightSpell();

    void turnLight();

    /**
     * This method returns a {@link List} of all types of spells in the inventory.
     * 
     * @return a {@link List} of spells.
     */
    List<Spell> getListAllSpell();

    /**
     * This method returns if the {@link Player} has some spells
     * in the inventory or not.
     * 
     * @return {@code true} if the {@link Player} has spells in {@link Inventory}, {@code false} otherwise.
     */
    boolean areThereSpells();
}
