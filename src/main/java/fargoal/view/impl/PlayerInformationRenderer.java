package fargoal.view.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class PlayerInformationRenderer implements Renderer{

    private SwingRendererBottom rendererBottom; 
    private SwingRendererTop rendererTop;
    private View view;

    public PlayerInformationRenderer(View view) {
        this.view = view;
    }

    @Override
    public void render() {
        rendererTop.render();
        rendererBottom.render();
    }

    public void setRender(FloorManager floorManager) {
        SwingView swing = (SwingView)view;
        this.rendererTop = new SwingRendererTop(g2d -> {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, swing.getFrame().getBounds().height * 3 / 110));
            g2d.drawString("HP: " + floorManager.getPlayer().getHealth().getCurrentHealth(), 
                    swing.getFrame().getBounds().width * 3 / 130, 
                    swing.getFrame().getBounds().height * 5 / 55);
            g2d.drawString("MAX HP: " + floorManager.getPlayer().getHealth().getMaxHealth(), 
                    swing.getFrame().getBounds().width * 8 / 65, 
                    swing.getFrame().getBounds().height * 5 / 55);
            g2d.drawString("GOLD: " + floorManager.getPlayer().getCurrentGold(), 
                    swing.getFrame().getBounds().width / 2,
                    swing.getFrame().getBounds().height * 5 / 55);
        }, view);
        this.rendererBottom = new SwingRendererBottom(g2d -> {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, swing.getFrame().getBounds().height * 3 / 110));
            g2d.drawString("EXPERIENCE: " + floorManager.getPlayer().getExperiencePoints(),
                    swing.getFrame().getBounds().width * 3 / 130, 
                    swing.getFrame().getBounds().height * 40 / 55);
            g2d.drawString("LEVEL: " + floorManager.getPlayer().getLevel(), 
                    swing.getFrame().getBounds().width * 3 / 130, 
                    swing.getFrame().getBounds().height * 45 / 55);
            g2d.drawString("SKILL: " + floorManager.getPlayer().getSkill(), 
                    swing.getFrame().getBounds().width * 3 / 150, 
                    swing.getFrame().getBounds().height * 50 / 55);
        }, view);
    }
    
}
