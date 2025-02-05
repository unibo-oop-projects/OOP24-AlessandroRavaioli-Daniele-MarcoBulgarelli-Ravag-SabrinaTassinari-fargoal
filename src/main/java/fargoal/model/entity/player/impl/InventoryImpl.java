package fargoal.model.entity.player.impl;

import java.util.ArrayList;
import java.util.List;

import fargoal.model.entity.player.api.Inventory;

/**
 * Inventory class, it manages player's inventory
 */

public class InventoryImpl implements Inventory {

    private Integer healingPotions;
    private Integer beacons;
    private Integer magicSacks;
    private Integer enchantedWeapons;
    private final List<Integer> listOfMaps;

    private Integer invisibilityScrolls;
    private Integer teleportScrolls;
    private Integer shieldScrolls;
    private Integer regenerationScrolls;
    private Integer driftScrolls;
    private Integer lightScrolls;


    /**
     * Creates a new instance of Inventory, every number of available
     * items is set to 0.
     */
    public InventoryImpl() {
        this.healingPotions = 0;
        this.beacons = 0;
        this.magicSacks = 0;
        this.enchantedWeapons = 0;
        this.listOfMaps = new ArrayList<>();
        this.invisibilityScrolls = 0;
        this.teleportScrolls = 0;
        this.shieldScrolls = 0;
        this.regenerationScrolls = 0;
        this.driftScrolls = 0;
        this.lightScrolls = 0;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getHealingPotions() {
        return this.healingPotions;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getBeacons() {
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
        return shieldScrolls;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getRegenerationScrolls() {
        return this.regenerationScrolls;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getDriftScrolls() {
        return this.driftScrolls;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getLightScrolls() {
        return this.lightScrolls;
    }

    /**{@inheritDoc} */
    @Override
    public void addHealingPotion() {
        this.healingPotions ++;
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeHealingPotion() {
        if(this.getHealingPotions() > 0) {
            this.healingPotions --;
            return true;
        } else {
            return false;
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addBeacon() {
        this.beacons ++; 
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeBeacon() {
        if(this.getBeacons() > 0){
            this.beacons --;
            return true;
        } else {
            return false;
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
    public void addInvisibilityScroll() {
        this.invisibilityScrolls ++; 
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeInvisibilityScroll() {
        if(this.getInvisibilityScrolls() > 0) {
            this.invisibilityScrolls --;    
            return true;
        } else {
            return false;
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addTeleportScroll() {
        this.teleportScrolls ++;
        
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeTeleportScroll() {
        if(this.getTeleportScrolls() > 0) {
            this.teleportScrolls --;
            return true;
        } else {
            return false;
        }
        
    }

    /**{@inheritDoc} */
    @Override
    public void addShieldScroll() {
        this.shieldScrolls ++;    
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeShieldScroll() {
        if(this.getShieldScrolls() > 0) {
            this.shieldScrolls --;   
            return true;
        } else {
            return false;
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addRegenerationScroll() {
        this.regenerationScrolls ++; 
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeRegenerationScroll() {
        if(this.getRegenerationScrolls() > 0) {
            this.regenerationScrolls --;
            return true;
        } else {
            return false;
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addDriftScroll() {
        this.driftScrolls ++;
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeDriftScroll() {
        if(this.getDriftScrolls() > 0) {
            this.driftScrolls --;
            return true;
        } else {
            return false;
        }
    }

    /**{@inheritDoc} */
    @Override
    public void addLightScroll() {
        this.lightScrolls ++;
    }

    /**{@inheritDoc} */
    @Override
    public boolean removeLightScroll() {
        if(this.getLightScrolls() > 0) {
            this.lightScrolls --;
            return true;
        } else {
            return false;
        }
        
    }
}