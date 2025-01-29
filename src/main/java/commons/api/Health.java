package commons.api;

public interface Health {
    
    /*
     * Getter for the current health.
     * @return current health.
     */
    public float getCurrentHealth();

    /*
     * Getter for the max health of the floor.
     * @return max health
     */
    public float getMaxHealth();

    /*
     * Decreases the current health value.
     * @param amount to subtract to the current health value.
     */
    public void decreaseHealth(float amount);

    /*
     * Increases the current health value.
     * @param amount to add to the current health value.
     */
    public void increaseHealth(float amount);
}
