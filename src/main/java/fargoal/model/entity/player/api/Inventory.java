package fargoal.model.entity.player.api;

public interface Inventory {
    
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
