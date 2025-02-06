package fargoal.view.api;

import fargoal.commons.api.Position;
import fargoal.view.impl.SwingRenderer;

public interface SwingRenderFactory {
    
    SwingRenderer playerRenderer(Position pos);

    SwingRenderer wallRenderer(Position pos);

    SwingRenderer tileRenderer(Position pos);

    SwingRenderer upstairRenderer(Position pos);
    
    SwingRenderer downstairRenderer(Position pos);

    SwingRenderer templeRenderer(Position pos);

    SwingRenderer chestRenderer(Position pos);

    SwingRenderer fogRenderer(Position pos);

    SwingRenderer goldRenderer(Position pos);

    SwingRenderer assassinRenderer(Position pos);

    SwingRenderer barbarianRenderer(Position pos);

    SwingRenderer mageRenderer(Position pos);

    SwingRenderer monkRenderer(Position pos);

    SwingRenderer rogueRenderer(Position pos);

    SwingRenderer spiderRenderer(Position pos);

    SwingRenderer warlordRenderer(Position pos);
}
