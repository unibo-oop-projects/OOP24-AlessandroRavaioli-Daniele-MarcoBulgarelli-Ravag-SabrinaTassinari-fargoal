package fargoal.model.interactable.pickUpAble.insideChest.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.FoundTrapEvent;
import fargoal.model.events.impl.PickUpNewItemEvent;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * The implementation of the interface Chest. Inside the chest the player can found
 * an item, which is generated casually when the chest is opening.
 */
public class ChestImpl implements Interactable {

    final static int N_CHEST_ITEM = 14;
    final private Position position;
    private boolean open;
    private Renderer renderer;

    /**
     * The constructor of thi class. It set all the field of the class.
     * @param position - the position of the chest
     * @param renderFactory - a factory to create the renderer of all the elements of the floor.
     */
    public ChestImpl(final Position position, final RenderFactory renderFactory) {
        this.position = position;
        this.open = false;
        this.setRender(renderFactory.chestRenderer(this));
    }

    /**
     * With this method it can be checked if the chest is open or not. 
     * @return a boolean that indicate if the chest is open or not.
     */
    public boolean isOpen() {
        return this.open;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }
    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "CHEST";
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        if (this.position.equals(floorManager.getPlayer().getPosition())) {
            int num = new Random().nextInt(N_CHEST_ITEM);
            if (num >= 0 && num <= 5 || num >= 11) {
                Spell spell;
                if (num == 0) {
                    spell = new ChestItemFactoryImpl().generateDriftSpell(floorManager);
                    floorManager.getPlayer().getInventory().getDriftSpell().store(floorManager);
                } else if (num == 1) {
                    spell = new ChestItemFactoryImpl().generateInvisibilitySpell(floorManager);
                    floorManager.getPlayer().getInventory().getInvisibilitySpell().store(floorManager);
                } else if (num == 2) {
                    spell = new ChestItemFactoryImpl().generateLightSpell(floorManager);
                    floorManager.getPlayer().getInventory().getLightSpell().store(floorManager);
                } else if (num == 3) {
                    spell = new ChestItemFactoryImpl().generateRegenerationSpell(floorManager);
                    floorManager.getPlayer().getInventory().getRegenerationSpell().store(floorManager);
                } else if (num == 4) {
                    spell = new ChestItemFactoryImpl().generateShieldSpell(floorManager);
                    floorManager.getPlayer().getInventory().getShieldSpell().store(floorManager);
                } else {
                    spell = new ChestItemFactoryImpl().generateTeleportSpell(floorManager);
                    floorManager.getPlayer().getInventory().getTeleportSpell().store(floorManager);
                } 
                floorManager.notifyFloorEvent(new PickUpNewItemEvent(spell));
            } else if (num >= 6 && num <= 9) {
                ChestItem trap;
                if (num == 6) {
                    trap = new ChestItemFactoryImpl().generateCeilingTrap(floorManager);
                } else if (num == 7) {
                    trap = new ChestItemFactoryImpl().generateExplosion(floorManager);
                } else if (num == 8) {
                    trap = new ChestItemFactoryImpl().generatePit(floorManager);
                } else {
                    trap = new ChestItemFactoryImpl().generateTeleport(floorManager);
                } 
                floorManager.notifyFloorEvent(new FoundTrapEvent(trap));
            } else if (num >= 11 ) {
                Utility item;
                if (num == 10) {
                    item = new ChestItemFactoryImpl().generateBeacon(floorManager);
                    floorManager.getPlayer().getInventory().getBeacons().store(floorManager);
                } else if (num == 11) {
                    item = new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager);
                    floorManager.getPlayer().getInventory().getEnchantedWeapons().store(floorManager);
                } else if (num == 12) {
                    item = new ChestItemFactoryImpl().generateHealingPotion(floorManager);
                    floorManager.getPlayer().getInventory().getHealingPotions().store(floorManager);
                } else if (num == 13) {
                    item = new ChestItemFactoryImpl().generateMap(floorManager);
                    floorManager.getPlayer().getInventory().getListOfMaps().store(floorManager);
                } else {
                    item = new ChestItemFactoryImpl().generateMagicSack(floorManager);
                    floorManager.getPlayer().getInventory().getMagicSacks().store(floorManager);
                }
                floorManager.notifyFloorEvent(new PickUpNewItemEvent(item));
            }
            this.open = true;
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public void render() {
        this.renderer.render();
    }

    /**
     * Setter for field renderer.
     * @param renderer - the new renderer.
     */
    public void setRender(final Renderer renderer) {
        this.renderer = renderer;
    }

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
        if (this.isOpen()) {
            floorManager.getAllElements().remove(this);
        }
    }
    
}
