package fargoal.view.api;

import fargoal.view.impl.SwingRenderer;

public interface SwingRenderFactory {
    
    SwingRenderer player();

    SwingRenderer wall();

    SwingRenderer tile();

    SwingRenderer moster();

    SwingRenderer stair();

    SwingRenderer temple();

    SwingRenderer pickup();
}
