package fargoal.view.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.model.entity.player.api.Inventory;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class InventoryInformationRenderer implements Renderer{

    private SwingRendererBottom renderer;
    private SwingView view;

    public InventoryInformationRenderer(View view, Inventory inventory) {
        this.view = (SwingView) view;
    }

    @Override
    public void render() {
        renderer.render();
    }
    
    public void setRenderer(Inventory inventory) {
        renderer = new SwingRendererBottom(g2d -> {
            g2d.setFont(new Font("Arial", Font.BOLD, 15));
            g2d.setColor(Color.WHITE);
            g2d.drawString("ENCHANTED SWORD+ " + inventory.getEnchantedWeapons(),
                    this.view.getFrame().getBounds().width / 4 + 15,
                    this.view.getFrame().getBounds().height * 94 / 110);
        },view);
    } 
}
