package model.map.impl;

import java.util.Set;

import commons.api.Position;
import model.map.api.FloorMap;

public class FloorMapImpl implements FloorMap {

    private final Set<Position> tiles;

    protected FloorMapImpl(Set<Position> tiles){
        this.tiles = Set.copyOf(tiles);
    }

    @Override
    public boolean isTile(Position pos) {
        return this.tiles.contains(pos);
    }
    
}
