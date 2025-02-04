package fargoal.model.interactable.temple.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.temple.api.Temple;

public class TempleImpl implements Temple{

    final Position position;

    public TempleImpl(final Position position) {
        this.position = position;
    }

    @Override
    public void interact() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
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
        return "TEMPLE";
    }

    @Override
    public void unattackable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'donate'");
    }
    
}
