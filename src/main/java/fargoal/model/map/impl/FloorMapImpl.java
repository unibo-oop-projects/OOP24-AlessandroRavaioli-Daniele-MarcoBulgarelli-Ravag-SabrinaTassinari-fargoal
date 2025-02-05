package fargoal.model.map.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fargoal.commons.api.Position;
import fargoal.model.map.api.Dimension;
import fargoal.model.map.api.FloorMap;

/**
 * A class that models a floor.
 */
public class FloorMapImpl implements FloorMap {

    private final Set<Position> tiles;
    private final Dimension size;

    protected FloorMapImpl(final Set<Position> tiles, final int length, final int height) {
        this.tiles = Set.copyOf(tiles);
        this.size = new Dimension(length, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTile(final Position pos) {
        return this.tiles.contains(pos);
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
        List<Position> list = new LinkedList<>(this.tiles);
        Collections.shuffle(list);
        return list.getFirst();
    }
}
