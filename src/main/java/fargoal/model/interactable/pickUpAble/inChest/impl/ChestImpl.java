package fargoal.model.interactable.pickUpAble.inChest.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * The implementation of the interface Chest.
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
        ChestItem item = null;
        if (this.position.equals(floorManager.getPlayer().getPosition())) {
            int num = new Random().nextInt(N_CHEST_ITEM);
            if (num == 0) {
                item = new ChestItemFactoryImpl().generateDriftSpell(floorManager, this.position);
            } else if (num == 1) {
                item = new ChestItemFactoryImpl().generateInvisibilitySpell(floorManager, this.position);
            } else if (num == 2) {
                item = new ChestItemFactoryImpl().generateLightSpell(floorManager, this.position);
            } else if (num == 3) {
                item = new ChestItemFactoryImpl().generateRegenerationSpell(floorManager, this.position);
            } else if (num == 4) {
                item = new ChestItemFactoryImpl().generateShieldSpell(floorManager, this.position);
            } else if (num == 5) {
                item = new ChestItemFactoryImpl().generateTeleportSpell(floorManager, this.position);
            } else if (num == 6) {
                item = new ChestItemFactoryImpl().generateCeilingTrap(floorManager, this.position);
            } else if (num == 7) {
                item = new ChestItemFactoryImpl().generateExplosion(floorManager, this.position);
            } else if (num == 8) {
                item = new ChestItemFactoryImpl().generatePit(floorManager, this.position);
            } else if (num == 9) {
                item = new ChestItemFactoryImpl().generateTeleport(floorManager, this.position);
            } else if (num == 10) {
                item = new ChestItemFactoryImpl().generateBeacon(floorManager, this.position);
            } else if (num == 11) {
                item = new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager, this.position);
            } else if (num == 12) {
                item = new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager, this.position);
            } else if (num == 13) {
                item = new ChestItemFactoryImpl().generateHealingPotion(floorManager, this.position);
            } else if (num == 14) {
                item = new ChestItemFactoryImpl().generateMap(floorManager, this.position);
            } else {
                item = new ChestItemFactoryImpl().generateMagicSack(floorManager, this.position);
            }
            this.open = true;
        }
        return item;
    }

    /**
     * Getter for the field renderer.
     * @return the renderer.
     */
    public Renderer getRenderer() {
        return this.renderer;
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
