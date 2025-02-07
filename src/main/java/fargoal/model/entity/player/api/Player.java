package fargoal.model.entity.player.api;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Entity;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.Monster;

/**
 * Interface that manages the player character.
 */

public interface Player extends Entity {

    /**
     * Setter for player's current position.
     * @param position - the new position of the player.
     */
    void setPosition(Position position);
    
    /**
     * Getter for player's current level.
     * 
     * @return player's current level.
     */
    Integer getLevel();

    /**
     * Getter for the amount of experience points
     * the player currently has.
     * 
     * @return the amount of experience points the 
     * player currently has.
     */
    Integer getExperiencePoints();

    /**
     * Getter for the amount of experience points required to
     * gain a level.
     * 
     * @return the amount of experience points required to gain a level.
     */
    Integer getExperiencePointsRequired();

    /**
     * This method add an amount of experience point to the experience the player has already got.
     * @param experiencePointToAdd - the experience point the player gained.
     */
    void addExperiencePoints(Integer experiencePointsToAdd);

    /**
     * Getter for the player's inventory.
     * 
     * @return the inventory associated to the player.
     */
    Inventory getInventory();

    /**
     * Getter for player gold object.
     * 
     * @return the player gold object.
     */
    Gold getPlayerGold();

    /**
     * Getter for player current carried gold.
     * 
     * @return the gold amount player is currently carrying.
     */
    Integer getCurrentGold();

    /**
     * Getter for player maximum gold capacity.
     * 
     * @return the amount player is able to carry.
     */
    Integer getMaxGoldCapacity();

    /**
     * This method controls if player has aquired the
     * legendary sword.
     * 
     * @return true if player has the sword, false otherwise.
     */
    boolean hasSword();

    /**
     * Setter for the hasSword condition: it changes wether the
     * player has the legendary sword or not.
     * 
     * @param condition - True if player found the sword, false otherwise.
     */
    void setHasSword(boolean condition);

    /**
     * This method controls if player is immune or not.
     * 
     * @return true if the player is immune, false otherwise.
     */
    public boolean isImmune();

    /**
     * Setter for the isImmune condition.
     * 
     * @param condition - True if player is immune, false otherwise.
     */
    public void setIsImmune(boolean condition);

    /**
     * This method control if the player is visble to monster or not.
     * 
     * @return true if the player is visible, false otherwise.
     */
    public boolean isVisible();

    /**
     * Setter fot the isVisible condition.
     * 
     * @param condition - true if the player is visible, false otherwise.
     */
    public void setIsVisible(boolean condition);

    /**
     * Sets the player skill to the amount given.
     * 
     * @param amount - the value to set player skill to.
     */
    public void setPlayerSkill(Integer amount);

    /**
     * Increases the player's skill of the amount given.
     * 
     * @param amount - the value to add to player's skill.
     */
    void increasePlayerSkill(final Integer amount);

    /**
     * Makes the player move one tile in the map.
     */
    void move();

    /**
     * This method calculates the amount of damage the player
     * does against the monster they are currently fighting in
     * a single attack.
     * 
     * @param monster - The enemy monster.
     * 
     * @return the amount of damage dealt.
     */
    Integer doDamage(Monster monster);

    void receiveDamage(AbstractMonster monster);

    /**
     * This method manages the character level up, given
     * they have enough experience points.
     * Whenever the player levels up their max health and
     * their skill increase, the level increases by one and
     * the next required experience points double.
     */
    void levelUp();
}
