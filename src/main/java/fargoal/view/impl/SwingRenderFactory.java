package fargoal.view.impl;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.model.interactable.pickUpAble.onGround.SackOfMoney;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class SwingRenderFactory implements RenderFactory {

    private final SwingView view;
    private Map<Position, Renderer> cache;

    public SwingRenderFactory(View view){
        this.view = (SwingView)view;
        cache = new HashMap<>();
    }

    @Override
    public Renderer wallRenderer(Position pos) {
        if (this.cache.containsKey(pos)) {
            return this.cache.get(pos);
        }
        cache.put(pos, new SwingRenderer(g2d -> {
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(pos.x() * this.view.getTilePixelWidth(),
                        pos.y() * this.view.getTilePixelHeight(),
                        this.view.getTilePixelWidth(),
                        this.view.getTilePixelHeight());
                }, this.view));
        return this.cache.get(pos);
    }

    @Override
    public Renderer tileRenderer(Position pos) {
        if (this.cache.containsKey(pos)) {
            return this.cache.get(pos);
        }
        this.cache.put(pos, new SwingRenderer(g2d -> {
                g2d.setColor(Color.WHITE);
                g2d.fillRect(pos.x() * this.view.getTilePixelWidth(),
                        pos.y() * this.view.getTilePixelHeight(),
                        this.view.getTilePixelWidth(),
                        this.view.getTilePixelHeight());
                }, this.view));
        return this.cache.get(pos);
    }

    @Override
    public Renderer fogRenderer(Position pos) {
        if (this.cache.containsKey(pos)) {
            return this.cache.get(pos);
        }
        this.cache.put(pos, new SwingRenderer(g2d -> {
                g2d.setColor(Color.BLACK);
                g2d.fillRect(pos.x() * this.view.getTilePixelWidth(),
                        pos.y() * this.view.getTilePixelHeight(),
                        this.view.getTilePixelWidth(),
                        this.view.getTilePixelHeight());
                }, this.view));
        return this.cache.get(pos);
    }

    @Override
    public Renderer playerRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.BLUE);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer upstairRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer downstairRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer templeRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer chestRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.GRAY);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer goldRenderer(SackOfMoney obj) {
        return new SwingRenderer(g2d -> {
            if (obj.isHiddenInGround()) {
                g2d.setColor(Color.GREEN);
            } else {
                g2d.setColor(Color.YELLOW);
            }
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer beaconRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.CYAN);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer assassinRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer barbarianRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.RED);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer mageRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer monkRenderer(FloorElement obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monkRenderer'");
    }

    @Override
    public Renderer rogueRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
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

    @Override
    public Renderer swordRenderer(FloorElement obj) {
        return new SwingRenderer(g2d -> {
            g2d.setColor(Color.PINK);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }
    
}
