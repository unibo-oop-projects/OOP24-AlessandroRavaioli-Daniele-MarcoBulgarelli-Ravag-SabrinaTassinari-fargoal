package fargoal.view.impl;

import java.awt.Color;

import fargoal.commons.api.Position;
import fargoal.view.api.SwingRenderFactory;
import fargoal.view.api.View;

public class SwingRenderFactoryImpl implements SwingRenderFactory {

    private final SwingView view;

    public SwingRenderFactoryImpl(View view){
        this.view = (SwingView)view;
    }

    @Override
    public SwingRenderer playerRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'player'");
    }

    @Override
    public SwingRenderer wallRenderer(Position pos) {
        return new SwingRenderer(g2d -> {
                g2d.setColor(Color.RED);
                g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                            pos.y() * this.view.getTilePixelDim(),
                            this.view.getTilePixelDim(),
                            this.view.getTilePixelDim());
            }, this.view);
    }

    @Override
    public SwingRenderer tileRenderer(Position pos) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                         pos.y() * this.view.getTilePixelDim(),
                         this.view.getTilePixelDim(),
                         this.view.getTilePixelDim());
            }, this.view);
    }

    @Override
    public SwingRenderer upstairRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upstairRenderer'");
    }

    @Override
    public SwingRenderer downstairRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'downstairRenderer'");
    }

    @Override
    public SwingRenderer templeRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'temple'");
    }

    @Override
    public SwingRenderer chestRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickup'");
    }

    @Override
    public SwingRenderer fogRenderer(Position pos) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                    pos.y() * this.view.getTilePixelDim(),
                    this.view.getTilePixelDim(),
                    this.view.getTilePixelDim());
            }, this.view);
    }

    @Override
    public SwingRenderer goldRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'goldRenderer'");
    }

    @Override
    public SwingRenderer assassinRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assassinRenderer'");
    }

    @Override
    public SwingRenderer barbarianRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'barbarianRenderer'");
    }

    @Override
    public SwingRenderer mageRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mageRenderer'");
    }

    @Override
    public SwingRenderer monkRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monkRenderer'");
    }

    @Override
    public SwingRenderer rogueRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rogueRenderer'");
    }

    @Override
    public SwingRenderer spiderRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'spiderRenderer'");
    }

    @Override
    public SwingRenderer warlordRenderer(Position pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'warlordRenderer'");
    }
    
}
