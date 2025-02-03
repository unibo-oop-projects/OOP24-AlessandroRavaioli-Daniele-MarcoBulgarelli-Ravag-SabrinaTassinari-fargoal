package fargoal.model.manager.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import fargoal.commons.api.Position;
import fargoal.model.core.GameContext;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;

public class FloorMaskImpl implements FloorMask{

    private final static int FLOOR_HEIGTH = 25;
    private final static int FLOOR_LENGTH = 40;

    private final Map<Position, Boolean> mask = new HashMap<>();

    public FloorMaskImpl() {
        resetMask();
    }

    @Override
    public void resetMask() {
        for (int i = 0; i < FLOOR_LENGTH; i++) {
            for (int j = 0; j < FLOOR_HEIGTH; j++) {
                mask.put(new Position(i, j), false);
            }
        }
    }

    @Override
    public void update(GameContext context, FloorManager manager) {
        List<Position> lightUp = this.mask.keySet().stream()
                .filter(e -> Math.abs(e.x() - manager.getPlayer().getPosition().x()) <= 1
                        && Math.abs(e.y() - manager.getPlayer().getPosition().y()) <= 1)
                .toList();
        lightUp.forEach(p -> this.mask.put(p, true));

        for (int x = 0; x < FLOOR_LENGTH; x++) {
            for (int y = 0; y < FLOOR_HEIGTH; y++) {
                if (this.mask.get(new Position(x, y))) {
                    /*update view list here */
                }
            }
        }
    }
    
}
