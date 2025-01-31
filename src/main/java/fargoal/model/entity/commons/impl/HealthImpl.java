package fargoal.model.entity.commons.impl;

import fargoal.model.entity.commons.api.*;

public class HealthImpl implements Health {

    private Integer maxHealth;
    private Integer currentHealth;

    public HealthImpl(Integer maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    @Override
    public Integer getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public Integer getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void decreaseHealth(Integer amount) {
        this.currentHealth = this.currentHealth - amount;
    }

    @Override
    public void increaseHealth(Integer amount) {
        this.currentHealth = this.currentHealth + amount;
    }

    @Override
    public void setHealth(Integer amount) {
        this.currentHealth = amount;
    }
    
}
