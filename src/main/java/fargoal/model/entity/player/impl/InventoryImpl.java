package fargoal.model.entity.player.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fargoal.model.entity.player.api.Inventory;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.SpellType;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Beacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.EnchantedWeapon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.HealingPotion;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.MagicSack;
import fargoal.model.manager.api.FloorManager;

/**
 * Implementation of the {@link Inventory} interface that manages the player's inventory.
 * This class handles various types of items, such as healing potions, spell scrolls, beacons and
 * magical artifacts, allowing the player to store, add and remove them as needed.
 */
public class InventoryImpl implements Inventory {

    private HealingPotion healingPotions;
    private Beacon beacons;
    private MagicSack magicSacks;
    private EnchantedWeapon enchantedWeapons;
    private fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Map levelMaps;

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
        this.healingPotions = new HealingPotion(floorManager);
        this.beacons = new Beacon(floorManager);
        this.magicSacks = new MagicSack(floorManager);
        this.enchantedWeapons = new EnchantedWeapon(floorManager);
        this.levelMaps = new fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Map(floorManager);
        this.invisibilityScroll = new InvisibilitySpell(floorManager);
        this.teleportScroll = new TeleportSpell(floorManager);
        this.shieldScroll = new ShieldSpell(floorManager);
        this.regenerationScroll = new RegenerationSpell(floorManager);
        this.driftScroll = new DriftSpell(floorManager);
        this.lightScroll = new LightSpell(floorManager);
        this.SpellCasted = new HashMap<>();
        this.SpellCasted.put(SpellType.DRIFT.getName(), false);
        this.SpellCasted.put(SpellType.INVISIBILITY.getName(), false);
        this.SpellCasted.put(SpellType.LIGHT.getName(), false);
        this.SpellCasted.put(SpellType.REGENERATION.getName(), false);
        this.SpellCasted.put(SpellType.SHIELD.getName(), false);
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
    public MagicSack getMagicSacks() {
        return this.magicSacks;
    }

    /** {@inheritDoc} */
    @Override
    public EnchantedWeapon getEnchantedWeapons() {
        return this.enchantedWeapons;
    }

    /** {@inheritDoc} */
    @Override
    public fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Map getListOfMaps() {
        return this.levelMaps;
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Boolean> getSpellCasted() {
        return this.SpellCasted;
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

    @Override
    public List<Spell> getListAllSpell() {
        List<Spell> list = new ArrayList<>();
        list.add(this.driftScroll);
        list.add(invisibilityScroll);
        list.add(lightScroll);
        list.add(regenerationScroll);
        list.add(shieldScroll);
        list.add(teleportScroll);
        return list;
    }
    
}