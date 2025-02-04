package fargoal.model.interactable.beacon;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;

public class Beacon implements Interactable{

    final Position position;

    public Beacon(final Position position) {
        this.position = position;
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
        return "BEACON";
    }

    //unattackable
    @Override
    public void interact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }
    
}
