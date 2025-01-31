package fargoal.model.map.impl;

import java.util.Set;

import fargoal.commons.api.Position;
import fargoal.model.map.api.Dimension;
import fargoal.model.map.api.FloorMap;

public class FloorMapImpl implements FloorMap {

    private final Set<Position> tiles;
    private final Dimension size;

    protected FloorMapImpl(Set<Position> tiles, int length, int height){
        this.tiles = Set.copyOf(tiles);
        this.size = new Dimension(length, height);
    }

    @Override
    public boolean isTile(Position pos) {
        return this.tiles.contains(pos);
    }

    @Override
    public Dimension getSize() {
        return size;
    }
    
}
