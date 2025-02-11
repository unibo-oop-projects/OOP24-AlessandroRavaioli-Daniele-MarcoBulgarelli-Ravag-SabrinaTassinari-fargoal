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
     * Getter for the gold donated to the temple.
     * 
     * @return the gold donated to the temple
     */
    Integer getGoldDonated();

    /**
     * Setter for the maximum gold capacity.
     * 
     * @param amount - the maximum gold the player can carry now.
     */
    void setMaxCapacity(Integer amount);

    /**
     * Setter for the gold to donate to the temple.
     * 
     * @param amount - the amount to donate to the temple
     */
    void setGoldDonated(Integer amount);

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

    /**
     * Decreases the current gold amount.
     * 
     * @param amount - the amount of gold to remove
     */
    void removeGold(Integer amount);
}
