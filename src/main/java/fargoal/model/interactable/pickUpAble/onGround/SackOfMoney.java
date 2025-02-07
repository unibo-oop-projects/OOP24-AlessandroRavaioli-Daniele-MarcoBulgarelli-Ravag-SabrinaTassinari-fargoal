package fargoal.model.interactable.pickUpAble.onGround;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;
import fargoal.view.api.Renderer;

/**
 * A class that implement the sack of money the player can find in the dungeon.
 */
public class SackOfMoney implements Interactable{

    final private Position position;
    private boolean hiddenInGround;
    private int goldInSack;
    private Renderer renderer;

    /**
     * The constructor of the class. The position of the sack is the parameter 
     * and the sack is not hidden in the ground in the beginning. In this constructor a certain 
     * amount of money is put in the sack. 
     * @param position - the position of the sack of money.
     */
    public SackOfMoney(final Position position, final RenderFactory renderFactory) {
        this.position = position;
        this.hiddenInGround = false;
        this.goldInSack = this.generateAmountOfMoney();
        this.setRender(renderFactory.goldRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /** {@inheritDoc} */
    public boolean isHiddenInGround() {
        return this.hiddenInGround;
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "SACK OF GOLD";
    }

    /** {@inheritDoc} */
    @Override
    public Interactable interact(FloorManager floorManager) {
        if (this.position.equals(floorManager.getPlayer().getPosition())) {
            this.goldInSack = floorManager.getPlayer().getPlayerGold().addGold(this.goldInSack);
            if(this.goldInSack > 0) {
                this.hiddenInGround = true;
            }
        }
        return this;
    }

    /**
     * This private method calculates the amount of money the sack contains.
     * @return the amount of money the sack contains.
     */
    private int generateAmountOfMoney(){
        return new Random().nextInt(130) + 20;
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
