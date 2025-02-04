package fargoal.view.api;

import fargoal.commons.api.Position;
import fargoal.view.impl.SwingRenderer;

public interface SwingRenderFactory {
    
    SwingRenderer player(Position pos);

    SwingRenderer wall(Position pos);

    SwingRenderer tile(Position pos);

    SwingRenderer monster(Position pos);

    SwingRenderer stair(Position pos);

    SwingRenderer temple(Position pos);

    SwingRenderer pickup(Position pos);

    SwingRenderer fog(Position pos);
}
