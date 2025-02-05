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

    /**
     * The Entity selected with the call of this
     * method will receive the damage. For example if it's
     * called on a monster, he will receives the damages from the
     * player; instead if it's called on the player, he will receives
     * damages from a monster who is attacking him.
     */
    void receiveDamage();
}
