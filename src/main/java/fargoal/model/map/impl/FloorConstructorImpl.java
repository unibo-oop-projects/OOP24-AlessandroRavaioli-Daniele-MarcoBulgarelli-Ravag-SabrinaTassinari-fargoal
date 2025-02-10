package fargoal.model.map.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import fargoal.commons.api.Position;
import fargoal.model.map.api.FloorConstructor;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * class that creates a random floor.
 */
public class FloorConstructorImpl implements FloorConstructor {

    /**
     * {@inheritDoc}
     */
    @Override
    public FloorMap createFloor(RenderFactory renderFactory) {
        return new FloorMapBuilder(renderFactory).buildRooms().buildCorridors().build();
    }

    private class FloorMapBuilder {

        private static final int NUMBER_OF_ROOMS_AND_CORRIDORS = 10;
        private static final int OPPOSITE_DIRECTION = 3;
        private static final int MINIMUM_ROOM_SIZE = 3;
        private static final int VARIABLE_ROOM_SIZE = 5;
        private static final int MINIMUM_CORRIDOR_LENGTH = 5;
        private static final int VARIABLE_CORRIDOR_LENGTH = 8;
        private static final int FLOOR_LENGTH = 40;
        private static final int FLOOR_HEIGHT = 25;
        private static final int MAX_TURNS = 10;

        private Map<Position, Renderer> temporaryTiles;
        private Map<Position, Renderer> temporaryWalls;
        private List<Position> centers;
        private final Random rnd;
        private final RenderFactory rf;

        public FloorMapBuilder(RenderFactory renderFactory) {
            this.rf = renderFactory;
            this.rnd = new Random();
            this.temporaryTiles = new HashMap<>();
            this.temporaryWalls = new HashMap<>();
            this.centers = new ArrayList<>();
            for(int i = 0; i < FLOOR_LENGTH; i++) {
                for(int j = 0; j < FLOOR_HEIGHT; j++) {
                    this.temporaryWalls.put(new Position(i, j), rf.wallRenderer(new Position(i, j)));
                }
            }
        }

        private FloorMap build() {
            temporaryTiles = temporaryTiles.keySet().stream()
                    .filter(p -> p.x() >= 1 && p.y() >= 1)
                    .filter(p -> p.x() < FLOOR_LENGTH - 1 && p.y() < FLOOR_HEIGHT - 1)
                    .collect(Collectors.toMap(p -> p,p ->  rf.tileRenderer(p)));
            return new FloorMapImpl(temporaryTiles, temporaryWalls, FLOOR_LENGTH, FLOOR_HEIGHT);
        }

        private void buildRoom(final Position pos, final int height, final int length) {
            for (int i = pos.x(); i < pos.x() + length; i++) {
                for (int j = pos.y(); j < pos.y() + height; j++) {
                    this.temporaryTiles.put(new Position(i, j), rf.tileRenderer(pos));
                    this.temporaryWalls.remove(pos);
                }
            }
        }

        private void buildCorridor(final Position pos) {
            enum FloorState {
                CONTINUE, HIT_PATH, WALL
            }
            List<Position> directions = new ArrayList<>(List.of(
                        new Position(1, 0),
                        new Position(0, 1),
                        new Position(0, -1),
                        new Position(-1, 0)));
            FloorState state = FloorState.CONTINUE;
            Random rnd = new Random();
            int direction = rnd.nextInt(directions.size());
            Position currentPosition = pos;
            int turns = 0;

            while (!state.equals(FloorState.HIT_PATH) &&  turns < MAX_TURNS) {
                int length = rnd.nextInt(VARIABLE_CORRIDOR_LENGTH) + MINIMUM_CORRIDOR_LENGTH;

                for (int j = 0; j < length; j++) {
                    currentPosition = currentPosition.add(directions.get(direction));
                    if (!this.temporaryTiles.containsKey(currentPosition)) {
                        state = FloorState.WALL;
                    }
                    if (currentPosition.x() < 1 || currentPosition.y() < 1 
                        || currentPosition.x() >= FLOOR_LENGTH - 1 || currentPosition.y() >= FLOOR_HEIGHT - 1) {
                        break;
                    }
                    if (state.equals(FloorState.WALL) && this.temporaryTiles.containsKey(currentPosition)) {
                        state = FloorState.HIT_PATH;
                        break;
                    }

                    this.temporaryTiles.put(currentPosition, rf.tileRenderer(currentPosition));
                    this.temporaryWalls.remove(currentPosition);
                }

                turns++;
                int last = direction;
                do {
                    direction = rnd.nextInt(directions.size());
                } while (direction == OPPOSITE_DIRECTION - last);
            }
        }

        private FloorMapBuilder buildRooms() {
            for (int i = 0; i < NUMBER_OF_ROOMS_AND_CORRIDORS; i++) {
                int length = rnd.nextInt(VARIABLE_ROOM_SIZE) + MINIMUM_ROOM_SIZE;
                int height = rnd.nextInt(VARIABLE_ROOM_SIZE) + MINIMUM_ROOM_SIZE;
                Position start = new Position(
                    rnd.nextInt(FLOOR_LENGTH - MINIMUM_ROOM_SIZE - length) + 1,
                    rnd.nextInt(FLOOR_HEIGHT - MINIMUM_ROOM_SIZE - height) + 1);
                centers.add(new Position(start.x() + length / 2, start.y() + height / 2));
                this.buildRoom(start, height, length);
            }
            return this;
        }

        private FloorMapBuilder buildCorridors() {
            for (int i = 0; i < NUMBER_OF_ROOMS_AND_CORRIDORS; i++) {
                this.buildCorridor(centers.get(i));
            }
            return this;
        }
    }
}
