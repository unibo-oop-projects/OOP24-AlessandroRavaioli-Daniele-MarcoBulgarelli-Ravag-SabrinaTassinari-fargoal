package fargoal.model.manager.impl;

import java.util.LinkedList;
import java.util.List;

import fargoal.model.commons.FloorElement;
import fargoal.model.core.GameContext;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;
import fargoal.model.map.api.FloorMap;
import fargoal.model.map.impl.FloorConstructorImpl;

/**
 * A class that implements the entirety of the floor and all its elements.
 */
public class FloorManagerImpl implements FloorManager {

    private FloorMap map;
    private List<Monster> monsters;
    private Player player;
    private final FloorMask mask;
    private int floorLevel;

    /**
     * Constructor that inizializes all of its fields.
     * @param context - the structure in which the reference to the view is contained
     */
    public FloorManagerImpl(final GameContext context) {
        this.monsters = new LinkedList<>();
        this.mask = new FloorMaskImpl(context.getView());
        this.map = new FloorConstructorImpl().createFloor();
        this.floorLevel = 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameContext context) {
        List<FloorElement> elements = new LinkedList<>();
        elements.addAll(this.monsters);
        elements.add(player);
        elements.forEach(e -> e.update(this));
        this.mask.update(context, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Monster> getMonsters() {
        return this.monsters;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FloorMap getFloorMap() {
        return this.map;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFloorLevel() {
        return this.floorLevel;
    }

    @Override
    public void increaseFloorLevel() {
        this.floorLevel++;
        this.map = new FloorConstructorImpl().createFloor();
    }

    @Override
    public void decreaseFloorLevel() {
        if (this.floorLevel <= 0) {
            throw new  IllegalStateException("cannot go to level -1");
        }
        this.floorLevel--;
        this.map = new FloorConstructorImpl().createFloor();
    }

}
