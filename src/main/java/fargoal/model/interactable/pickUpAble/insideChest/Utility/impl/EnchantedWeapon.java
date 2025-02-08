package fargoal.model.interactable.pickUpAble.insideChest.Utility.impl;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.insideChest.Utility.UtilityType;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the class that implements an Enchanted Weapon, which the player found in a chest.
 * It increase the combat skill of the player.
 */
public class EnchantedWeapon implements Utility {

    private int numberInInventory;

    /**
     * This is the constructor of the class. It store right away the item the player found in a chest.
     * @param floorManager - it contains all the element of the floor the item is.
     * @param position - this is the position of the chest the item was found.
     */
    public EnchantedWeapon(FloorManager floorManager) {
        numberInInventory = 0;
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemType() {
        return ChestItemType.UTILITY.getName();
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return UtilityType.ENCHANTED_WEAPON.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void use(FloorManager floorManager) {
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        this.addUtility();
        int skillToAdd = new Random().nextInt(9) + 5;
        floorManager.getPlayer().increasePlayerSkill(skillToAdd);
    }

    @Override
    public int getNumberInInventory() {
        return this.numberInInventory;
    }

    private void addUtility() {
        this.numberInInventory++;
    }

    @Override
    public void removeUtility() {
        this.numberInInventory--;
    }

}
