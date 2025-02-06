package fargoal.view.api;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.view.impl.SwingRenderer;

public interface SwingRenderFactory {
    
    SwingRenderer playerRenderer(FloorElement obj);

    SwingRenderer wallRenderer(Position pos);

    SwingRenderer tileRenderer(Position pos);

    SwingRenderer upstairRenderer(FloorElement obj);
    
    SwingRenderer downstairRenderer(FloorElement obj);

    SwingRenderer templeRenderer(FloorElement obj);

    SwingRenderer chestRenderer(FloorElement obj);

    SwingRenderer fogRenderer(Position pos);

    SwingRenderer goldRenderer(FloorElement obj);

    SwingRenderer assassinRenderer(FloorElement obj);

    SwingRenderer barbarianRenderer(FloorElement obj);

    SwingRenderer mageRenderer(FloorElement obj);

    SwingRenderer monkRenderer(FloorElement obj);

    SwingRenderer rogueRenderer(FloorElement obj);

    SwingRenderer spiderRenderer(FloorElement obj);

    SwingRenderer warlordRenderer(FloorElement obj);
}
