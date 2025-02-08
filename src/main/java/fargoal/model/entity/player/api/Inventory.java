package fargoal.model.entity.player.api;

import java.util.List;
import java.util.Map;

import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Beacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.HealingPotion;

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
     * Getter for the map which indicates which spells' effects are happening in this momenti.
     * @return the map that indicates which spells' effects are happening in this moment. 
     */
    Map<String, Boolean> getSpellCasted();

    /**
     * Adds a single healing potion to player's inventory.
     */
    void addHealingPotion(HealingPotion h);

    /**
     * Removes a single healing potion from player's inventory,
     * if it is available.
    */
    public void removeHealingPotion(HealingPotion h);

    /**
     * Adds a single invisibility scroll to player's inventory.
     */
    public void addInvisibilityScroll(InvisibilitySpell scroll);

    /**
     * Removes a single invisibility scroll from player's inventory,
     * if it is available.
     * 
     * @return true if the item can be removed, false otherwise.
     */
    public void removeInvisibilityScroll(InvisibilitySpell scroll);

    /**
     * Adds a single teleport scroll to player's inventory.
     */
    public void addTeleportScroll(TeleportSpell scroll);

    /**
     * Removes a single teleport scroll from player's inventory,
     * if it is available.
     * 
     * @return true if the item can be removed, false otherwise.
     */
    public void removeTeleportScroll(TeleportSpell scroll);

    /**
     * Adds a single shield scroll to player's inventory.
     */
    public void addShieldScroll(ShieldSpell scroll);

    /**
     * Removes a single shield scroll from player's inventory,
     * if it is available.
     * 
     * @return true if the item can be removed, false otherwise.
     */
    public void removeShieldScroll(ShieldSpell scroll);

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
     * 
     * @return true if the item can be removed, false otherwise.
     */
    boolean removeFloorMap(Integer floorNumber);

    /**
     * Adds a single beacon scroll to player's inventory.
     */
    public void addBeacon(Beacon b);

    /**
     * Removes a single beacon scroll from player's inventory,
     * if it is available.
     * 
     * @return true if the item can be removed, false otherwise.
     */
    public void removeBeacon(Beacon b);

    /**
     * Adds a single drift scroll to player's inventory.
     */
    public void addDriftScroll(DriftSpell scroll);

    /**
     * Removes a single beacon scroll from player's inventory,
     * if it is available.
     * 
     * @return true if the item can be removed, false otherwise.
     */
    public void removeDriftScroll(DriftSpell scroll);

    /**
     * Adds a single light scroll to player's inventory.
     */
    public void addLightScroll(LightSpell scroll);

    /**
     * Removes a single light scroll from player's inventory,
     * if it is available.
     * 
     * @return true if the item can be removed, false otherwise.
     */
    public void removelightScroll(LightSpell scroll);

    /**
     * Adds a single regeneration scroll to player's inventory.
     */
    public void addRegenerationScroll(RegenerationSpell scroll);

    /**
     * Removes a single regeneration scroll from player's inventory,
     * if it is available.
     * 
     * @return true if the item can be removed, false otherwise.
     */
    public void removeRegenerationScroll(RegenerationSpell scroll);
}
