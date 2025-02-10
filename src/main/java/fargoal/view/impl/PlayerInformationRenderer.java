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
            if (floorManager.getPlayer().getHealth().getCurrentHealth() > 7) {
                g2d.setColor(Color.GREEN);
            } else if (floorManager.getPlayer().getHealth().getCurrentHealth() > 1) {
                g2d.setColor(Color.ORANGE);
            } else {
                g2d.setColor(Color.RED);
            }
            g2d.setFont(new Font("Arial", Font.BOLD, swing.getFrame().getBounds().height * 3 / 110));
            g2d.drawString("HP: " 
                    + floorManager.getPlayer().getHealth().getCurrentHealth() 
                    + "/" 
                    + floorManager.getPlayer().getHealth().getMaxHealth(), 
                    swing.getEventPanel().getBounds().width / 6, 
                    swing.getEventPanel().getBounds().height * 3 / 5);
            g2d.setColor(Color.YELLOW);
            g2d.drawString("GOLD: " + floorManager.getPlayer().getCurrentGold(), 
                    swing.getEventPanel().getBounds().width / 2,
                    swing.getEventPanel().getBounds().height * 3 / 5);
        }, view);
        this.rendererBottom = new SwingRendererBottom(g2d -> {
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, swing.getInformationPanel().getBounds().height * 1 / 10));
            g2d.drawString("EXPERIENCE  " + floorManager.getPlayer().getExperiencePoints(),
                    swing.getInformationPanel().getBounds().width * 2 / 130,
                    swing.getInformationPanel().getBounds().height * 15 / 55);
            g2d.drawString("LEVEL  " + floorManager.getPlayer().getLevel(),
                    swing.getInformationPanel().getBounds().width * 2 / 130,
                    swing.getInformationPanel().getBounds().height * 30 / 55);
            g2d.drawString("SKILL  " + floorManager.getPlayer().getSkill(),
                    swing.getInformationPanel().getBounds().width * 2 / 130,
                    swing.getInformationPanel().getBounds().height * 45 / 55);
        }, view);
    }
    
}
