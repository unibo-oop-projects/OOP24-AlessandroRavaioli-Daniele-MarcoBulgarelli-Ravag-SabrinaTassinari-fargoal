package fargoal.model.interactable.pickUpAble.onGround;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.api.Interactable;
import fargoal.model.manager.api.FloorManager;

/**
 * A class that implement the sack of money the player can find in the dungeon.
 */
public class SackOfMoney implements Interactable{

    final private Position position;
    private boolean hiddenInGround;
    private int goldInSack;

    /**
     * The constructor of the class. The position of the sack is the parameter 
     * and the sack is not hidden in the ground in the beginning. In this constructor a certain 
     * amount of money is put in the sack. 
     * @param position - the position of the sack of money.
     */
    public SackOfMoney(final Position position) {
        this.position = position;
        this.hiddenInGround = false;
        this.goldInSack = this.generateAmountOfMoney();
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
        this.goldInSack = floorManager.getPlayer().getPlayerGold().addGold(this.goldInSack);
        if(this.goldInSack > 0) {
            this.hiddenInGround = true;
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

    /** {@inheritDoc} */
    @Override
    public void update(FloorManager floorManager) {
    }
    
}
