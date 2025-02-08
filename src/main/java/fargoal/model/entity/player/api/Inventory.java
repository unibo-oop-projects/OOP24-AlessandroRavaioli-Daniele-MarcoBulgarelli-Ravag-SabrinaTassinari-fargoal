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
    Integer getHealingPotions();

    /**
     * Retrieves the number of invisibility scrolls available in the inventory.
     *  
     * @return the number of invisibility scrolls.
     */
    Integer getInvisibilityScrolls();

    /**
     * Retrieves the number of teleportation scrolls available in the inventory.
     *  
     * @return the number of teleportation scrolls.
     */
    Integer getTeleportScrolls();

    /**
     * Retrieves the number of shield scrolls available in the inventory.
     *  
     * @return the number of shield scrolls.
     */
    Integer getShieldScrolls();

    /**
     * Retrieves the number of drift scrolls available in the inventory.
     *  
     * @return the number of drift scrolls.
     */
    Integer getDriftScrolls();

    /**
     * Retrieves the number of light scrolls available in the inventory.
     *  
     * @return the number of light scrolls.
     */
    Integer getLightScrolls();

    /**
     * Retrieves the number of regeneration scrolls available in the inventory.
     *  
     * @return the number of regeneration scrolls.
     */
    Integer getRegenerationScrolls();

    /**
     * Retrieves the number of beacons available in the inventory.
     *  
     * @return the number of beacons.
     */
    Integer getBeacons();

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
     * Adds a healing potion to the player's inventory.
     * 
     * @param h - The healing potion to be added, must not be null.
     */
    void addHealingPotion(HealingPotion h);

    /**
     * Removes a healing potion from the player's inventory.
     * 
     * 
     * @throws IllegalStateException if there are no healing potions in the inventory.
    */
    public void removeHealingPotion();

    /**
     * Adds an invisibility scroll to the player's inventory.
     * 
     * @param scroll - The invisibility scroll to be added, must not be null.
     */
    public void addInvisibilityScroll(InvisibilitySpell scroll);

    /**
     * Removes an invisibility scroll from the player's inventory.
     * 
     * @throws IllegalStateException if there are no invisibility scrolls in the inventory.
    */
    public void removeInvisibilityScroll();

    /**
     * Adds a teleportation scroll to the player's inventory.
     * 
     * @param scroll - The teleportation scroll to be added, must not be null.
     */
    public void addTeleportScroll(TeleportSpell scroll);

    /**
     * Removes a teleportation scroll from the player's inventory.
     * 
     * @throws IllegalStateException if there are no teleportation scrolls in the inventory.
    */
    public void removeTeleportScroll();

    /**
     * Adds a shield scroll to the player's inventory.
     * 
     * @param scroll - The shield scroll to be added, must not be null.
     */
    public void addShieldScroll(ShieldSpell scroll);

    /**
     * Removes a shield scroll from the player's inventory.
     * 
     * @throws IllegalStateException if there are no shield scrolls in the inventory.
    */
    public void removeShieldScroll();

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

    /**
     * Adds a beacon to the player's inventory.
     * 
     * @param b - The beacon to be added, must not be null.
     */
    public void addBeacon(Beacon b);

    /**
     * Removes a beacon from the player's inventory.
     * 
     * @throws IllegalStateException if there are no beacons in the inventory.
    */
    public void removeBeacon();

    /**
     * Adds a drift scroll to the player's inventory.
     * 
     * @param scroll - The drift scroll to be added, must not be null.
     */
    public void addDriftScroll(DriftSpell scroll);

    /**
     * Removes a drift scroll from the player's inventory.
     * 
     * @throws IllegalStateException if there are no drift scrolls in the inventory.
    */
    public void removeDriftScroll();

    /**
     * Adds a light scroll to the player's inventory.
     * 
     * @param scroll - The light scroll to be added, must not be null.
     */
    public void addLightScroll(LightSpell scroll);

    /**
     * Removes a light scroll from the player's inventory.
     * 
     * @throws IllegalStateException if there are no light scrolls in the inventory.
    */
    public void removeLightScroll();

    /**
     * Adds a regeneration scroll to the player's inventory.
     * 
     * @param scroll - The regeneration scroll to be added, must not be null.
     */
    public void addRegenerationScroll(RegenerationSpell scroll);

    /**
     * Removes a regeneration scroll from the player's inventory.
     * 
     * @throws IllegalStateException if there are no regeneration scrolls in the inventory.
    */
    public void removeRegenerationScroll();
}
