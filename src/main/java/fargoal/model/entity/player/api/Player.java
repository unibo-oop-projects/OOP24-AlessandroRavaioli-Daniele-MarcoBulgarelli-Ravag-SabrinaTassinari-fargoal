package fargoal.model.entity.player.api;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Entity;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.Monster;

/**
 * Interface that manages the player character.
 */

public interface Player extends Entity {

    /**
     * Moves the player to a new position
     * 
     * @param newPosition - The new position to move the player to.
     */
    void move(Position newPosition);
    
    /**
     * Gets the current level of the player.
     * 
     * @return the {@link Integer} representing the level of the player.
     */
    Integer getLevel();

    /**
     * Gets the current experience points of the player.
     * 
     * @return the {@link Integer} representing the experience points of the player.
     */
    Integer getExperiencePoints();

    /**
     * Gets the required experience points for the next level up.
     * 
     * @return the {@link Integer} representing the required experience points for the next level.
     */
    Integer getExperiencePointsRequired();

    /**
     * Adds experience points to the player's total experience.
     * Ensures that the amount added is non-negative and not null.
     * 
     * @param experiencePointToAdd - The amount of experience points to be added.
     * 
     * @throws IllegalArgumentException if the experience points to add is null or negative.
     */
    void addExperiencePoints(Integer experiencePointsToAdd);

    /**
     * Gets the player's inventory.
     * 
     * @return The {@link Inventory} of the player.
     */
    Inventory getInventory();

    /**
     * Retrieves the number of monsters the player has defeated.
     * 
     * @return The {@link Integer} representing the number of slain foes.
     */
    Integer getNumberOfSlainFoes();

    /**
     * Retrieves the object that represents player's gold pouch.
     * 
     * @return the {@link Gold} that represents the player gold pouch.
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
     * This method control if the player is visble to monster or not.
     * 
     * @return true if the player is visible, false otherwise.
     */
    public boolean isVisible();

    /**
     * Setter for the isVisible condition.
     * 
     * @param condition - true if the player is visible, false otherwise.
     */
    public void setIsVisible(boolean condition);

    /**
     * Getter for the hasLight condition. This refers to the light spell, if it is true the light is on,
     * otherwise false.
     * @return true if the light is on, false otherwise.
     */
    public boolean hasLight();

    /**
     * Setter for the hasLight condition.
     * @param condition - true if the light is on, false otherwise.
     */
    public void setHasLight(boolean condition);

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
     * This method calculates the amount of damage the player
     * does against the monster they are currently fighting in
     * a single attack.
     * 
     * @param monster - The enemy monster.
     * 
     * @return the amount of damage dealt.
     */
    Integer doDamage(Monster monster);

    /**
     * Subtracts health from the player when attacked by a monster.
     * If the player is not protected by a shield spell, the player's health is decreased based on the monster's attack.
     * If the player has a shield spell active, it is deactivated instead of taking damage.
     * 
     * @param monster - The {@link Monster} that is attacking the player.
     */
    void receiveDamage(Monster monster);

    /**
     * This method manages the character level up, given
     * they have enough experience points.
     * Whenever the player levels up their max health and
     * their skill increase, the level increases by one and
     * the next required experience points double.
     */
    boolean levelUp();

    boolean isImmune();

    void setIsImmune(Boolean condition);

    void useInvisibilitySpell();

    void useTeleportSpell();

    void useShieldSpell();

    void useRegenerationSpell();

    void useDriftSpell();

    void useLightSpell();

    void useHealingPotion();

    void useBeacon();

    /**
     * Manages the entire fight sequence between the player and the given monster.
     * This method handles the combat mechanics, including attacks, fleeing conditions,
     * and input locking. The battle continues until either the player or the monster is defeated.
     * <p>
     * If the player is moving away from the monster and was the one that started the fight,
     * the battle ends immediately, allowing the player to flee.
     * If the player has been attacked, inputs are locked between turns.
     * Otherwise, the combat continues in an automated fashion.
     * </p>
     * 
     * @param monster - The enemy {@link AbstractMonster} the player is fighting.
     * 
     * @return {@code true} if the player wins the battle, {@code false} if they lose.
     */
    void battle(final Monster monster);

    void setIsAttacked(final boolean value);

    /**
     * Checks if the player is currently engaged in combat.
     * This method returns {@code true} if the player is in a fight, otherwise {@code false}.
     * 
     * @return {@code true} if the player is fighting, {@code false} otherwise.
     */
    boolean isFighting();
}
