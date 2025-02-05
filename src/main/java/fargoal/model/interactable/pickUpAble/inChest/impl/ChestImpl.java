package fargoal.model.interactable.pickUpAble.inChest.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

/**
 * The implementation of the interface Chest.
 */
public class ChestImpl implements Interactable {

    final static int N_CHEST_ITEM = 15;
    final private Position position;
    private boolean open;

    /**
     * The constructor of thi class. It set all the field of the class.
     * @param position - the position of the chest
     */
    public ChestImpl(final Position position) {
        this.position = position;
        this.open = false;
    }

    /**
     * With this method it can be checked if the chest is open or not. 
     * @return a boolean that indicate if the chest is open or not.
     */
    public boolean isOpen() {
        return this.open;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }
    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "CHEST";
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        int num = new Random().nextInt(N_CHEST_ITEM);
        ChestItem item;
        if (num == 0) {
            item = new ChestItemFactoryImpl().generateDriftSpell(floorManager);
        } else if (num == 1) {
            item = new ChestItemFactoryImpl().generateInvisibilitySpell(floorManager);
        } else if (num == 2) {
            item = new ChestItemFactoryImpl().generateLightSpell(floorManager);
        } else if (num == 3) {
            item = new ChestItemFactoryImpl().generateRegenerationSpell(floorManager);
        } else if (num == 4) {
            item = new ChestItemFactoryImpl().generateShieldSpell(floorManager);
        } else if (num == 5) {
            item = new ChestItemFactoryImpl().generateTeleportSpell(floorManager);
        } else if (num == 6) {
            item = new ChestItemFactoryImpl().generateCeilingTrap(floorManager);
        } else if (num == 7) {
            item = new ChestItemFactoryImpl().generateExplosion(floorManager);
        } else if (num == 8) {
            item = new ChestItemFactoryImpl().generatePit(floorManager);
        } else if (num == 9) {
            item = new ChestItemFactoryImpl().generateTeleport(floorManager);
        } else if (num == 10) {
            item = new ChestItemFactoryImpl().generateBeacon(floorManager);
        } else if (num == 11) {
            item = new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager);
        } else if (num == 12) {
            item = new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager);
        } else if (num == 13) {
            item = new ChestItemFactoryImpl().generateHealingPotion(floorManager);
        } else if (num == 14) {
            item = new ChestItemFactoryImpl().generateMap(floorManager);
        } else {
            item = new ChestItemFactoryImpl().generateMagicSack(floorManager);
        }
        return item;
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
