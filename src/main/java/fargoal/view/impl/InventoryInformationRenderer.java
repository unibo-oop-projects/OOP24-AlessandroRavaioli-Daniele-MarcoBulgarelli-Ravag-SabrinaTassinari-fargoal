package fargoal.view.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.model.entity.player.api.Inventory;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.SpellType;
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
            g2d.setFont(new Font("Arial", Font.BOLD, this.view.getInformationPanel().getBounds().height * 1 / 10));
            g2d.setColor(Color.WHITE);
            g2d.drawString("ENCHANTED SWORD+",
                    this.view.getInformationPanel().getBounds().width * 3 / 16,
                    this.view.getInformationPanel().getBounds().height * 2 / 6);
            g2d.drawString(String.valueOf(inventory.getEnchantedWeapons().getNumberInInventory()), 
                    this.view.getInformationPanel().getBounds().width * 7 / 16, 
                    this.view.getInformationPanel().getBounds().height * 2 / 6);
            g2d.drawString("SLAIN FOES", 
                    this.view.getInformationPanel().getBounds().width * 3 / 16, 
                    this.view.getInformationPanel().getBounds().height / 6);
            g2d.drawString("DUNGEON LEVEL", 
                    this.view.getInformationPanel().getBounds().width * 3 / 16, 
                    this.view.getInformationPanel().getBounds().height * 4 / 6);
            g2d.drawString("DEEPEST DESCENT", 
                    this.view.getInformationPanel().getBounds().width * 3 / 16, 
                    this.view.getInformationPanel().getBounds().height * 5 / 6);
            g2d.drawString("BEACONS ",
                    this.view.getInformationPanel().getBounds().width / 2,
                    this.view.getInformationPanel().getBounds().height / 6);
            g2d.drawString(String.valueOf(inventory.getBeacons().getNumberInInventory()), 
                    this.view.getInformationPanel().getBounds().width * 23 / 32, 
                    this.view.getInformationPanel().getBounds().height / 6);
            g2d.drawString("MAGIC SACKS ",
                    this.view.getInformationPanel().getBounds().width / 2,
                    this.view.getInformationPanel().getBounds().height * 3 / 6);
            g2d.drawString(String.valueOf(inventory.getMagicSacks().getNumberInInventory()), 
                    this.view.getInformationPanel().getBounds().width * 23 / 32, 
                    this.view.getInformationPanel().getBounds().height * 3 / 6);
            g2d.drawString("HEALING POTIONS ",
                    this.view.getInformationPanel().getBounds().width / 2,
                    this.view.getInformationPanel().getBounds().height * 5 / 6);
            g2d.drawString(String.valueOf(inventory.getHealingPotions().getNumberInInventory()), 
                    this.view.getInformationPanel().getBounds().width * 23 / 32, 
                    this.view.getInformationPanel().getBounds().height * 5 / 6);
            if (inventory.getInvisibilitySpell().getNumberInInventory() > 0 && !inventory.getSpellCasted().get(SpellType.INVISIBILITY.getName())) {
                g2d.setColor(Color.WHITE);
            } else if (inventory.getSpellCasted().get(SpellType.INVISIBILITY.getName())) {
                g2d.setColor(Color.CYAN);
            } else if (inventory.getInvisibilitySpell().getNumberInInventory() <= 0 && !inventory.getSpellCasted().get(SpellType.INVISIBILITY.getName())) {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString("INVISIBILITY", 
                    this.view.getInformationPanel().getBounds().width * 3 / 4, 
                    this.view.getInformationPanel().getBounds().height * 3 / 24);
            g2d.drawString(String.valueOf(inventory.getInvisibilitySpell().getNumberInInventory()),
                    this.view.getInformationPanel().getBounds().width * 31 / 32, 
                    this.view.getInformationPanel().getBounds().height * 3 / 24);
            if (inventory.getRegenerationSpell().getNumberInInventory() > 0 && !inventory.getSpellCasted().get(SpellType.REGENERATION.getName())) {
                g2d.setColor(Color.WHITE);
            } else if (inventory.getSpellCasted().get(SpellType.REGENERATION.getName())) {
                g2d.setColor(Color.CYAN);
            } else if (inventory.getInvisibilitySpell().getNumberInInventory() <= 0 && !inventory.getSpellCasted().get(SpellType.REGENERATION.getName())) {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString("REGENERATION", 
                    this.view.getInformationPanel().getBounds().width * 3 / 4, 
                    this.view.getInformationPanel().getBounds().height * 7 / 24);
            g2d.drawString(String.valueOf(inventory.getRegenerationSpell().getNumberInInventory()),
                    this.view.getInformationPanel().getBounds().width * 31 / 32, 
                    this.view.getInformationPanel().getBounds().height * 7 / 24);
            if (inventory.getTeleportSpell().getNumberInInventory() > 0) {
                g2d.setColor(Color.WHITE);
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString("TELEPORT", 
                    this.view.getInformationPanel().getBounds().width * 3 / 4, 
                    this.view.getInformationPanel().getBounds().height * 11 / 24);
            g2d.drawString(String.valueOf(inventory.getTeleportSpell().getNumberInInventory()),
                    this.view.getInformationPanel().getBounds().width * 31 / 32, 
                    this.view.getInformationPanel().getBounds().height * 11 / 24);
            if (inventory.getShieldSpell().getNumberInInventory() > 0 && !inventory.getSpellCasted().get(SpellType.SHIELD.getName())) {
                g2d.setColor(Color.WHITE);
            } else if (inventory.getSpellCasted().get(SpellType.SHIELD.getName())) {
                g2d.setColor(Color.CYAN);
            } else if (inventory.getInvisibilitySpell().getNumberInInventory() <= 0 && !inventory.getSpellCasted().get(SpellType.SHIELD.getName())) {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString("SHIELD", 
                    this.view.getInformationPanel().getBounds().width * 3 / 4, 
                    this.view.getInformationPanel().getBounds().height * 15 / 24);
            g2d.drawString(String.valueOf(inventory.getShieldSpell().getNumberInInventory()),
                    this.view.getInformationPanel().getBounds().width * 31 / 32, 
                    this.view.getInformationPanel().getBounds().height * 15 / 24);
            if (inventory.getLightSpell().getNumberInInventory() > 0 && !inventory.getSpellCasted().get(SpellType.LIGHT.getName())) {
                g2d.setColor(Color.WHITE);
            } else if (inventory.getSpellCasted().get(SpellType.LIGHT.getName())) {
                g2d.setColor(Color.CYAN);
            } else if (inventory.getInvisibilitySpell().getNumberInInventory() <= 0 && !inventory.getSpellCasted().get(SpellType.LIGHT.getName())) {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString("LIGHT", 
                    this.view.getInformationPanel().getBounds().width * 3 / 4, 
                    this.view.getInformationPanel().getBounds().height * 19 / 24);
            g2d.drawString(String.valueOf(inventory.getLightSpell().getNumberInInventory()),
                    this.view.getInformationPanel().getBounds().width * 31 / 32, 
                    this.view.getInformationPanel().getBounds().height * 19 / 24);
            if (inventory.getDriftSpell().getNumberInInventory() > 0 && !inventory.getSpellCasted().get(SpellType.DRIFT.getName())) {
                g2d.setColor(Color.WHITE);
            } else if (inventory.getSpellCasted().get(SpellType.DRIFT.getName())) {
                g2d.setColor(Color.CYAN);
            } else if (inventory.getInvisibilitySpell().getNumberInInventory() <= 0 && !inventory.getSpellCasted().get(SpellType.DRIFT.getName())) {
                g2d.setColor(Color.BLACK);
            }
            g2d.drawString("DRIFT", 
                    this.view.getInformationPanel().getBounds().width * 3 / 4, 
                    this.view.getInformationPanel().getBounds().height * 23 / 24);
            g2d.drawString(String.valueOf(inventory.getDriftSpell().getNumberInInventory()),
                    this.view.getInformationPanel().getBounds().width * 31 / 32, 
                    this.view.getInformationPanel().getBounds().height * 23 / 24);
        },view);
    } 
}
