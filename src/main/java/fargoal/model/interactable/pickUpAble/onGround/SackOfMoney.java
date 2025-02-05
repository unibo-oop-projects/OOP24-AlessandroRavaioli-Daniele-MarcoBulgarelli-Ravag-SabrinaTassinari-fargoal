package fargoal.model.interactable.pickUpAble.onGround;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

public class SackOfMoney implements Interactable{

    final private Position position;
    private boolean hiddenInGround;

    public SackOfMoney(final Position position) {
        this.position = position;
        this.hiddenInGround = false;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public boolean isHiddenInGround() {
        return this.hiddenInGround;
    }

    @Override
    public String getTag() {
        return "SACK OF GOLD";
    }

    /*quando ci passi sopra prendi i soldi (se la barra spaziatrice è premuta non li prendi)
     * Se il tesoro è nascosto nel suolo ci vai sopra e premi la barra spaziatrice
     */
    @Override
    public Interactable interact(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    private int generateAmountOfMoney(){
        return new Random().nextInt(130) + 20;
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
