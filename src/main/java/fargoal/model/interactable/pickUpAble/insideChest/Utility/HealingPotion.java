package fargoal.model.interactable.pickUpAble.insideChest.Utility;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.interactable.pickUpAble.insideChest.api.ItemsForInventory;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements an Healing Potion, which the player found in a chest.
 * It heal the player, incresing his health.
 */
public class HealingPotion implements ItemsForInventory {

    /**
     * This is the constructor of the class. It store right away the item the player found in a chest.
     * @param floorManager - it contains all the element of the floor the item is.
     * @param position - this is the position of the chest the item was found.
     */
    public HealingPotion(FloorManager floorManager) {
        this.store(floorManager);
    }

    public HealingPotion() {
    } 

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.HEALING_POTION.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
        int healthToAdd = new Random().nextInt(19) + 3 * floorManager.getPlayer().getLevel();
        floorManager.getPlayer().getHealth().setHealth(floorManager.getPlayer().getHealth().getCurrentHealth() + healthToAdd);
        floorManager.getPlayer().getInventory().removeHealingPotion();
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addHealingPotion(this);
    }
    
}
