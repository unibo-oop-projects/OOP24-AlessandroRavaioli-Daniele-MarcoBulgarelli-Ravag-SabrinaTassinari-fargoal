package fargoal.view.impl;

import java.awt.Color;

import fargoal.commons.api.Position;
import fargoal.view.api.SwingRenderFactory;

public class SwingRenderFactoryImpl implements SwingRenderFactory {

    private final SwingView view;

    public SwingRenderFactoryImpl(SwingView view){
        this.view = view;
    }

    @Override
    public SwingRenderer player(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'player'");
    }

    @Override
    public SwingRenderer wall(Position pos) {
        return new SwingRenderer(g2d -> {
                g2d.setColor(Color.RED);
                g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                            pos.y() * this.view.getTilePixelDim(),
                            this.view.getTilePixelDim(),
                            this.view.getTilePixelDim());
            });
    }

    @Override
    public SwingRenderer tile(Position pos) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                         pos.y() * this.view.getTilePixelDim(),
                         this.view.getTilePixelDim(),
                         this.view.getTilePixelDim());
        });
    }

    @Override
    public SwingRenderer monster(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moster'");
    }

    @Override
    public SwingRenderer stair(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stair'");
    }

    @Override
    public SwingRenderer temple(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'temple'");
    }

    @Override
    public SwingRenderer pickup(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickup'");
    }
    
}
