package model.entity.commons.api;

public interface Health {
    
    /*
     * Getter for the current health.
     * @return current health.
     */
    public Integer getCurrentHealth();

    /*
     * Getter for the max health of the floor.
     * @return max health
     */
    public Integer getMaxHealth();

    /*
     * Decreases the current health value.
     * @param amount to subtract to the current health value.
     */
    public void decreaseHealth(Integer amount);

    /*
     * Increases the current health value.
     * @param amount to add to the current health value.
     */
    public void increaseHealth(Integer amount);

    /*
     * Set the value of the current health value.
     * @param amount to set to the current health value.
     */
    public void setHealth(Integer amount);
}
