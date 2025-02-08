package fargoal.model.entity.player.api;

import java.util.List;
import java.util.Map;

import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.Beacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.HealingPotion;

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
     * Retrieves the number of healing potions available in the inventory.
     *  
     * @return the number of healing potions.
     */
    HealingPotion getHealingPotions();

    /**
     * Retrieves the number of beacons available in the inventory.
     *  
     * @return the number of beacons.
     */
    Beacon getBeacons();

    /**
     * Retrieves the number of magic sacks available in the inventory.
     *  
     * @return the number of magic sacks.
     */
    Integer getMagicSacks();

    /**
     * Retrieves the number of enchanted weapons available in the inventory.
     *  
     * @return the number of enchanted weapons.
     */
    Integer getEnchantedWeapons();

    /**
     * Retrieves the list of floor maps collected by the player.
     *  
     * @return a list of integers representing the floor numbers of the collected maps.
     */
    List<Integer> getListOfMaps();

    /**
     * Retrieves the current status of casted spells.
     * 
     * @return a map where the keys are spell names and the values indicate whether the spell is currently active (true) or not (false).
     */
    Map<String, Boolean> getSpellCasted();


    /**
     * Adds a magic sack to the player's inventory.
     */
    void addMagicSack();

    /**
     * Adds an enchanted weapon to the player's inventory.
     */
    void addEnchantedWeapon();

    /**
     * Adds floor map to player's inventory.
     * 
     * @param floorNumber - The number of the floor map to be added.
     * 
     * @throws IllegalArgumentException if the floor number is null, negative or zero.
     */
    void addFloorMap(Integer floorNumber);

    /**
     * Removes a floor map from the player's inventory.
     * 
     * @param floorNumber - the number of the floor map to be removed.
     * 
     * @return {@code true} if the floor map was successfully removed, {@code false} if the floor map was not found in the inventory.
     * 
     * @throws IllegalArgumentExceptin if the floor number is null, negative or zero.
     */
    boolean removeFloorMap(Integer floorNumber);

    InvisibilitySpell getInvisibilitySpell();

    TeleportSpell getTeleportSpell();

    ShieldSpell getShieldSpell();

    RegenerationSpell getRegenerationSpell();

    DriftSpell getDriftSpell();

    LightSpell getLightSpell();
}
