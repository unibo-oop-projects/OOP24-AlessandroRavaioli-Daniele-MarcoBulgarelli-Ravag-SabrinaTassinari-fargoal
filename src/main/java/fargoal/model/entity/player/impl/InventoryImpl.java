package fargoal.model.entity.player.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fargoal.model.entity.player.api.Inventory;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.SpellType;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.inChest.Utility.impl.Beacon;
import fargoal.model.interactable.pickUpAble.inChest.Utility.impl.HealingPotion;

/**
 * Inventory class, it manages player's inventory
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
     * Creates a new instance of Inventory, every number of available
     * items is set to 0.
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
        this.healingPotions.add(h);
    }

    /**{@inheritDoc} */
    @Override
    public void removeHealingPotion(HealingPotion h) {
        Objects.requireNonNull(h);
        if(this.getHealingPotions() > 0) {
            this.healingPotions.remove(h);
        } else {
            throw new IllegalStateException("Not enough healing potions.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addBeacon(Beacon b) {
        this.beacons.add(b); 
    }

    /**{@inheritDoc} */
    @Override
    public void removeBeacon(Beacon b) {
        Objects.requireNonNull(b);
        if(this.getBeacons() > 0) {
            this.beacons.remove(b);
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
        this.invisibilityScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeInvisibilityScroll(InvisibilitySpell scroll) {
        Objects.requireNonNull(scroll);
        if(this.getInvisibilityScrolls() > 0) {
            this.beacons.remove(scroll);
        } else {
            throw new IllegalStateException("Not enough invisibility scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addTeleportScroll(TeleportSpell scroll) {
        this.teleportScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeTeleportScroll(TeleportSpell scroll) {
        Objects.requireNonNull(scroll);
        if(this.getTeleportScrolls() > 0) {
            this.beacons.remove(scroll);
        } else {
            throw new IllegalStateException("Not enough teleport scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addShieldScroll(ShieldSpell scroll) {
        this.shieldScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeShieldScroll(ShieldSpell scroll) {
        Objects.requireNonNull(scroll);
        if(this.getShieldScrolls() > 0) {
            this.shieldScrolls.remove(scroll);
        } else {
            throw new IllegalStateException("Not enough shield scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addRegenerationScroll(RegenerationSpell scroll) {
        this.regenerationScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeRegenerationScroll(RegenerationSpell scroll) {
        Objects.requireNonNull(scroll);
        if(this.getRegenerationScrolls() > 0) {
            this.regenerationScrolls.remove(scroll);
        } else {
            throw new IllegalStateException("Not enough regeneration scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addDriftScroll(DriftSpell scroll) {
        this.driftScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removeDriftScroll(DriftSpell scroll) {
        Objects.requireNonNull(scroll);
        if(this.getDriftScrolls() > 0) {
            this.driftScrolls.remove(scroll);
        } else {
            throw new IllegalStateException("Not enough drift scrolls.");
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addLightScroll(LightSpell scroll) {
        this.lightScrolls.add(scroll);  
    }

    /**{@inheritDoc} */
    @Override
    public void removelightScroll(LightSpell scroll) {
        Objects.requireNonNull(scroll);
        if(this.getLightScrolls() > 0) {
            this.lightScrolls.remove(scroll);
        } else {
            throw new IllegalStateException("Not enough light scrolls.");
        }
    }
}