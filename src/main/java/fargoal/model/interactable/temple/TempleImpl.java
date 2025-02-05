package fargoal.model.interactable.temple;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

public class TempleImpl implements Interactable {

    final Position position;

    public TempleImpl(final Position position) {
        this.position = position;
    }

    //dona al tempio e non può essere attaccato
    @Override
    public Interactable interact(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interact'");
    }

    @Override
    public Position getPosition() {
        return this.position;
    }


    @Override
    public String getTag() {
        return "TEMPLE";
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
