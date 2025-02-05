package fargoal.model.entity.player.impl;

import fargoal.model.entity.player.api.Gold;

/**
 * Gold class, it manages player's gold.
 */
public class GoldImpl implements Gold{

    private static final int INITIAL_GOLD_MAX_CAPACITY = 100;
    private Integer currentGold;
    private Integer maxCapacity;

    /**
     * Creates an instance of Gold, the initial gold is 
     * set to 0.
     */
    public GoldImpl(){
        this.currentGold = 0;
        this.maxCapacity = INITIAL_GOLD_MAX_CAPACITY;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getCurrentGold() {
        return this.currentGold;
    }

    /**{@inheritDoc} */
    @Override
    public Integer getMaxCapacity() {
        return this.maxCapacity;
    }

    /**{@inheritDoc} */
    @Override
    public Integer addGold(Integer amount) {
        if(amount == null || amount < 0) {
            throw new IllegalArgumentException("You cannot add a negative or null amount");
        }

        int spaceAvailable = this.getMaxCapacity() - this.getCurrentGold();
        int goldToAdd = Math.min(amount, spaceAvailable);
        this.currentGold = this.currentGold + goldToAdd;

        return amount - goldToAdd;
    }

    /**{@inheritDoc} */
    @Override
    public void resetGold() {
        this.currentGold = 0;
    }
    
}
