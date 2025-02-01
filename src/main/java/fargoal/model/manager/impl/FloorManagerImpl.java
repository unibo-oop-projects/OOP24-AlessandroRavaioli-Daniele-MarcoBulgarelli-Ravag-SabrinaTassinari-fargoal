package fargoal.model.manager.impl;

import java.util.LinkedList;
import java.util.List;

import fargoal.controller.input.api.Command;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

public class FloorManagerImpl implements FloorManager {

    private FloorMap map;
    private List<Monster> monsters;

    public FloorManagerImpl() {
        this.monsters = new LinkedList<>();
    }

    @Override
    public void update(Command input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
