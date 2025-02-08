package fargoal.model.entity.player.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fargoal.model.entity.player.api.Inventory;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.SpellType;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.Beacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.HealingPotion;

/**
 * Implementation of the {@link Inventory} interface that manages the player's inventory.
 * This class handles various types of items, such as healing potions, spell scrolls, beacons and
 * magical artifacts, allowing the player to store, add and remove them as needed.
 */
public class InventoryImpl implements Inventory {

    private List<HealingPotion> healingPotions;
    private List<Beacon> beacons;
    private Integer magicSacks;
    private Integer enchantedWeapons;
    private final List<Integer> listOfMaps;

    private List<InvisibilitySpell> invisibilityScrolls;
    private List<TeleportSpell> teleportScrolls;
    private List<ShieldSpell> shieldScrolls;
    private List<RegenerationSpell> regenerationScrolls;
    private List<DriftSpell> driftScrolls;
    private List<LightSpell> lightScrolls;

    private final Map<String, Boolean> SpellCasted;

    /**
     * Initializes a new instance of the {@code InventoryImpl} class.
     * All item quantities are set to their default values.
     * <p>
     * The inventory includes various item categories, such as:
     * </p>
     * <ul>
     *  <li><b>Consumables</b>: healing potions, beacons.</li>
     *  <li><b>Magical artifacts</b>: enchanted weapons, magic sacks.</li>
     *  <li><b>Spells</b>: various spell scrolls (invisibility, teleportation, shield, regeneration, drift, light).</li>
     *  <li><b>Exploration maps</b>: a list of discovered dungeon maps.</li>
     * </ul>
     * <p>
     * A map is used to track the active state of spells, initially setting them as inactive.
     * </p>
     */
    public InventoryImpl() {
        this.healingPotions = new LinkedList<>(List.of(new HealingPotion(), new HealingPotion(), new HealingPotion()));
        this.beacons = new LinkedList<>();
        this.magicSacks = 0;
        this.enchantedWeapons = 0;
        this.listOfMaps = new ArrayList<>();
        this.invisibilityScrolls = new LinkedList<>();
        this.teleportScrolls = new LinkedList<>();
        this.shieldScrolls = new LinkedList<>();
        this.regenerationScrolls = new LinkedList<>();
        this.driftScrolls = new LinkedList<>();
        this.lightScrolls = new LinkedList<>();
        this.SpellCasted = Map.of(SpellType.DRIFT.getName(), false, SpellType.INVISIBILITY.getName(), false, 
            SpellType.LIGHT.getName(), false, SpellType.REGENERATION.getName(), false, 
            SpellType.SHIELD.getName(), false);
    }

    /**{@inheritDoc} */
    @Override
    public Integer getHealingPotions() {
        return this.healingPotions.size();
    }

    /**{@inheritDoc} */
    @Override
    public Integer getBeacons() {
        return this.beacons.size();
    }

    /**{@inheritDoc} */
    @Override
    public Integer getMagicSacks() {
        return this.magicSacks;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getEnchantedWeapons() {
        return this.enchantedWeapons;
    }

    /**{@inheritDoc} */
    @Override
    public List<Integer> getListOfMaps() {
        return this.listOfMaps;
    }
    
    /**{@inheritDoc} */
    @Override
    public Integer getInvisibilityScrolls() {
        return this.invisibilityScrolls.size();
    }

    /**{@inheritDoc} */
    @Override
    public Integer getTeleportScrolls() {
        return this.teleportScrolls.size();
    }

    /**{@inheritDoc} */
    @Override
    public Integer getShieldScrolls() {
        return shieldScrolls.size();
    }

    /**{@inheritDoc} */
    @Override
    public Integer getRegenerationScrolls() {
        return this.regenerationScrolls.size();
    }

    /**{@inheritDoc} */
    @Override
    public Integer getDriftScrolls() {
        return this.driftScrolls.size();
    }

    /**{@inheritDoc} */
    @Override
    public Integer getLightScrolls() {
        return this.lightScrolls.size();
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Boolean> getSpellCasted() {
        return this.SpellCasted;
    }

    /**{@inheritDoc} */
    @Override
    public void addHealingPotion(HealingPotion h) {
        Objects.requireNonNull(h);
        this.healingPotions.add(h);
    }

    /**{@inheritDoc} */
    @Override
    public void removeHealingPotion() {
        if(this.getHealingPotions() > 0) {
            this.healingPotions.removeFirst();
        } else {
            throw new IllegalStateException("Not enough healing potions.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addBeacon(Beacon b) {
        Objects.requireNonNull(b);
        this.beacons.add(b); 
    }

    /**{@inheritDoc} */
    @Override
    public void removeBeacon() {
        if(this.getBeacons() > 0) {
            this.beacons.removeFirst();
        } else {
            throw new IllegalStateException("Not enough beacons.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addMagicSack() {
        this.magicSacks ++;
    }

    /**{@inheritDoc} */
    @Override
    public void addEnchantedWeapon() {
        this.enchantedWeapons ++;
    }

    /**{@inheritDoc} */
    @Override
    public void addFloorMap(Integer floorNumber) {
        if(floorNumber == null || floorNumber <= 0) {
            throw new IllegalArgumentException("Floor number cannot be a negative, null or 0 value.");
        }
        if(!this.listOfMaps.contains(floorNumber)) {
            this.listOfMaps.add(floorNumber);
        }   
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeFloorMap(Integer floorNumber) {
        if(floorNumber == null || floorNumber <= 0) {
            throw new IllegalArgumentException("Floor number cannot be a negative, null or 0 value.");
        }
        if(this.listOfMaps.contains(floorNumber)){
            this.listOfMaps.remove(floorNumber); 
            return true;
        } else {
            return false;
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addInvisibilityScroll(InvisibilitySpell scroll) {
        Objects.requireNonNull(scroll);
        this.invisibilityScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeInvisibilityScroll() {
        if(this.getInvisibilityScrolls() > 0) {
            this.beacons.removeFirst();
        } else {
            throw new IllegalStateException("Not enough invisibility scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addTeleportScroll(TeleportSpell scroll) {
        Objects.requireNonNull(scroll);
        this.teleportScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeTeleportScroll() {
        if(this.getTeleportScrolls() > 0) {
            this.beacons.removeFirst();
        } else {
            throw new IllegalStateException("Not enough teleport scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addShieldScroll(ShieldSpell scroll) {
        Objects.requireNonNull(scroll);
        this.shieldScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeShieldScroll() {
        if(this.getShieldScrolls() > 0) {
            this.shieldScrolls.removeFirst();
        } else {
            throw new IllegalStateException("Not enough shield scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addRegenerationScroll(RegenerationSpell scroll) {
        Objects.requireNonNull(scroll);
        this.regenerationScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeRegenerationScroll() {
        if(this.getRegenerationScrolls() > 0) {
            this.regenerationScrolls.removeFirst();
        } else {
            throw new IllegalStateException("Not enough regeneration scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addDriftScroll(DriftSpell scroll) {
        Objects.requireNonNull(scroll);
        this.driftScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeDriftScroll() {
        if(this.getDriftScrolls() > 0) {
            this.driftScrolls.removeFirst();
        } else {
            throw new IllegalStateException("Not enough drift scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addLightScroll(LightSpell scroll) {
        Objects.requireNonNull(scroll);
        this.lightScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeLightScroll() {
        if(this.getLightScrolls() > 0) {
            this.lightScrolls.removeFirst();
        } else {
            throw new IllegalStateException("Not enough light scrolls.");
        }
    }
}