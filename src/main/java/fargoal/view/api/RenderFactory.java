package fargoal.view.api;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;

public interface RenderFactory {
    
    Renderer playerRenderer(FloorElement obj);

    Renderer wallRenderer(Position pos);

    Renderer tileRenderer(Position pos);

    Renderer upstairRenderer(FloorElement obj);

    Renderer downstairRenderer(FloorElement obj);

    Renderer templeRenderer(FloorElement obj);

    Renderer chestRenderer(FloorElement obj);

    Renderer fogRenderer(Position pos);

    Renderer goldRenderer(FloorElement obj);

    Renderer assassinRenderer(FloorElement obj);

    Renderer barbarianRenderer(FloorElement obj);

    Renderer mageRenderer(FloorElement obj);

    Renderer monkRenderer(FloorElement obj);

    Renderer rogueRenderer(FloorElement obj);

    Renderer spiderRenderer(FloorElement obj);

    Renderer warlordRenderer(FloorElement obj);
}
