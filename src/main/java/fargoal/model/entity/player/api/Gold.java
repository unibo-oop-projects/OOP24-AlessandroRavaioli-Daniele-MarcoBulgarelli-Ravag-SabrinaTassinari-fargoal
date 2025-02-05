package fargoal.model.entity.player.api;

/**
 * Interface to manage gold.
 */

public interface Gold {
    /**
     * Getter for current gold amount.
     * 
     * @return the current gold amount.
     */
    Integer getCurrentGold();

    /**
     * Getter for the maximum gold capacity.
     * 
     * @return the maximum amount of gold transportable.
     */
    Integer getMaxCapacity();

    /**
     * Sets current gold amount to 0.
     */
    void resetGold();

    /**
     * Increases the current gold amount.
     * If the amount to add exceeds the max capacity,
     * only the amount needed to reach the limit is added
     * and the leftover gold is returned.
     * 
     * @param amount - the amount of gold to add.
     * 
     * @return the leftover gold amount that could not be added.
     */
    Integer addGold(Integer amount);
}
