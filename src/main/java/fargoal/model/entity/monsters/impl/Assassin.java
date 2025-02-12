package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Assassin:
 * an enemy who's generally invisible.
 */
public class Assassin extends AbstractMonster {

    private static final int NEXT_MOVE = 3000;
    private int nextMove;

    /**
     * A constructor for the Assassin, it uses the
     * super of the AbstractMonster constructor but with 
     * his visibility off.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorManager - to get infos about the other entities/items
     * @param renderFactory - to give a render to the Assassin
     */
    public Assassin(final Position position,
            final Integer level, 
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        this.setMonsterType(MonsterType.ASSASSIN);
        this.setRender(renderFactory.assassinRenderer(this));
        this.setVisibilityOff();
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "ASSASSIN";
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= nextMove) {
            this.nextMove = this.getRandom(NEXT_MOVE) + NEXT_MOVE * this.getSkill() / this.getLevel();
            this.setTimer();
            if (this.areNeighbours(floorManager, 1) 
                    && !floorManager.getPlayer().isImmune()
                    && floorManager.getPlayer().isVisible()) {
                this.setVisibilityOn();
                this.getFloorManager().notifyFloorEvent(new ReceiveAttackEvent(this));
                floorManager.getPlayer().receiveDamage(this);
            } else {
                this.setVisibilityOff();
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
