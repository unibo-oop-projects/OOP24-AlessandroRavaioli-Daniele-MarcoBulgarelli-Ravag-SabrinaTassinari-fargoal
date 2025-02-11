package fargoal.model.interactable.pickUpAble.insideChest.Trap.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.api.AbstractTrap;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.api.TrapType;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements a Teleport, a trap that can be found in a chest.
 * It teleport the player in a random position in the floor.
 */
public class Teleport extends AbstractTrap {

    /**
     * This is the constructor of the class. When the player finds the trap in a chest it teleport him immediately. 
     * @param floorManager - it contains all the element of the floor the trap was found.
     */
    public Teleport(FloorManager floorManager) {
        this.use(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public String getChestItemName() {
        return TrapType.TELEPORT.getName();
    }

    /** {@inheritDoc} */
    @Override
    public void effect(FloorManager floorManager) {
        Position newPositionPlayer = floorManager.getFloorMap().getRandomTile();
        floorManager.getPlayer().setPosition(newPositionPlayer);
    }

}
