package fargoal.model.interactable.pickUpAble.insideChest.Trap.impl;

import java.util.Random;

import fargoal.model.interactable.pickUpAble.insideChest.Trap.api.AbstractTrap;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.api.TrapType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements an Explosion, a trap that can be found in a chest.
 * It damages the player when he find it.
 */
public class Explosion extends AbstractTrap {

    private static final int MAX_DAMAGE = 14;

    /**
     * This is the constructor of the class. When the player finds the trap in a chest it damages him immediately. 
     * @param floorManager - it contains all the element of the floor the trap was found.
     */
    public Explosion(final FloorManager floorManager) {
        this.use(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return TrapType.EXPLOSION.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void effect(final FloorManager floorManager) {
        final int damage = new Random().nextInt(MAX_DAMAGE) + floorManager.getFloorLevel();
        floorManager.getPlayer().getHealth().decreaseHealth(damage);
    }

}
