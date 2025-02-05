package fargoal.model.entity.player.impl;

import java.util.ArrayList;
import java.util.List;

import fargoal.model.entity.player.api.Inventory;

/**
 * Inventory class, it manages player's inventory
 */

public class InventoryImpl implements Inventory {

    private Integer healingPotions;
    private Integer invisibilityScrolls;
    private Integer teleportScrolls;
    private Integer shieldScrolls;
    private Integer driftScrolls;
    private Integer lightScrolls;
    private Integer regenerationScrolls;
    private Integer beacons;
    private Integer magicSacks;
    private Integer enchantedWeapons;
    private final List<Integer> listOfMaps = new ArrayList<>();

    /**
     * Creates a new instance of Inventory, every number of available
     * items is set to 0.
     */
    public InventoryImpl() {
        this.healingPotions = 0;
        this.invisibilityScrolls = 0;
        this.teleportScrolls = 0;
        this.shieldScrolls = 0;
        this.beacons = 0;
        this.lightScrolls = 0;
        this.driftScrolls = 0;
        this.regenerationScrolls = 0;
        this.magicSacks = 0;
        this.enchantedWeapons = 0;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getHealingPotions() {
         return this.healingPotions;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getInvisibilityScrolls() {
        return this.invisibilityScrolls;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getTeleportScrolls() {
        return this.teleportScrolls;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getShieldScrolls() {
        return this.shieldScrolls;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getBeacons() {
        return this.beacons;
    }

    /**{@inheritDoc} */
    @Override
    public void addBeacon() {
        this.beacons ++;
        
    }

    /**{@inheritDoc} */
    @Override
    public void addHealingPotion() {
        this.healingPotions ++;
        
    }

    /**{@inheritDoc} */
    @Override
    public void addInvisibilityScroll() {
        this.invisibilityScrolls ++;
        
    }

    /**{@inheritDoc} */
    @Override
    public void addShieldScroll() {
        this.shieldScrolls ++;
        
    }

    /**{@inheritDoc} */
    @Override
    public void addTeleportScroll() {
        this.teleportScrolls ++;
        
    }

    /**{@inheritDoc} */
    @Override
    public void removeBeaconScroll() {
        if(this.getBeaconScrolls() > 0)
            this.beaconScrolls --;
    }

    /**{@inheritDoc} */
    @Override
    public void removeHealingPotion() {
        if(this.getHealingPotions() > 0)
            this.healingPotions --;
        
    }

    /**{@inheritDoc} */
    @Override
    public void removeInvisibilityScroll() {
        if(this.getInvisibilityScrolls() > 0)
            this.invisibilityScrolls --;
        
    }

    /**{@inheritDoc} */
    @Override
    public void removeShieldScroll() {
        if(this.getShieldScrolls() > 0)
            this.shieldScrolls --;
        
    }

    /**{@inheritDoc} */
    @Override
    public void removeTeleportScroll() {
        if(this.getTeleportScrolls() > 0)
            this.teleportScrolls --;
        
    }
    
}