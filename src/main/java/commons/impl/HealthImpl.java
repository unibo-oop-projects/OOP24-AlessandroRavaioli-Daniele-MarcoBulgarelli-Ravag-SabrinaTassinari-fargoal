package commons.impl;

import commons.api.Health;

public class HealthImpl implements Health {

    private float maxHealth;
    private float currentHealth;

    public HealthImpl(float maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    @Override
    public float getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public float getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void decreaseHealth(float amount) {
        this.currentHealth = this.currentHealth - amount;
    }

    @Override
    public void increaseHealth(float amount) {
        this.currentHealth = this.currentHealth + amount;
    }
    
}
