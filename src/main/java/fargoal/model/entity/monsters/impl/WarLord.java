package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster WarLord:
 * an enemy that often carries a War Shield to protect
 * himself from the attacks of the player.
 */
public class WarLord extends AbstractMonster {

    private static final int NEXT_MOVE = 5000;
    private boolean shield;

    /**
     * A constructor for the War Lord; it uses the
     * super of the AbstractMonster constructor and he's
     * created with a built-in shield.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorManager - to get infos about the other entities/items
     * @param renderFactory - to give a render to the War Lord
     */
    public WarLord(final Position position, 
            final Integer level,
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        setMonsterType(MonsterType.WAR_LORD);
        this.shield = true;
        this.setRender(renderFactory.warlordRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public void receiveDamage() {
        final int damage = this.getFloorManager().getPlayer().doDamage(this);
        if (shield) {
            shield = false;
        } else {
            this.getHealth().decreaseHealth(damage);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "WAR_LORD";
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
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
