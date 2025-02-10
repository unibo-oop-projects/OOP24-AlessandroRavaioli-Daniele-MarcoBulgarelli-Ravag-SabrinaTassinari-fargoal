package fargoal.model.map.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fargoal.commons.api.Position;
import fargoal.model.map.api.Dimension;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.Renderer;

/**
 * A class that models a floor.
 */
public class FloorMapImpl implements FloorMap {

    private final Map<Position, Renderer> tiles;
    private final Map<Position, Renderer> walls;
    private final Dimension size;

    protected FloorMapImpl(final Map<Position, Renderer> tiles,
            final Map<Position, Renderer> walls,
            final int length,
            final int height) {
        this.tiles = Map.copyOf(tiles);
        this.walls = Map.copyOf(walls);
        this.size = new Dimension(length, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTile(final Position pos) {
        return this.tiles.containsKey(pos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getSize() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Position getRandomTile() {
        List<Position> list = new LinkedList<>(this.tiles.keySet());
        Collections.shuffle(list);
        return list.getFirst();
    }

    @Override
    public void render(Position pos) {
        (this.isTile(pos) ? this.tiles : this.walls).get(pos).render();
    }
}
