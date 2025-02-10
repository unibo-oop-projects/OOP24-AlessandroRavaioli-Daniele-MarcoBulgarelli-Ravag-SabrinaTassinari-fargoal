package fargoal.view.impl;

import java.awt.Color;

import fargoal.commons.api.Position;
import fargoal.model.commons.FloorElement;
import fargoal.model.interactable.pickUpAble.insideChest.impl.ChestImpl;
import fargoal.model.interactable.pickUpAble.onGround.SackOfMoney;
import fargoal.view.api.ImageHolder;
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
        return new SwingRendererMiddle(g2d -> {
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(pos.x() * this.view.getTilePixelWidth(),
                        pos.y() * this.view.getTilePixelHeight(),
                        this.view.getTilePixelWidth(),
                        this.view.getTilePixelHeight());
                }, this.view);
    }

    @Override
    public Renderer tileRenderer(Position pos) {
        return new SwingRendererMiddle(g2d -> {
                g2d.setColor(Color.WHITE);
                g2d.fillRect(pos.x() * this.view.getTilePixelWidth(),
                        pos.y() * this.view.getTilePixelHeight(),
                        this.view.getTilePixelWidth(),
                        this.view.getTilePixelHeight());
                }, this.view);
    }

    @Override
    public Renderer playerRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.BLUE);
            g2d.drawImage(ImageHolder.player(),
                    obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight(),
                    null);
            // g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
            //         obj.getPosition().y() * this.view.getTilePixelHeight(),
            //         this.view.getTilePixelWidth(),
            //         this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer upstairRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer downstairRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer templeRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.MAGENTA);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer chestRenderer(ChestImpl obj) {
        return new SwingRendererMiddle(g2d -> {
            if (obj.isOpen()) {
                g2d.setColor(Color.WHITE);
            } else {
                g2d.setColor(Color.GRAY);
            }
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer goldRenderer(SackOfMoney obj) {
        return new SwingRendererMiddle(g2d -> {
            if (obj.isOpen()) {
                if (obj.isHiddenInGround()) {
                    g2d.setColor(Color.GREEN);
                } else {
                    g2d.setColor(Color.WHITE);
                }
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
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.CYAN);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer assassinRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer barbarianRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.RED);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer mageRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer monkRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.CYAN);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer rogueRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer spiderRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer warlordRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.PINK);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }

    @Override
    public Renderer swordRenderer(FloorElement obj) {
        return new SwingRendererMiddle(g2d -> {
            g2d.setColor(Color.PINK);
            g2d.fillRect(obj.getPosition().x() * this.view.getTilePixelWidth(),
                    obj.getPosition().y() * this.view.getTilePixelHeight(),
                    this.view.getTilePixelWidth(),
                    this.view.getTilePixelHeight());
        }, this.view);
    }
    
}
