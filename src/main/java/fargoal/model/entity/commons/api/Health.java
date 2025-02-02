package fargoal.model.entity.commons.api;

/**
 * An interface to modify, set or get the health of a specified FloorElement.
 */
public interface Health {
    /**
     * Getter for the current health.
     * 
     * @return current health.
     */
    Integer getCurrentHealth();

    /**
     * Getter for the max health of the floor.
     * 
     * @return max health
     */
    Integer getMaxHealth();

    /**
     * Decreases the current health value.
     * 
     * @param amount to subtract to the current health value.
     */
    void decreaseHealth(Integer amount);

    /**
     * Increases the current health value.
     * 
     * @param amount to add to the current health value.
     */
    void increaseHealth(Integer amount);

    /**
     * Set the current health value to the max health value.
     */
    void setToMaxHealth();
}
