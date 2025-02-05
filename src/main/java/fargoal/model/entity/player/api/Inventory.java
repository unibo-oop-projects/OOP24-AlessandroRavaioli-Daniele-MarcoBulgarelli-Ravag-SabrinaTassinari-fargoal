package fargoal.model.entity.player.api;

import java.util.List;

/**
 * Interface to manage player's items.
 */

public interface Inventory {
    /**
     * Getter for the current number of available healing potions.
     *  
     * @return current number of available healing potions.
     */
    Integer getHealingPotions();

    /**
     * Getter for the current number of available invisibility scrolls.
     * 
     * @return current number of available invisibility scrolls.
     */
    Integer getInvisibilityScrolls();

    /**
     * Getter for the current number of available teleport scrolls.
     * 
     * @return current number of available teleport scrolls.
     */
    Integer getTeleportScrolls();

    /**
     * Getter for the current number of available shield scrolls.
     * 
     * @return current number of available shield scrolls.
     */
    Integer getShieldScrolls();

    /**
     * Getter for the current number of available drift scrolls.
     * 
     * @return current number of available drift scrolls.
     */
    Integer getDriftScrolls();

    /**
     * Getter for the current number of available light scrolls.
     * 
     * @return current number of available light scrolls.
     */
    Integer getLightScrolls();

    /**
     * Getter for the current number of available regeneration scrolls.
     * 
     * @return current number of available regeneration scrolls.
     */
    Integer getRegenerationScrolls();

    /**
     * Getter for the current number of available beacons.
     * 
     * @return current number of available beacons.
     */
    Integer getBeacons();

    /**
     * Getter for the current number of available magic sacks.
     * 
     * @return current number of available magic sacks.
     */
    Integer getMagicSacks();

    /**
     * Getter for the current number of available enchanted weapons.
     * 
     * @return current number of available enchaned weapons.
     */
    Integer getEnchantedWeapons();

    /**
     * Getter for the list containing the array list of maps the player has.
     * 
     * @return the list of floors for which the player has a map.
     */
    List<Integer> getListOfMaps();

    /**
     * Adds a single healing potion to player's inventory.
     */
    void addHealingPotion();

    /**
     * Removes a single healing potion from player's inventory,
     * if it is available.
     */
    void removeHealingPotion();

    /**
     * Adds a single invisibility scroll to player's inventory.
     */
    void addInvisibilityScroll();

    /**
     * Removes a single invisibility scroll from player's inventory,
     * if it is available.
     */
    void removeInvisibilityScroll();

    /**
     * Adds a single teleport scroll to player's inventory.
     */
    void addTeleportScroll();

    /**
     * Removes a single teleport scroll from player's inventory,
     * if it is available.
     */
    void removeTeleportScroll();

    /**
     * Adds a single shield scroll to player's inventory.
     */
    void addShieldScroll();

    /**
     * Removes a single shield scroll from player's inventory,
     * if it is available.
     */
    void removeShieldScroll();

    /**
     * Adds a single magic sack to player's inventory.
     */
    void addMagicSack();

    /**
     * Adds a single enchanted weapon to player's inventory.
     */
    void addEnchantedWeapon();

    /**
     * Adds a map of a single floor to player's inventory.
     * 
     * @param - the floor number that the map is for.
     */
    void addFloorMap(Integer floorNumber);

    /**
     * Removes a map of a single floor from player's inventory.
     * 
     * @param - the floor number that the map is for.
     */
    void removeFloorMap(Integer floorNumber);

    /**
     * Adds a single beacon scroll to player's inventory.
     */
    void addBeacon();

    /**
     * Removes a single beacon scroll from player's inventory,
     * if it is available.
     */
    void removeBeacon();

    /**
     * Adds a single drift scroll to player's inventory.
     */
    void addDriftScroll();

    /**
     * Removes a single beacon scroll from player's inventory,
     * if it is available.
     */
    void removeDriftScroll();

    /**
     * Adds a single light scroll to player's inventory.
     */
    void addLightScroll();

    /**
     * Removes a single light scroll from player's inventory,
     * if it is available.
     */
    void removeLightScroll();

    /**
     * Adds a single regeneration scroll to player's inventory.
     */
    void addRegenerationScroll();

    /**
     * Removes a single regeneration scroll from player's inventory,
     * if it is available.
     */
    void removeRegenerationScroll();
}
