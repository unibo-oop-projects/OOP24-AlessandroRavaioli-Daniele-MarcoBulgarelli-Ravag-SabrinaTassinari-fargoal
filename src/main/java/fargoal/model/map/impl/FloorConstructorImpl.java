package fargoal.model.map.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import fargoal.api.Position;
import fargoal.model.map.api.FloorConstructor;
import fargoal.model.map.api.FloorMap;

public class FloorConstructorImpl implements FloorConstructor{

    @Override
    public FloorMap createFloor(int size) {
        FloorMapBuilder builder = new FloorMapBuilder(size);
        Random rnd = new Random();
        List<Position> centers = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            centers.add(new Position(rnd.nextInt(size - 1), rnd.nextInt(size - 1)));
            builder.buildRoom(
                centers.get(i),
                rnd.nextInt(5) + 3,
                rnd.nextInt(5) + 3);
        }
        for(int i = 0; i < 10; i++) {
            builder.buildCorridor(centers.get(i));
        }
        return builder.build();
    }
    
    private class FloorMapBuilder {
    
        Set<Position> temporaryTiles = new HashSet<>();
        final private int size;

        public FloorMapBuilder(int size){
            this.size = size;
        }

        private FloorMap build() {
            temporaryTiles = temporaryTiles.stream()
                    .filter(p -> p.x() >= 1 && p.y() >= 1)
                    .filter(p -> p.x() < this.size - 1 && p.y() < this.size - 1)
                    .collect(Collectors.toSet());
            return new FloorMapImpl(temporaryTiles);
        }

        private void buildRoom(Position pos, int height, int length){
            for(int i = pos.x() - length / 2; i < pos.x() + length / 2; i++) {
                for(int j = pos.y() - height / 2; j < pos.y() + height / 2; j++){
                    this.temporaryTiles.add(new Position(i, j));
                }
            }
        }

        private void buildCorridor(Position pos){
            enum FloorState {
                CONTINUE, HIT_PATH, WALL
            }
            List<Position> directions = new ArrayList<>(List.of(
                        new Position(1, 0),
                        new Position(0, 1),
                        new Position(-1, 0),
                        new Position(0, -1)));
            FloorState state = FloorState.CONTINUE;
            Random rnd = new Random();
            int direction = rnd.nextInt(4);
            Position currentPosition = pos;

            while (state.equals(FloorState.CONTINUE)) {
                state = FloorState.CONTINUE;
                int length = rnd.nextInt(8) + 5;
                
                for(int j = 0; j < length; j++) {
                    currentPosition.add(directions.get(direction));
                    if (!this.temporaryTiles.contains(currentPosition)) {
                        state = FloorState.WALL;
                    }
                    if (currentPosition.x() < 1 || currentPosition.y() < 1 
                        || currentPosition.x() >= this.size - 1 || currentPosition.y() >= this.size - 1) {
                        break;
                    }
                    if (state.equals(FloorState.WALL) && this.temporaryTiles.contains(currentPosition)) {
                        state = FloorState.HIT_PATH;
                        break;
                    }

                    this.temporaryTiles.add(currentPosition);
                }

                int last = direction;
                do {
                    direction = rnd.nextInt(4);
                } while (direction == 3 - last);
            }
        }
    }
}
