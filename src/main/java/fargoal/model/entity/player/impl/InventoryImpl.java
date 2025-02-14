package fargoal.model.entity.player.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
    private final FloorManager floorManager;

    private final Map<String, Boolean> spellCasted;

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
    @SuppressFBWarnings(
        value = {"EI_EXPOSE_REP2"},
        justification = "The class needs to work on the same manager as the one given"
            + "so if the one given changes the reference also needs to change"
    )
    public InventoryImpl(final FloorManager floorManager) {
        this.floorManager = floorManager;
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
        this.spellCasted = new HashMap<>();
        this.spellCasted.put(SpellType.DRIFT.getName(), false);
        this.spellCasted.put(SpellType.INVISIBILITY.getName(), false);
        this.spellCasted.put(SpellType.LIGHT.getName(), false);
        this.spellCasted.put(SpellType.REGENERATION.getName(), false);
        this.spellCasted.put(SpellType.SHIELD.getName(), false);
    }

    /** {@inheritDoc} */
    @Override
    public fargoal.model.interactable.pickupable.inside_chest.utility.impl.Map getListOfMaps() {
        return this.levelMaps;
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Boolean> getSpellCasted() {
        return this.spellCasted;
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
        return this.numberInvisibilitySpells() > 0
                || this.numberRegenerationSpell() > 0
                || this.numberTeleportSpells() > 0
                || this.numberShieldSpells() > 0
                || this.numberLightSpells() > 0
                || this.numberDriftSpells() > 0;
    }

    @Override
    public Integer numberHealingPotions() {
        return this.healingPotions.getNumberInInventory();
    }

    @Override
    public void useHealingPotion() {
        this.healingPotions.use(floorManager);
    }

    @Override
    public void removeHealingPotion() {
        this.healingPotions.removeUtility();
    }

    @Override
    public void addHealingPotion() {
        this.healingPotions.store();
    }

    @Override
    public Integer numberBeacons() {
        return this.beacons.getNumberInInventory();
    }

    @Override
    public void useBeacon() {
        this.beacons.use(floorManager);
    }

    @Override
    public void removeBeacon() {
        this.beacons.removeUtility();
    }

    @Override
    public void addBeacon() {
        this.beacons.store();
    }

    @Override
    public Integer numberMagicSacks() {
        return this.magicSacks.getNumberInInventory();
    }

    @Override
    public void addMagicSack() {
        this.magicSacks.store();
    }

    @Override
    public Integer numberEnchantedWeapons() {
        return this.enchantedWeapons.getNumberInInventory();
    }

    @Override
    public void addEnchantedWeapon() {
        this.enchantedWeapons.store();
    }

    @Override
    public Integer numberInvisibilitySpells() {
        return this.invisibilityScroll.getNumberInInventory();
    }

    @Override
    public void addInvisibilitySpell() {
        this.invisibilityScroll.store();
    }

    @Override
    public void removeInvisibilitySpell() {
        this.invisibilityScroll.removeSpell();
    }

    @Override
    public void useInvisibilitySpell() {
        this.invisibilityScroll.use(floorManager);
    }

    @Override
    public Integer numberTeleportSpells() {
        return this.teleportScroll.getNumberInInventory();
    }

    @Override
    public void addTeleportSpell() {
        this.teleportScroll.store();
    }

    @Override
    public void removeTeleportSpell() {
        this.teleportScroll.removeSpell();
    }

    @Override
    public void useTeleportSpell() {
        this.teleportScroll.use(floorManager);
    }

    @Override
    public Integer numberShieldSpells() {
        return this.shieldScroll.getNumberInInventory();
    }

    @Override
    public void addShieldSpell() {
        this.shieldScroll.store();
    }

    @Override
    public void removeShieldSpell() {
        this.shieldScroll.removeSpell();
    }

    @Override
    public void useShieldSpell() {
        this.shieldScroll.use(floorManager);
    }

    @Override
    public Integer numberRegenerationSpell() {
        return this.regenerationScroll.getNumberInInventory();
    }

    @Override
    public void addRegenerationSpell() {
        this.regenerationScroll.store();
    }

    @Override
    public void removeRegenerationSpell() {
        this.regenerationScroll.removeSpell();
    }

    @Override
    public void useRegenerationSpell() {
        this.regenerationScroll.use(floorManager);
    }

    @Override
    public Integer numberDriftSpells() {
        return this.driftScroll.getNumberInInventory();
    }

    @Override
    public void addDriftSpell() {
        this.driftScroll.store();
    }

    @Override
    public void removeDriftSpell() {
        this.driftScroll.removeSpell();
    }

    @Override
    public void useDriftSpell() {
        this.driftScroll.use(floorManager);
    }

    @Override
    public Integer numberLightSpells() {
        return this.lightScroll.getNumberInInventory();
    }

    @Override
    public void addLightSpell() {
        this.lightScroll.store();
    }

    @Override
    public void removeLightSpell() {
        this.lightScroll.removeSpell();
    }

    @Override
    public void useLightSpell() {
        this.lightScroll.use(floorManager);
    }

    @Override
    public void turnLight() {
        this.lightScroll.turnLight(floorManager);
    }
}
