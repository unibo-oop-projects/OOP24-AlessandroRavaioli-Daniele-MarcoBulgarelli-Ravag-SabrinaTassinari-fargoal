package fargoal.view.impl;

import java.awt.Color;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.view.api.SwingRenderFactory;
import fargoal.view.api.View;

public class SwingRenderFactoryImpl implements SwingRenderFactory {

    private final SwingView view;

    public SwingRenderFactoryImpl(View view){
        this.view = (SwingView)view;
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
    public SwingRenderer playerRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playerRenderer'");
    }

    @Override
    public SwingRenderer upstairRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upstairRenderer'");
    }

    @Override
    public SwingRenderer downstairRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'downstairRenderer'");
    }

    @Override
    public SwingRenderer templeRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'templeRenderer'");
    }

    @Override
    public SwingRenderer chestRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chestRenderer'");
    }

    @Override
    public SwingRenderer goldRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'goldRenderer'");
    }

    @Override
    public SwingRenderer assassinRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assassinRenderer'");
    }

    @Override
    public SwingRenderer barbarianRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'barbarianRenderer'");
    }

    @Override
    public SwingRenderer mageRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mageRenderer'");
    }

    @Override
    public SwingRenderer monkRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monkRenderer'");
    }

    @Override
    public SwingRenderer rogueRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rogueRenderer'");
    }

    @Override
    public SwingRenderer spiderRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'spiderRenderer'");
    }

    @Override
    public SwingRenderer warlordRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'warlordRenderer'");
    }
    
}
