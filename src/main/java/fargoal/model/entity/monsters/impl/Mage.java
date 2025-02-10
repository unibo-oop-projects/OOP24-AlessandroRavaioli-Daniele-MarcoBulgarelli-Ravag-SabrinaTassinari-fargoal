package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Inventory;
import fargoal.model.events.impl.ReceiveAttackEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Mage:
 * an enemy who steals spells at the player when he's close
 * and looks like one of the other monsters.
 */
public class Mage extends AbstractMonster {

    private static final int NEXT_MOVE = 5000;

    /**
     * A constructor for the Mage; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public Mage(final Position position, 
            final Integer level, 
            final FloorMap floorMap, 
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        this.setRender(renderFactory.mageRenderer(this));
        setMonsterType(MonsterType.MAGE);
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "MAGE";
    }

    /** {@inheritDoc} */
    @Override
    public void steal() {
        Inventory inventory = this.getFloorManager().getPlayer().getInventory();
        if (inventory.getHealingPotions().getNumberInInventory() != 0) {
            inventory.getHealingPotions().removeUtility();
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
                if(this.getRandom(2) == 0) {
                    this.steal();
                }
            } else {
                Ai.move(this, floorManager.getPlayer());
            }
        }
    }
}
