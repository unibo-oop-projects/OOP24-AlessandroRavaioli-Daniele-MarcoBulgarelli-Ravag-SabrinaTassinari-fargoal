package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

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
    public Spider(final Position position, final Integer level, final FloorMap floorMap, final FloorManager floorManager) {
        super(position, level, floorManager);
        setMonsterType(MonsterType.SPIDER);
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "SPIDER";
    }

    /** {@inheritDoc} */
    @Override
    public void move(final FloorManager floorManager) {
        Ai.moveSpider(this, floorManager.getPlayer());
    }

    /** {@inheritDoc} */
    @Override
    public void steal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= NEXT_MOVE) {
            this.setTimer();
            if (this.areNeighbours(floorManager, 1)) {
                this.attack();
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
