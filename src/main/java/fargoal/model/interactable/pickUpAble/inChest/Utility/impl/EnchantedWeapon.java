package fargoal.model.interactable.pickUpAble.inChest.Utility.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;
import fargoal.model.manager.api.FloorManager;

/**
 * This is the class that implements an Enchanted Weapon, which the player found in a chest.
 */
public class EnchantedWeapon implements Utility {

    final Position position;

    /**
     * This is the constructor of the class. It store right away the item the player found in a chest.
     * @param floorManager - it contains all the element of the floor the item is.
     * @param position - this is the position of the chest the item was found.
     */
    public EnchantedWeapon(FloorManager floorManager, final Position position) {
        this.store(floorManager);
        this.position = position;
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
    public Interactable interact(FloorManager floorManager) {
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return this.getChestItemName();
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    /** {@inheritDoc} */
    @Override
    public void store(FloorManager floorManager) {
        floorManager.getPlayer().getInventory().addEnchantedWeapon();
        int skillToAdd = new Random().nextInt(9) + 5;
        floorManager.getPlayer().setSkill(floorManager.getPlayer().getSkill() + skillToAdd);
    }
    
}
