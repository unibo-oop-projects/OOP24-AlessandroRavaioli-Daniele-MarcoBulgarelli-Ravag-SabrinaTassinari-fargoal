package fargoal.model.entity.player.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.player.api.Player;

public class PlayerImpl implements Player{

    private Health health;
    private Position position;
    private Integer skill;
    private Integer healingPotions;
    private Integer invisibilitySpells;
    private Integer teleportSpells;
    private Integer shieldSpells;

    @Override
    public Integer getHealth() {
        return this.health.getCurrentHealth();
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Integer getSkill() {
        return this.skill;
    }

    @Override
    public boolean isColliding() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isColliding'");
    }

    @Override
    public String getTag() {
        return "PLAYER";
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public Integer getHealingPotion() {
        return this.healingPotions;
    }

    @Override
    public Integer getInvisibilitySpell() {
        return this.invisibilitySpells;
    }

    @Override
    public Integer getTeleportSpell() {
        return this.teleportSpells;
    }

    @Override
    public Integer getShieldSpell() {
        return this.shieldSpells;
    }

    @Override
    public void addHealingPotion() {
        this.healingPotions++;
    }

    @Override
    public void removeHealingPotion() {
        this.healingPotions--;
    }

    @Override
    public void addInvisibilitySpell() {
        this.invisibilitySpells++;
    }

    @Override
    public void removeInvisibilitySpell() {
        this.invisibilitySpells--;
    }

    @Override
    public void addTeleportSpell() {
        this.teleportSpells++;
    }

    @Override
    public void removeTeleportSpell() {
        this.teleportSpells--;
    }

    @Override
    public void addShieldSpell() {
        this.shieldSpells++;
    }

    @Override
    public void removeShieldSpell() {
        this.shieldSpells--;
    }
    
}
