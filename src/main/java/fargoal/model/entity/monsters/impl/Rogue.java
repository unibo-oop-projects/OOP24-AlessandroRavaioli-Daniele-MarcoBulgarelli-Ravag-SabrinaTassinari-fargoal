package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Rogue:
 * an enemy that will always steal something from the
 * player when attacking him.
 */
public class Rogue extends AbstractMonster {

    private static final int NEXT_MOVE = 200;
    private static final int GOLD_REMOVE = 4;

    /**
     * A constructor for the Rogue; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public Rogue(final Position position, 
            final Integer level, 
            final FloorMap floorMap, 
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        this.setRender(renderFactory.rogueRenderer(this));
        setMonsterType(MonsterType.ROGUE);
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "ROGUE";
    }

    /** {@inheritDoc} */
    @Override
    public void steal() {
        final Player player = this.getFloorManager().getPlayer();
        player.getPlayerGold().removeGold(player.getCurrentGold() / GOLD_REMOVE);
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= NEXT_MOVE) {
            this.setTimer();
            if (this.areNeighbours(floorManager, 1)) {
                this.attack();
                this.steal();
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
