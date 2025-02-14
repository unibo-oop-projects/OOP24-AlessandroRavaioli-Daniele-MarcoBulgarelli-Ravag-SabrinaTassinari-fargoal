package fargoal.model.entity.player.api;

import java.util.List;
import java.util.Map;

import fargoal.model.interactable.pickupable.inside_chest.spell.api.Spell;
import fargoal.model.interactable.pickupable.inside_chest.spell.impl.DriftSpell;
import fargoal.model.interactable.pickupable.inside_chest.spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickupable.inside_chest.spell.impl.LightSpell;
import fargoal.model.interactable.pickupable.inside_chest.spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickupable.inside_chest.spell.impl.ShieldSpell;
import fargoal.model.interactable.pickupable.inside_chest.spell.impl.TeleportSpell;
import fargoal.model.interactable.pickupable.inside_chest.utility.impl.Beacon;
import fargoal.model.interactable.pickupable.inside_chest.utility.impl.EnchantedWeapon;
import fargoal.model.interactable.pickupable.inside_chest.utility.impl.HealingPotion;
import fargoal.model.interactable.pickupable.inside_chest.utility.impl.MagicSack;

/**
 * Represents the player's inventory, managing various items, spells and resources.
 * <p>
 * Implementing classes should provide mechanisms to track and modify 
 * the player's inventory dynamically during gameplay.
 * </p>
 */
public interface Inventory {

    /**
     * Retrieves the HealingPotion Object on which the methods 
     * inherent in that utility can be called.
     *
     * @return the {@link HealingPotion} Object
     */
    HealingPotion getHealingPotions();

    /**
     * Retrieves the Beacon Object on which the methods 
     * inherent in that utility can be called.
     *
     * @return the {@link Beacon} Object
     */
    Beacon getBeacons();

    /**
     * Retrieves the MagicSack Object on which the methods 
     * inherent in that utility can be called.
     *
     * @return the {@link MagicSack} Object
     */
    MagicSack getMagicSacks();

    /**
     * Retrieves the EnchantedWeapon Object on which the methods 
     * inherent in that utility can be called.
     *
     * @return the {@link EnchantedWeapon} Object
     */
    EnchantedWeapon getEnchantedWeapons();

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

    /**
     * Retrieves the {@link InvisibilitySpell} Object on which the methods 
     * inherent in that spell can be called.
     *
     * @return the {@link InvisibilitySpell} Object
     */
    InvisibilitySpell getInvisibilitySpell();

    /**
     * Retrieves the {@link TeleportSpell} Object on which the methods 
     * inherent in that spell can be called.
     *
     * @return the {@link TeleportSpell} Object
     */
    TeleportSpell getTeleportSpell();

    /**
     * Retrieves the {@link ShieldSpell} Object on which the methods 
     * inherent in that spell can be called.
     *
     * @return the {@link ShieldSpell} Object
     */
    ShieldSpell getShieldSpell();

    /**
     * Retrieves the {@link RegenerationSpell} Object on which the methods 
     * inherent in that spell can be called.
     *
     * @return the {@link RegenerationSpell} Object
     */
    RegenerationSpell getRegenerationSpell();

    /**
     * Retrieves the {@link DriftSpell} Object on which the methods 
     * inherent in that spell can be called.
     *
     * @return the {@link DriftSpell} Object
     */
    DriftSpell getDriftSpell();

    /**
     * Retrieves the {@link LightSpell} Object on which the methods 
     * inherent in that spell can be called.
     *
     * @return the {@link LightSpell} Object
     */
    LightSpell getLightSpell();

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
