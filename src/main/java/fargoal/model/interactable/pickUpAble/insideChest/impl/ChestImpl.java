package fargoal.model.interactable.pickUpAble.insideChest.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.Utility;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * The implementation of the interface Chest. Inside the chest the player can found
 * an item, which is generated casually when the chest is opening.
 */
public class ChestImpl implements Interactable {

    final static int N_CHEST_ITEM = 15;
    final private Position position;
    private boolean open;
    private Renderer renderer;

    /**
     * The constructor of thi class. It set all the field of the class.
     * @param position - the position of the chest
     * @param renderFactory - 
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
            if (num == 0) {
                Spell item;
                item = new ChestItemFactoryImpl().generateDriftSpell(floorManager);
                item.store(floorManager);
            } else if (num == 1) {
                Spell item;
                item = new ChestItemFactoryImpl().generateInvisibilitySpell(floorManager);
                item.store(floorManager);
            } else if (num == 2) {
                Spell item;
                item = new ChestItemFactoryImpl().generateLightSpell(floorManager);
                item.store(floorManager);
            } else if (num == 3) {
                Spell item;
                item = new ChestItemFactoryImpl().generateRegenerationSpell(floorManager);
                item.store(floorManager);
            } else if (num == 4) {
                Spell item;
                item = new ChestItemFactoryImpl().generateShieldSpell(floorManager);
                item.store(floorManager);
            } else if (num == 5) {
                Spell item;
                item = new ChestItemFactoryImpl().generateTeleportSpell(floorManager);
                item.store(floorManager);
            } else if (num == 6) {
                new ChestItemFactoryImpl().generateCeilingTrap(floorManager);
            } else if (num == 7) {
                new ChestItemFactoryImpl().generateExplosion(floorManager);
            } else if (num == 8) {
                new ChestItemFactoryImpl().generatePit(floorManager);
            } else if (num == 9) {
                new ChestItemFactoryImpl().generateTeleport(floorManager);
            } else if (num == 10) {
                Utility item;
                item = new ChestItemFactoryImpl().generateBeacon(floorManager);
                item.store(floorManager);
            } else if (num == 11) {
                Utility item;
                item = new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager);
                item.store(floorManager);
            } else if (num == 12) {
                Utility item;
                item = new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager);
                item.store(floorManager);
            } else if (num == 13) {
                Utility item;
                item = new ChestItemFactoryImpl().generateHealingPotion(floorManager);
                item.store(floorManager);
            } else if (num == 14) {
                Utility item;
                item = new ChestItemFactoryImpl().generateMap(floorManager);
                item.store(floorManager);
            } else {
                Utility item;
                item = new ChestItemFactoryImpl().generateMagicSack(floorManager);
                item.store(floorManager);
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
    }
    
}
