package fargoal.model.interactable.pickUpAble.insideChest.Utility.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.UtilityType;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a map, which the player can found in a chest.
 * The map reveal a determined floor (between first floor and twenth floor) and when the player 
 * goes in that specific floor he knows all the element in it.
 */
public class Map implements Utility {

    private List<Integer> listOfMaps;

    /**
     * This is the constructor of the class. It store right away the map and it set the level it reveal.
     * @param floorManager - it contains all the element of the floor.
     * @param position - this is the position of the chest the map was found in.
     */
    public Map(FloorManager floorManager) {
        listOfMaps = new ArrayList<>();
    }

    /**
     * A private method that calculates the map level.
     * @return the level the map reveal.
     */
    private int getMapLevel() {
        return new Random().nextInt(19) + 1;
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.MAP.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        this.addUtility(this.getMapLevel());
    }

    /** {@inheritDoc} */
    @Override
    public int getNumberInInventory() {
        return this.listOfMaps.size();
    }

    /**
     * Getter for the list of the maps the player has.
     * @return the list of the maps.
     */
    public List<Integer> getListOfMaps() {
        return this.listOfMaps;
    }

    /**
     * This method add an utility in the player's inventory.
     */
    private void addUtility(Integer floorNumber) {
        if(floorNumber == null || floorNumber <= 0) {
            throw new IllegalArgumentException("Floor number cannot be a negative, null or 0 value.");
        }
        if(!this.listOfMaps.contains(floorNumber)) {
            this.listOfMaps.add(floorNumber);
        }   
    }

    /** {@inheritDoc} */
    @Override
    public void removeUtility() {
        this.listOfMaps.removeFirst();
    }

    /**
     * This method removes a map of a specific level from the player's inventory.
     * @param floorNumber - it contains all the element of the floor.
     * @return true if the map has been removed, false otherwise.
     */
    public boolean removeMapLevel(Integer floorNumber) {
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
    
}
