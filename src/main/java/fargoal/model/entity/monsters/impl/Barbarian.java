package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Barbarian:
 * an enemy that is simple, he only attacks the player
 * and tries to kill him.
 */
public class Barbarian extends AbstractMonster {

    private static final int NEXT_MOVE = 3000;
    private final int minimum_wait;
    private int nextMove;

    /**
     * A constructor for the Barbarian; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorManager - to get infos about the other entities/items
     * @param renderFactory - to give a render to the Barbarian
     */
    public Barbarian(final Position position, 
            final Integer level,
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        minimum_wait = 2000;
        setMonsterType(MonsterType.BARBARIAN);
        this.setRender(renderFactory.barbarianRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "BARBARIAN";
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= nextMove) {
            this.nextMove = this.getRandom(NEXT_MOVE * this.getSkill() / this.getLevel()) + minimum_wait;
            this.setTimer();
            if (this.areNeighbours(floorManager, 1) 
                    && !floorManager.getPlayer().isImmune()
                    && floorManager.getPlayer().isVisible()) {
                this.getFloorManager().notifyFloorEvent(new ReceiveAttackEvent(this));
                floorManager.getPlayer().receiveDamage(this);
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
