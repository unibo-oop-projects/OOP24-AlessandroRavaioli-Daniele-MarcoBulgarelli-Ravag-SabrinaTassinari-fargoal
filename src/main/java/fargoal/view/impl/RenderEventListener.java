package fargoal.view.impl;

import java.awt.Color;
import java.awt.Font;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.events.api.FloorEventListener;
import fargoal.model.events.impl.FoundTrapEvent;
import fargoal.model.events.impl.MonsterEncounterEvent;
import fargoal.model.events.impl.MonsterStealGoldEvent;
import fargoal.model.events.impl.MonsterStealSpellEvent;
import fargoal.model.events.impl.PickUpGoldEvent;
import fargoal.model.events.impl.PickUpNewItemEvent;
import fargoal.model.events.impl.PlayerActionEvent;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.events.impl.WalkOverEvent;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class RenderEventListener implements FloorEventListener, Renderer{

    private String text;
    private SwingRendererTop renderer;

    public RenderEventListener(View view) {
        this.text = " ";
        SwingView swing = (SwingView)view;
        renderer = new SwingRendererTop(g2d -> {
            g2d.setFont(new Font("Arial", Font.BOLD, swing.getFrame().getBounds().height * 3 / 110));
            g2d.setColor(Color.WHITE);
            g2d.drawString(this.text, 
                    swing.getEventPanel().getBounds().width / 50,
                    swing.getEventPanel().getBounds().height * 12 / 55); 
        }, view);
    }

    @Override
    public void notifyEvent(FloorEvent floorEvent) {
        if (floorEvent instanceof MonsterEncounterEvent) {
            MonsterEncounterEvent ev = (MonsterEncounterEvent) floorEvent;
            text = "A " + ev.monsterEncountered().getTag();
        } else if (floorEvent instanceof FoundTrapEvent) {
            FoundTrapEvent ev = (FoundTrapEvent) floorEvent;
            text = ev.TypeOfTrap().getChestItemName();
        } else if (floorEvent instanceof PickUpGoldEvent) {
            PickUpGoldEvent ev = (PickUpGoldEvent) floorEvent;
            text = "Found " + ev.GoldFound() + " gold";
        } else if (floorEvent instanceof PickUpNewItemEvent) {
            PickUpNewItemEvent ev = (PickUpNewItemEvent) floorEvent;
            text = "Found " + ev.PickedUpWhat().getChestItemName();
        } else if (floorEvent instanceof ReceiveAttackEvent) {
            ReceiveAttackEvent ev = (ReceiveAttackEvent) floorEvent;
            text = "Attacked by " + ev.AttackedFrom().getTag();
        } else if (floorEvent instanceof WalkOverEvent) {
            WalkOverEvent ev = (WalkOverEvent) floorEvent;
            text = ev.getOnWhat().getTag();
        } else if (floorEvent instanceof MonsterStealSpellEvent) {
            MonsterStealSpellEvent ev = (MonsterStealSpellEvent) floorEvent;
            text = ev.WhoStole().getTag() + " stole " + ev.WhatMonsterStole().getChestItemName();
        } else if (floorEvent instanceof MonsterStealGoldEvent) {
            MonsterStealGoldEvent ev = (MonsterStealGoldEvent) floorEvent;
            text = ev.WhoStole().getTag() + " stole " + ev.HowMuchGold() + " gold coins";
        } else if (floorEvent instanceof PlayerActionEvent) {
            PlayerActionEvent ev = (PlayerActionEvent) floorEvent;
            text = ev.WhatPlayerUsed().getChestItemName() + " has benn used";
        }
    }

    @Override
    public void render() {
        this.renderer.render();
    }
    
}
