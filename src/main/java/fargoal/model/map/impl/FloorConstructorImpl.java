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
            int direction = rnd.nextInt(4);
            Position currentPosition = pos;

            while (state.equals(FloorState.CONTINUE)) {
                state = FloorState.CONTINUE;
                int length = rnd.nextInt(8) + 5;
                
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
                    direction = rnd.nextInt(4);
                } while (direction == 3 - last);
            }
        }

        private FloorMapBuilder buildRooms(){
            for(int i = 0; i < 10; i++) {
                centers.add(new Position(rnd.nextInt(size.length() - 1), rnd.nextInt(size.height() - 1)));
                this.buildRoom(centers.get(i), rnd.nextInt(5) + 3, rnd.nextInt(5) + 3);
            }
            return this;
        }

        private FloorMapBuilder buildCorridors(){
            for(int i = 0; i < 10; i++) {
                this.buildCorridor(centers.get(i));
            }
            return this;
        }
    }
}
