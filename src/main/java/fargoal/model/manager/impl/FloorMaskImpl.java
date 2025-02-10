package fargoal.model.manager.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import fargoal.commons.api.Position;
import fargoal.model.core.GameContext;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.manager.api.FloorMask;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.View;
import fargoal.view.impl.SwingRenderFactory;

/**
 * A class that implements the map covering effect.
 */
public class FloorMaskImpl implements FloorMask {

    private static final int FLOOR_HEIGTH = 25;
    private static final int FLOOR_LENGTH = 40;

    private final Map<Position, Boolean> mask;

    /**
     * Constrctor that inizializes the mask as complete darkness and defines the renderers.
     * @param view - the view in which the renderers are called
     */
    public FloorMaskImpl() {
        this.mask = new HashMap<>();
        resetMask();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetMask() {
        for (int i = 0; i < FLOOR_LENGTH; i++) {
            for (int j = 0; j < FLOOR_HEIGTH; j++) {
                mask.put(new Position(i, j), false);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final GameContext context, final FloorManager manager) {
        List<Position> lightUp = this.mask.keySet().stream()
                .filter(e -> Math.abs(e.x() - manager.getPlayer().getPosition().x()) <= 1
                        && Math.abs(e.y() - manager.getPlayer().getPosition().y()) <= 1)
                .toList();
        lightUp.forEach(p -> this.mask.replace(p, true));
        for (int x = 0; x < FLOOR_LENGTH; x++) {
            for (int y = 0; y < FLOOR_HEIGTH; y++) {
                var pos = new Position(x, y);
                if (this.mask.get(pos)) {
                    manager.getFloorMap().render(pos);
                }
            }
        }

        for(var element : manager.getAllElements()) {
            if (this.mask.get(element.getPosition())) {
                element.render();
            }
        }

        manager.getPlayer().render();
    }

    @Override
    public void clearMask() {
        for (int i = 0; i < FLOOR_LENGTH; i++) {
            for (int j = 0; j < FLOOR_HEIGTH; j++) {
                mask.replace(new Position(i, j), true);
            }
        }
    }

}
