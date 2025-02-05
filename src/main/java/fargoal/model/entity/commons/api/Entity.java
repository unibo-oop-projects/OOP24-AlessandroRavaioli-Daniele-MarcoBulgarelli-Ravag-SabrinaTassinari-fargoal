package fargoal.model.entity.commons.api;

import fargoal.model.commons.FloorElement;

/**
 * An Entity represent a FloorElement that can move, attack and be damaged.
 */
public interface Entity extends FloorElement {
    /**
     * Return the health of the FloorElement selected.
     * 
     * @return the health
     */
    Health getHealth();

    /**
     * Return the skill of the FloorElement selected.
     * 
     * @return the skill
     */
    Integer getSkill();

    void receiveDamage();
}
