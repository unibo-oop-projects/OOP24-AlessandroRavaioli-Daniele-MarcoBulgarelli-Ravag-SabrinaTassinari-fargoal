package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A class that develops the monster Monk:
 * an enemy that bring with him healing potions
 * that make him recovers hp by drinking.
 */
public class Monk extends AbstractMonster {

    private static final int NEXT_MOVE = 2000;

    /**
     * A constructor for the Monk; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public Monk(final Position position, final Integer level, final FloorMap floorMap, final FloorManager floorManager) {
        super(position, level, floorMap, floorManager);
        setMonsterType(MonsterType.MONK);
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "MONK";
    }

    /** {@inheritDoc} */
    @Override
    public void steal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }

    /**
     * The Monster heal himself with a HealingPotion
     * to recover hp.
     */
    private void heal() {
        this.getHealth().increaseHealth(this.getRandom(19) + 3 * this.getLevel());
        if(this.getHealth().getCurrentHealth() > this.getHealth().getMaxHealth()) {
            this.getHealth().setHealth(this.getHealth().getMaxHealth());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= NEXT_MOVE) {
            this.setTimer();
            if (this.areNeighbours(floorManager, 1)) {
                this.attack();
            } else if (!this.getHealth().isHealthy() && !this.areNeighbours(floorManager, 2)) {
                this.heal();
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
