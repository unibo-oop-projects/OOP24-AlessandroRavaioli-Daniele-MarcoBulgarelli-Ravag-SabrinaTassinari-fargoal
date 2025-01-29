package model.map.impl;

import java.util.HashSet;
import java.util.Set;

import commons.api.Position;
import model.map.api.FloorConstructor;
import model.map.api.FloorMap;

public class FloorConstructorImpl implements FloorConstructor{

    @Override
    public FloorMap createFloor(int size) {
        return new FloorMapBuilder(size).build();
    }
    
    private class FloorMapBuilder {
    
        Set<Position> temporaryTiles = new HashSet<>();
        final private int size;

        public FloorMapBuilder(int size){
            this.size = size;
        }

        private FloorMap build() {
            return new FloorMapImpl(temporaryTiles);
        }

        private void buildRoom(Position pos, int height, int length){

        }

        private void buildCorridor(Position pos, int length){

        }
    }
}
