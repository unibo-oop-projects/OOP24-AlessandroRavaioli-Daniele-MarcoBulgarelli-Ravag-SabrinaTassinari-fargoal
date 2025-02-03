package fargoal.model.manager.impl;

import java.util.LinkedList;
import java.util.List;

import fargoal.model.FloorElement;
import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

public class FloorManagerImpl implements FloorManager {

    private FloorMap map;
    private List<Monster> monsters;
    private Player player;

    public FloorManagerImpl() {
        this.monsters = new LinkedList<>();
    }

    @Override
    public void update(GameContext context) {
        List<FloorElement> elements = new LinkedList<>();
        elements.addAll(this.monsters);
        elements.add(player);
        elements.forEach(e -> e.update(this));
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public List<Monster> getMonsters() {
        return this.monsters;
    }

}
