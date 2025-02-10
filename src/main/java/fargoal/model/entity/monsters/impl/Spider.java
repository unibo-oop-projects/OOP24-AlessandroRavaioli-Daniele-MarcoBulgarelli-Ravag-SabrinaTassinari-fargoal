package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Spider:
 * an enemy that have the ability to climb walls
 * and that can attack the player by jumping down 
 * from them.
 */
public class Spider extends AbstractMonster {

    private static final int NEXT_MOVE = 2000;

    /**
     * A constructor for the Spider; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public Spider(final Position position, 
            final Integer level, 
            final FloorMap floorMap, 
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        this.setRender(renderFactory.spiderRenderer(this));
        setMonsterType(MonsterType.SPIDER);
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "SPIDER";
    }

    /**
     * The Spider never steal anything from the player.
    */
    @Override
    public void steal() {}

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= NEXT_MOVE) {
            this.setTimer();
            if (this.areNeighbours(floorManager, 1) && !floorManager.getPlayer().isImmune()) {
                this.getFloorManager().notifyFloorEvent(new ReceiveAttackEvent(this));
                floorManager.getPlayer().receiveDamage(this);
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
