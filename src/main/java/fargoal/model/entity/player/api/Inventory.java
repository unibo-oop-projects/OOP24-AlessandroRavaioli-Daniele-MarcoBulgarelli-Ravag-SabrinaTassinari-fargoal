package fargoal.model.entity.player.api;

import java.util.List;
import java.util.Map;

import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Beacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.EnchantedWeapon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.HealingPotion;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.MagicSack;

/**
 * Represents the player's inventory, managing various items, spells and resources.
 * This interface provides methods to add, remove, and retrieve different types of items.
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
     * @return the HealingPotion Object
     */
    HealingPotion getHealingPotions();

    /**
     * Retrieves the Beacon Object on which the methods 
     * inherent in that utility can be called.
     *  
     * @return the Beacon Object
     */
    Beacon getBeacons();

    /**
     * Retrieves the MagicSack Object on which the methods 
     * inherent in that utility can be called.
     *  
     * @return the MagicSack Object
     */
    MagicSack getMagicSacks();

    /**
     * Retrieves the EnchantedWeapon Object on which the methods 
     * inherent in that utility can be called.
     *  
     * @return the EnchantedWeapon Object
     */
    EnchantedWeapon getEnchantedWeapons();

    /**
     * Retrieves the list of floor maps collected by the player.
     *  
     * @return a list of integers representing the floor numbers of the collected maps.
     */
    fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Map getListOfMaps();

    /**
     * Retrieves the current status of casted spells.
     * 
     * @return a map where the keys are spell names and the values indicate whether the spell is currently active (true) or not (false).
     */
    Map<String, Boolean> getSpellCasted();

    /**
     * Retrieves the InvisibilitySpell Object on which the methods 
     * inherent in that spell can be called.
     *  
     * @return the InvisibilitySpell Object
     */
    InvisibilitySpell getInvisibilitySpell();

    /**
     * Retrieves the TeleportSpell Object on which the methods 
     * inherent in that spell can be called.
     *  
     * @return the TeleportSpell Object
     */
    TeleportSpell getTeleportSpell();

    /**
     * Retrieves the ShieldSpell Object on which the methods 
     * inherent in that spell can be called.
     *  
     * @return the ShieldSpell Object
     */
    ShieldSpell getShieldSpell();

    /**
     * Retrieves the RegenerationSpell Object on which the methods 
     * inherent in that spell can be called.
     *  
     * @return the RegenerationSpell Object
     */
    RegenerationSpell getRegenerationSpell();

    /**
     * Retrieves the DriftSpell Object on which the methods 
     * inherent in that spell can be called.
     *  
     * @return the DriftSpell Object
     */
    DriftSpell getDriftSpell();

    /**
     * Retrieves the LightSpell Object on which the methods 
     * inherent in that spell can be called.
     *  
     * @return the LightSpell Object
     */
    LightSpell getLightSpell();

    /**
     * This method return a list of all types of spell in the inventory
     * @return a list of spell.
     */
    List<Spell> getListAllSpell();
}
