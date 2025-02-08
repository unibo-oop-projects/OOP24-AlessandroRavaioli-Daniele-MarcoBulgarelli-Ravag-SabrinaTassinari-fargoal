package fargoal.model.interactable.pickUpAble.insideChest.Utility;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.interactable.pickUpAble.insideChest.api.ItemsForInventory;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a map, which the player can found in a chest.
 * The map reveal a determined floor (between first floor and twenth floor) and when the player 
 * goes in that specific floor he knows all the element in it.
 */
public class Map implements ItemsForInventory {

    final int mapLevel;

    /**
     * This is the constructor of the class. It store right away the map and it set the level it reveal.
     * @param floorManager - it contains all the element of the floor.
     * @param position - this is the position of the chest the map was found in.
     */
    public Map(FloorManager floorManager) {
        this.store(floorManager);
        this.mapLevel = this.getMapLevel();
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
        floorManager.getPlayer().getInventory().addFloorMap(this.mapLevel);
    }
    
}
