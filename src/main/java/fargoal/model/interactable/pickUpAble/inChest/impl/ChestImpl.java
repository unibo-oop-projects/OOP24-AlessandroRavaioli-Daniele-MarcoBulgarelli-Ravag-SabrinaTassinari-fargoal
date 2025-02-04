package fargoal.model.interactable.pickUpAble.inChest.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.pickUpAble.inChest.api.Chest;
import fargoal.model.manager.api.FloorManager;

public class ChestImpl implements Chest{

    final private Position position;
    private boolean open;

    public ChestImpl(final Position position) {
        this.position = position;
        this.open = false;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public boolean isColliding() {
        return false;
    }

    @Override
    public String getTag() {
        return "CHEST";
    }

    /*generare casualmente un chestItem (lo faccio quando la cassa viene aperta) */
    @Override
    public String getChestItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItem'");
    }

    /*apri la cesta con barra spaziatrice quando ci sei vicino*/
    @Override
    public void interact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
