package fargoal.model.map.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import fargoal.api.Position;
import fargoal.model.map.api.Dimension;
import fargoal.model.map.api.FloorConstructor;
import fargoal.model.map.api.FloorMap;

public class FloorConstructorImpl implements FloorConstructor{

    @Override
    public FloorMap createFloor(int length, int height) {
        return new FloorMapBuilder(length, height).buildRooms().buildCorridors().build();
    }
    
    private class FloorMapBuilder {
    
        private static final int NUMBER_OF_ROOMS_AND_CORRIDORS = 10;
        private static final int OPPOSITE_DIRECTION = 3;
        private static final int MINIMUM_ROOM_SIZE = 3;
        private static final int VARIABLE_ROOM_SIZE = 5;
        private static final int MINIMUM_CORRIDOR_LENGTH = 5;
        private static final int VARIABLE_CORRIDOR_LENGTH = 8;
        Set<Position> temporaryTiles = new HashSet<>();
        List<Position> centers = new ArrayList<>();
        private final Dimension size;
        private final Random rnd = new Random();

        public FloorMapBuilder(int length, int height){
            this.size = new Dimension(length, height);
        }

        private FloorMap build() {
            temporaryTiles = temporaryTiles.stream()
                    .filter(p -> p.x() >= 1 && p.y() >= 1)
                    .filter(p -> p.x() < this.size.length() - 1 && p.y() < this.size.height() - 1)
                    .collect(Collectors.toSet());
            return new FloorMapImpl(temporaryTiles, size.length(), size.height());
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
            int direction = rnd.nextInt(directions.size());
            Position currentPosition = pos;

            while (state.equals(FloorState.CONTINUE)) {
                state = FloorState.CONTINUE;
                int length = rnd.nextInt(VARIABLE_CORRIDOR_LENGTH) + MINIMUM_CORRIDOR_LENGTH;
                
                for(int j = 0; j < length; j++) {
                    currentPosition = currentPosition.add(directions.get(direction));
                    if (!this.temporaryTiles.contains(currentPosition)) {
                        state = FloorState.WALL;
                    }
                    if (currentPosition.x() < 1 || currentPosition.y() < 1 
                        || currentPosition.x() >= this.size.length() - 1 || currentPosition.y() >= this.size.height() - 1) {
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
                    direction = rnd.nextInt(directions.size());
                } while (direction == OPPOSITE_DIRECTION - last);
            }
        }

        private FloorMapBuilder buildRooms(){
            for(int i = 0; i < NUMBER_OF_ROOMS_AND_CORRIDORS; i++) {
                centers.add(new Position(rnd.nextInt(size.length() - 1), rnd.nextInt(size.height() - 1)));
                this.buildRoom(centers.get(i), rnd.nextInt(VARIABLE_ROOM_SIZE) + MINIMUM_ROOM_SIZE, rnd.nextInt(VARIABLE_ROOM_SIZE) + MINIMUM_ROOM_SIZE);
            }
            return this;
        }

        private FloorMapBuilder buildCorridors(){
            for(int i = 0; i < NUMBER_OF_ROOMS_AND_CORRIDORS; i++) {
                this.buildCorridor(centers.get(i));
            }
            return this;
        }
    }
}
