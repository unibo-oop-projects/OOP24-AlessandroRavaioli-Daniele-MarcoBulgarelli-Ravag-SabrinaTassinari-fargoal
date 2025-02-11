package fargoal.model.interactable.pickUpAble.onGround;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.events.impl.PickUpGoldEvent;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * A class that implement the sack of money the player can find in the dungeon.
 */
public class SackOfMoney implements Interactable {

    private static final int MAX_GOLD = 130;
    private static final int GOLD_TO_ADD = 20;
    private final Position position;
    private boolean hiddenInGround;
    private boolean open;
    private int goldInSack;
    private Renderer renderer;

    /**
     * The constructor of the class. The position of the sack is the parameter 
     * and the sack is not hidden in the ground in the beginning. In this constructor a certain 
     * amount of money is put in the sack. 
     * @param position - the position of the sack of money.
     * @param renderFactory - the factory from which the renderer needed is taken.
     */
    public SackOfMoney(final Position position, final RenderFactory renderFactory) {
        this.position = position;
        this.hiddenInGround = false;
        this.open = false;
        this.goldInSack = this.generateAmountOfMoney();
        this.setRender(renderFactory.goldRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** 
     * Getter for the field isHiddenInGround.
     * @return true if the sackOfGold is hidden in the ground, false otherwise.
     */
    public boolean isHiddenInGround() {
        return this.hiddenInGround;
    }

    /**
     * Getter for the field open.
     * @return true if the player opened the sack of gold.
     */
    public boolean isOpen() {
        return this.open;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "SACK OF GOLD";
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(final FloorManager floorManager) {
        if (this.position.equals(floorManager.getPlayer().getPosition())) {
            floorManager.notifyFloorEvent(new PickUpGoldEvent(this.goldInSack));
            this.open = true;
            this.goldInSack = floorManager.getPlayer().getPlayerGold().addGold(this.goldInSack);
            if (this.goldInSack > 0) {
                this.hiddenInGround = true;
            } else {
                this.hiddenInGround = false;
            }
        }
        return this;
    }

    /**
     * This private method calculates the amount of money the sack contains.
     * @return the amount of money the sack contains.
     */
    private int generateAmountOfMoney() {
        return new Random().nextInt(MAX_GOLD) + GOLD_TO_ADD;
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
    public void update(final FloorManager floorManager) {
        if (this.isOpen()) {
            if (!this.isHiddenInGround()) {
                floorManager.getAllElements().remove(this);
            }
        }
    }

}
