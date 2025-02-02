package fargoal.model.entity.commons.api;

import fargoal.commons.api.Position;
import fargoal.model.FloorElement;

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
     * Return the position of the FloorElement selected.
     * 
     * @return the position
     */
    Position getPosition();

    /**
     * Return the skill of the FloorElement selected.
     * 
     * @return the skill
     */
    Integer getSkill();
}
