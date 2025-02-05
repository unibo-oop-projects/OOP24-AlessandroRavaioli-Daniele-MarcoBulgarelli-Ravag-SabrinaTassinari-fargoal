package fargoal.model.entity.player.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.entity.commons.api.Health;
import fargoal.model.entity.monsters.api.Monster;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.entity.player.api.Gold;
import fargoal.model.entity.player.impl.GoldImpl;
import fargoal.model.entity.player.api.Inventory;

public class PlayerImpl implements Player {

    private static final int INITIAL_STAT_MAX_COUNTER = 3;
    private static final int DAMAGE_MULTIPLIER = 4;
    private static final int MINIMUM_DAMAGE = 1;
    private static final int INITIAL_LEVEL = 1;

    private Position position;
    private Integer level;
    private Integer experiencePoints;
    private Health health;
    private Integer skill;
    private final Gold gold;    //fai il get gold
    private final Inventory inventory;

    private boolean hasSword;
    private boolean isFighting;
    private boolean isAttacked;
    private boolean isImmune;

    public PlayerImpl() {
        this.position = null; //TODO
        this.level = INITIAL_LEVEL;
        this.experiencePoints = 0;
        this.health.setHealth(setInitialStat());
        this.skill = setInitialStat();
        this.gold = new GoldImpl();
        this.inventory = new InventoryImpl();
        this.hasSword = false;
        this.isFighting = false;
        this.isAttacked = false;
        this.isImmune = false;
    }

    private Integer setInitialStat() {
        Integer stat = 0;
        Integer d6;
        for(int i = 0; i <= INITIAL_STAT_MAX_COUNTER; i ++) {
            d6 = new Random().nextInt(1, 6);
            stat = stat + d6;
        }
        return stat;
    }

    @Override
    public void setSkill(final Integer skill) {
        if(skill == null || skill < 0) {
            throw new IllegalArgumentException("The skill cannot be set to a null or negative value.");
        } else {
            this.skill = skill;
        }
    }

    @Override
    public void increaseSkill(final Integer amount) {
        if(skill == null) {
            throw new IllegalArgumentException("The skill cannot be increased of a null value.");
        } else if(amount > this.skill) {
            throw new IllegalArgumentException("The amount in input can not decrease the skill below 0.");
        } else {
            this.skill = this.skill + amount;
        }
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
    public Integer getCurrentGold() {
        return this.gold.getCurrentGold();
    }

    @Override
    public Integer getMaxGoldCapacity() {
        return this.gold.getMaxCapacity();
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public Gold getPlayerGold() {
        return this.gold;
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
    public void setHasSword(final boolean condition) {
        this.hasSword = condition;
    }

    public boolean isImmune() {
        return this.isImmune;
    }

    public void setIsImmune(final boolean condition) {
        this.isImmune = condition;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public Integer doDamage(final Monster monster) {
        if(monster == null) {
            throw new IllegalArgumentException("The monster passed to this method can not be null");
        } else {
            int ratio = this.getSkill() / monster.getSkill();
            Random random = new Random();
            return random.nextInt(MINIMUM_DAMAGE, (DAMAGE_MULTIPLIER * this.getLevel() * ratio));
        }
    }

    @Override
    public void update(final FloorManager floorManager) {
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
    private boolean battle(final Monster monster) {
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
    @Override
    public boolean isDead() {
        if(inventory.getHealingPotions() == 0){
            return this.health.getCurrentHealth() == 0;
        } else {
            return this.health.getCurrentHealth() < -5;
        }
    }

    /**
     * This method calculates the passive health regeneration of the player.
     * It should be 1 health for 10 t.u.(time unity).
     */
    private void pasiveRegeneration() {
        while(!isFighting) {
            //TODO
        }
    }
}
