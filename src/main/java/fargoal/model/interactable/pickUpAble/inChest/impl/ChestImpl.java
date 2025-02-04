package fargoal.model.interactable.pickUpAble.inChest.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.pickUpAble.inChest.api.Chest;

public class ChestImpl implements Chest{

    private Position position;
    private boolean open;

    public ChestImpl() {
        this.open = false;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
    
}
