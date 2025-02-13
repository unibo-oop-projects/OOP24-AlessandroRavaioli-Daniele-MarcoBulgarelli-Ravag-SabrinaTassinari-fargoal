package fargoal.model.entity.player.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fargoal.model.entity.player.api.Inventory;
import fargoal.model.interactable.pickupable.inside_chest.spell.api.Spell;
import fargoal.model.interactable.pickupable.inside_chest.spell.api.SpellType;
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
import fargoal.model.manager.api.FloorManager;

/**
 * Implementation of the {@link Inventory} interface that manages the player's inventory.
 * This class handles various types of items, such as healing potions, spell scrolls, beacons and
 * magical artifacts, allowing the player to store, add and remove them as needed.
 */
public class InventoryImpl implements Inventory {

    private final HealingPotion healingPotions;
    private final Beacon beacons;
    private final MagicSack magicSacks;
    private final EnchantedWeapon enchantedWeapons;
    private final fargoal.model.interactable.pickupable.inside_chest.utility.impl.Map levelMaps;

    private final InvisibilitySpell invisibilityScroll;
    private final TeleportSpell teleportScroll;
    private final ShieldSpell shieldScroll;
    private final RegenerationSpell regenerationScroll;
    private final DriftSpell driftScroll;
    private final LightSpell lightScroll;

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
     * 
     * @param floorManager - to get all the infos the method needs
     */
    public InventoryImpl(final FloorManager floorManager) {
        this.healingPotions = new HealingPotion();
        this.beacons = new Beacon();
        this.magicSacks = new MagicSack(floorManager);
        this.enchantedWeapons = new EnchantedWeapon(floorManager);
        this.levelMaps = new fargoal.model.interactable.pickupable.inside_chest.utility.impl.Map();
        this.invisibilityScroll = new InvisibilitySpell();
        this.teleportScroll = new TeleportSpell();
        this.shieldScroll = new ShieldSpell();
        this.regenerationScroll = new RegenerationSpell();
        this.driftScroll = new DriftSpell();
        this.lightScroll = new LightSpell();
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
    public fargoal.model.interactable.pickupable.inside_chest.utility.impl.Map getListOfMaps() {
        return this.levelMaps;
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Boolean> getSpellCasted() {
        return this.SpellCasted;
    }

    /** {@inheritDoc} */
    @Override
    public InvisibilitySpell getInvisibilitySpell() {
        return this.invisibilityScroll;
    }

    /** {@inheritDoc} */
    @Override
    public TeleportSpell getTeleportSpell() {
        return this.teleportScroll;
    }

    /** {@inheritDoc} */
    @Override
    public ShieldSpell getShieldSpell() {
        return this.shieldScroll;
    }

    /** {@inheritDoc} */
    @Override
    public RegenerationSpell getRegenerationSpell() {
        return this.regenerationScroll;
    }

    /** {@inheritDoc} */
    @Override
    public DriftSpell getDriftSpell() {
        return this.driftScroll;
    }

    /** {@inheritDoc} */
    @Override
    public LightSpell getLightSpell() {
        return this.lightScroll;
    }

    /** {@inheritDoc} */
    @Override
    public List<Spell> getListAllSpell() {
        final List<Spell> list = new ArrayList<>();
        list.add(this.driftScroll);
        list.add(invisibilityScroll);
        list.add(lightScroll);
        list.add(regenerationScroll);
        list.add(shieldScroll);
        list.add(teleportScroll);
        return list;
    }
    /** {@inheritDoc} */
    @Override
    public boolean areThereSpells() {
        return this.getInvisibilitySpell().getNumberInInventory() > 0
                || this.getRegenerationSpell().getNumberInInventory() > 0
                || this.getTeleportSpell().getNumberInInventory() > 0
                || this.getShieldSpell().getNumberInInventory() > 0
                || this.getLightSpell().getNumberInInventory() > 0
                || this.getDriftSpell().getNumberInInventory() > 0;
    }
}
