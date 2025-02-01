package fargoal.model.entity.player.api;

import fargoal.model.entity.commons.api.Entity;

public interface Player extends Entity{
    
    void move();

    Integer getHealingPotion();

    Integer getInvisibilitySpell();

    Integer getTeleportSpell();

    Integer getShieldSpell();

    void addHealingPotion();

    void removeHealingPotion();

    void addInvisibilitySpell();

    void removeInvisibilitySpell();

    void addTeleportSpell();

    void removeTeleportSpell();

    void addShieldSpell();

    void removeShieldSpell();

}
