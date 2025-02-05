package fargoal.model.entity.player.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.entity.player.api.Inventory;

public class PlayerImpl implements Player {

    private Position position;
    private Integer level;
    private Integer experiencePoints;
    private Health health;
    private Integer skill;
    private final Inventory inventory;
    private final boolean hasSword;

    public PlayerImpl() {
        this.position = null; //TODO
        this.level = 1;
        this.experiencePoints = 0;
        this.health = null; //TODO
        this.skill = null; //TODO
        this.inventory = new InventoryImpl();
        this.hasSword = false;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Integer getLevel() {
        return this.level;
    }

    @Override
    public Integer getExperiencePoints() {
        return this.experiencePoints;
    }

    @Override
    public Health getHealth() {
        return this.health;
    }

    @Override
    public Integer getSkill() {
        return this.skill;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public String getTag() {
        return "PLAYER";
    }

    @Override
    public boolean hasSword() {
        return this.hasSword;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public Integer doDamage(Monster monster) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void receiveDamage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveDamage'");
    }
}
