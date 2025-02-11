package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.events.impl.MonsterStealGoldEvent;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Rogue:
 * an enemy that will always steal something from the
 * player when attacking him.
 */
public class Rogue extends AbstractMonster {

    private static final int NEXT_MOVE = 5000;

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
        final int quantity = this.getRandom(player.getCurrentGold() / 2) + 1;
        this.getFloorManager().notifyFloorEvent(new MonsterStealGoldEvent(quantity, this));
        player.getPlayerGold().removeGold(quantity);
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
                        if (floorManager.getPlayer().getCurrentGold() > 0
                                && this.getRandom(3) == 0) {
                                    this.steal();
                                } else {
                                    floorManager.notifyFloorEvent(new ReceiveAttackEvent(this));
                                    floorManager.getPlayer().receiveDamage(this);
                                }
                    } else {
                        Ai.move(this, floorManager.getPlayer());
                    }
        }
    }
}
