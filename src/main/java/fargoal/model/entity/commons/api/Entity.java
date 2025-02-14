package fargoal.model.entity.commons.api;

import fargoal.model.commons.FloorElement;

/**
 * An Entity represent a FloorElement that can move, attack and be damaged.
 */
public interface Entity extends FloorElement {

    void increaseHealth(Integer amount);

    void decreaseHealth(Integer amount);

    Integer getCurrentHealth();

    Integer getMaxHealth();

    void setHealth(Integer amount);

    boolean isHealthy();

    /**
     * Return the skill of the FloorElement selected.
     * 
     * @return the skill
     */
    Integer getSkill();

    /**
     * This method is used to check wether the Entity is dead or not.
     * 
     * @return true if player is dead, false otherwise.
     */
    boolean isDead();
}
