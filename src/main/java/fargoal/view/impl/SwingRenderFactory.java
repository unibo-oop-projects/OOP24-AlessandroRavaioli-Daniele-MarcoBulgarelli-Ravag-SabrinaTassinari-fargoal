package fargoal.view.impl;

import java.awt.Color;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class SwingRenderFactory implements RenderFactory {

    private final SwingView view;

    public SwingRenderFactory(View view){
        this.view = (SwingView)view;
    }

    @Override
    public Renderer wallRenderer(Position pos) {
        return new SwingRenderer(g2d -> {
                g2d.setColor(Color.RED);
                g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                            pos.y() * this.view.getTilePixelDim(),
                            this.view.getTilePixelDim(),
                            this.view.getTilePixelDim());
            }, this.view);
    }

    @Override
    public Renderer tileRenderer(Position pos) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                         pos.y() * this.view.getTilePixelDim(),
                         this.view.getTilePixelDim(),
                         this.view.getTilePixelDim());
            }, this.view);
    }

    @Override
    public Renderer fogRenderer(Position pos) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(pos.x() * this.view.getTilePixelDim(),
                    pos.y() * this.view.getTilePixelDim(),
                    this.view.getTilePixelDim(),
                    this.view.getTilePixelDim());
            }, this.view);
    }

    @Override
    public Renderer playerRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playerRenderer'");
    }

    @Override
    public Renderer upstairRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upstairRenderer'");
    }

    @Override
    public Renderer downstairRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'downstairRenderer'");
    }

    @Override
    public Renderer templeRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'templeRenderer'");
    }

    @Override
    public Renderer chestRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chestRenderer'");
    }

    @Override
    public Renderer goldRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'goldRenderer'");
    }

    @Override
    public Renderer assassinRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assassinRenderer'");
    }

    @Override
    public Renderer barbarianRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'barbarianRenderer'");
    }

    @Override
    public Renderer mageRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mageRenderer'");
    }

    @Override
    public Renderer monkRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monkRenderer'");
    }

    @Override
    public Renderer rogueRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rogueRenderer'");
    }

    @Override
    public Renderer spiderRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'spiderRenderer'");
    }

    @Override
    public Renderer warlordRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'warlordRenderer'");
    }
    
}
