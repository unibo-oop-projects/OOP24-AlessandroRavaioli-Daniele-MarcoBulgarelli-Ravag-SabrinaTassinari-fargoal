package fargoal.model.entity.player.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.entity.player.api.Gold;
import fargoal.model.entity.player.api.Inventory;

public class PlayerImpl implements Player {

    private static final int INITIAL_LEVEL = 1;

    private Position position;
    private Integer level;
    private Integer experiencePoints;
    private Health health;
    private Integer skill;
    private final Gold gold;
    private final Inventory inventory;
    private final boolean hasSword;

    public PlayerImpl() {
        this.position = null; //TODO
        this.level = INITIAL_LEVEL;
        this.experiencePoints = 0;
        this.health.setHealth(0); //TODO
        this.skill = null; //TODO
        this.gold = new GoldImpl();
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

    /**
     * This method manages the entire fight: it should check if player can and wants to flee
     * it should manage player automatic turn and monster turn and return true if battle
     * is won.
     * 
     * @param monster - The enemy monster.
     * 
     * @return true if player won the battle, false if they lose it.
     */
    private boolean battle(Monster monster) {
        //TODO
        throw new UnsupportedOperationException("Unimplemented method 'battle'");
    }

    /**
     * This method is used to check wether the player character is dead or not.
     * If the player has at least one healing potion and their health is not
     * below a critical limit, then they should be able to automatically use 
     * the healing potion and do not die.
     * 
     * @return true if player is dead, false otherwise.
     */
    private boolean isDead() {
        if(inventory.getHealingPotions() == 0){
            return this.health.getCurrentHealth() == 0;
        } else {
            return this.health.getCurrentHealth() < -5;
        }
    }
}
