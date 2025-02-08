package fargoal.model.interactable.pickUpAble.insideChest.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
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
        if (this.position.equals(floorManager.getPlayer().getPosition())) {
            int num = new Random().nextInt(N_CHEST_ITEM);
            if (num == 0) {
                new ChestItemFactoryImpl().generateDriftSpell(floorManager, this.position);
            } else if (num == 1) {
                new ChestItemFactoryImpl().generateInvisibilitySpell(floorManager, this.position);
            } else if (num == 2) {
                new ChestItemFactoryImpl().generateLightSpell(floorManager, this.position);
            } else if (num == 3) {
                new ChestItemFactoryImpl().generateRegenerationSpell(floorManager, this.position);
            } else if (num == 4) {
                new ChestItemFactoryImpl().generateShieldSpell(floorManager, this.position);
            } else if (num == 5) {
                new ChestItemFactoryImpl().generateTeleportSpell(floorManager, this.position);
            } else if (num == 6) {
                new ChestItemFactoryImpl().generateCeilingTrap(floorManager, this.position);
            } else if (num == 7) {
                new ChestItemFactoryImpl().generateExplosion(floorManager, this.position);
            } else if (num == 8) {
                new ChestItemFactoryImpl().generatePit(floorManager, this.position);
            } else if (num == 9) {
                new ChestItemFactoryImpl().generateTeleport(floorManager, this.position);
            } else if (num == 10) {
                new ChestItemFactoryImpl().generateBeacon(floorManager, this.position);
            } else if (num == 11) {
                new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager, this.position);
            } else if (num == 12) {
                new ChestItemFactoryImpl().generateEnchantedWeapon(floorManager, this.position);
            } else if (num == 13) {
                new ChestItemFactoryImpl().generateHealingPotion(floorManager, this.position);
            } else if (num == 14) {
                new ChestItemFactoryImpl().generateMap(floorManager, this.position);
            } else {
                new ChestItemFactoryImpl().generateMagicSack(floorManager, this.position);
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
