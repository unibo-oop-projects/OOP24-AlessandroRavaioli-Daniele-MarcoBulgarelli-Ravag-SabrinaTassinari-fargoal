package fargoal.model.entity.monsters.api;

import fargoal.model.entity.commons.api.Entity;

/**
 * A monster represent an Entity who will try to attack
 * the player and kill him.
 */
public interface Monster extends Entity {
    /**
     * Return the MonsterType of the monster selected.
     * 
     * @return the MonsterType
     */
    MonsterType getMonsterType();

}
