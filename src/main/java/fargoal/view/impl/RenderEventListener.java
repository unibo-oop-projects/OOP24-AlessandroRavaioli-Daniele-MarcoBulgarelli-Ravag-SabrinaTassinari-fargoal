package fargoal.view.impl;

import java.awt.Font;

import fargoal.model.events.api.FloorEvent;
import fargoal.model.events.api.FloorEventListener;
import fargoal.model.events.impl.FoundTrapEvent;
import fargoal.model.events.impl.MonsterEncounterEvent;
import fargoal.model.events.impl.PickUpGoldEvent;
import fargoal.model.events.impl.PickUpNewItemEvent;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.events.impl.WalkOverEvent;
import fargoal.view.api.Renderer;
import fargoal.view.api.View;

public class RenderEventListener implements FloorEventListener, Renderer{

    private String text;
    private SwingRendererTop renderer;

    public RenderEventListener(View view) {
        this.text = " ";
        renderer = new SwingRendererTop(g2d -> {
            g2d.setFont(new Font("Arial", Font.ITALIC, 15));
            g2d.drawString(this.text, 15, 15);
        }, view);
    }

    @Override
    public void notifyEvent(FloorEvent floorEvent) {
        if (floorEvent instanceof MonsterEncounterEvent) {
            MonsterEncounterEvent ev = (MonsterEncounterEvent) floorEvent;
            text = "A " + ev.monsterEncountered().getTag();
        } else if (floorEvent instanceof FoundTrapEvent) {
            FoundTrapEvent ev = (FoundTrapEvent) floorEvent;
            text = ev.TypeOfTrap().getTag();
        } else if (floorEvent instanceof PickUpGoldEvent) {
            PickUpGoldEvent ev = (PickUpGoldEvent) floorEvent;
            text = "Picked up " + ev.GoldFound() + " gold";
        } else if (floorEvent instanceof PickUpNewItemEvent) {
            PickUpNewItemEvent ev = (PickUpNewItemEvent) floorEvent;
            text = "Found " + ev.PickedUpWhat().getChestItemName();
        } else if (floorEvent instanceof ReceiveAttackEvent) {
            ReceiveAttackEvent ev = (ReceiveAttackEvent) floorEvent;
            text = "Attacked by " + ev.AttackedFrom().getTag();
        } else if (floorEvent instanceof WalkOverEvent) {
            WalkOverEvent ev = (WalkOverEvent) floorEvent;
            text = ev.getOnWhat().getTag();
        }
    }

    @Override
    public void render() {
        this.renderer.render();
    }
    
}
