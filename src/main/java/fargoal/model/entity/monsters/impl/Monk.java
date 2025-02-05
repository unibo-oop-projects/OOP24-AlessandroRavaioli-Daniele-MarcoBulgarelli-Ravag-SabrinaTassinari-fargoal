package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A class that develops the monster Monk:
 * an enemy that bring with him healing potions
 * that make him recovers hp by drinking.
 */
public class Monk extends AbstractMonster {

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
    public void steal(final Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }

    /**
     * The Monster heal himself with a HealingPotion
     * to recover hp.
     */
    private void heal() {
        this.getHealth().setToMaxHealth();
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        if (this.areNeighbours(floorManager, 1)) {
            this.attack();
        } else if (!this.getHealth().isHealthy() && !this.areNeighbours(floorManager, 2)) {
            this.heal();
        } else {
            Ai.move(this, floorManager.getPlayer());
        }
    }
}
