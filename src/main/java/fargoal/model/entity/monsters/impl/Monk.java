package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Monk:
 * an enemy that bring with him healing potions
 * that make him recovers hp by drinking.
 */
public class Monk extends AbstractMonster {

    private static final int NEXT_MOVE = 5000;
    private static final int HEAL_CONSTANT = 19;

    /**
     * A constructor for the Monk; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorManager - to get infos about the other entities/items
     * @param renderFactory - to give a render to the Monk
     */
    public Monk(final Position position, 
            final Integer level,
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        setMonsterType(MonsterType.MONK);
        this.setRender(renderFactory.monkRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "MONK";
    }

    /**
     * The Monster heal himself with a HealingPotion
     * to recover hp.
     */
    private void heal() {
        this.getHealth().increaseHealth(this.getRandom(HEAL_CONSTANT) + 3 * this.getLevel());
        if (this.getHealth().getCurrentHealth() > this.getHealth().getMaxHealth()) {
            this.getHealth().setHealth(this.getHealth().getMaxHealth());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= NEXT_MOVE) {
            this.setTimer();
            if (this.areNeighbours(floorManager, 1)
                    && !floorManager.getPlayer().isImmune()
                    && floorManager.getPlayer().isVisible()) {
                this.getFloorManager().notifyFloorEvent(new ReceiveAttackEvent(this));
                floorManager.getPlayer().receiveDamage(this);
            } else if (!this.getHealth().isHealthy() && !this.areNeighbours(floorManager, 2)) {
                this.heal();
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
