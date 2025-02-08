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
import fargoal.model.manager.api.FloorManager;

/**
 * Implementation of the {@link Inventory} interface that manages the player's inventory.
 * This class handles various types of items, such as healing potions, spell scrolls, beacons and
 * magical artifacts, allowing the player to store, add and remove them as needed.
 */
public class InventoryImpl implements Inventory {

    private FloorManager floorManager;
    private HealingPotion healingPotions;
    private Beacon beacons;
    private Integer magicSacks;
    private Integer enchantedWeapons;
    private final List<Integer> listOfMaps;

    private InvisibilitySpell invisibilityScroll;
    private TeleportSpell teleportScroll;
    private ShieldSpell shieldScroll;
    private RegenerationSpell regenerationScroll;
    private DriftSpell driftScroll;
    private LightSpell lightScroll;

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
    public InventoryImpl(FloorManager floorManager) {
        this.floorManager = floorManager;
        this.healingPotions = new HealingPotion(floorManager);
        this.beacons = new Beacon(floorManager);
        this.magicSacks = 0;
        this.enchantedWeapons = 0;
        this.listOfMaps = new ArrayList<>();
        this.invisibilityScroll = new InvisibilitySpell(floorManager);
        this.teleportScroll = new TeleportSpell(floorManager);
        this.shieldScroll = new ShieldSpell(floorManager);
        this.regenerationScroll = new RegenerationSpell(floorManager);
        this.driftScroll = new DriftSpell(floorManager);
        this.lightScroll = new LightSpell(floorManager);
        this.SpellCasted = Map.of(SpellType.DRIFT.getName(), false, SpellType.INVISIBILITY.getName(), false, 
            SpellType.LIGHT.getName(), false, SpellType.REGENERATION.getName(), false, 
            SpellType.SHIELD.getName(), false);
    }

    /**{@inheritDoc} */
    @Override
    public HealingPotion getHealingPotions() {
        return this.healingPotions;
    }

    /**{@inheritDoc} */
    @Override
    public Beacon getBeacons() {
        return this.beacons;
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

    /** {@inheritDoc} */
    @Override
    public Map<String, Boolean> getSpellCasted() {
        return this.SpellCasted;
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

    @Override
    public InvisibilitySpell getInvisibilitySpell() {
        return this.invisibilityScroll;
    }

    @Override
    public TeleportSpell getTeleportSpell() {
        return this.teleportScroll;
    }

    @Override
    public ShieldSpell getShieldSpell() {
        return this.shieldScroll;
    }

    @Override
    public RegenerationSpell getRegenerationSpell() {
        return this.regenerationScroll;
    }

    @Override
    public DriftSpell getDriftSpell() {
        return this.driftScroll;
    }

    @Override
    public LightSpell getLightSpell() {
        return this.lightScroll;
    }

    
}