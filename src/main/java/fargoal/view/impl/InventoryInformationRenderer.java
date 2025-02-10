package fargoal.view.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.model.entity.player.api.Inventory;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class InventoryInformationRenderer implements Renderer{

    private SwingRendererBottom renderer;
    private SwingView view;

    public InventoryInformationRenderer(View view) {
        this.view = (SwingView) view;
    }

    @Override
    public void render() {
        renderer.render();
    }
    
    public void setRenderer(Inventory inventory) {
        renderer = new SwingRendererBottom(g2d -> {
            g2d.setFont(new Font("Arial", Font.BOLD, this.view.getInformationPanel().getBounds().height * 1/10));
            g2d.setColor(Color.WHITE);
            g2d.drawString("ENCHANTED SWORD+ " + inventory.getEnchantedWeapons().getNumberInInventory(),
                    this.view.getInformationPanel().getBounds().width / 4,
                    this.view.getInformationPanel().getBounds().height * 2/6);
            g2d.drawString("BEACONS " + inventory.getBeacons().getNumberInInventory(),
                    this.view.getInformationPanel().getBounds().width / 2,
                    this.view.getInformationPanel().getBounds().height * 1 / 6);
            g2d.drawString("MAGIC SACKS " + inventory.getMagicSacks().getNumberInInventory(),
                    this.view.getInformationPanel().getBounds().width / 2,
                    this.view.getInformationPanel().getBounds().height * 3 / 6);
            g2d.drawString("HEALING POTIONS " + inventory.getHealingPotions().getNumberInInventory(),
                    this.view.getInformationPanel().getBounds().width / 2,
                    this.view.getInformationPanel().getBounds().height * 5 / 6);
        },view);
    } 
}
