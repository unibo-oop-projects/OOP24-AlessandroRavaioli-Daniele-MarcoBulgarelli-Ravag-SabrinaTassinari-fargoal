package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A class that develops the monster Mage:
 * an enemy who steals spells at the player when he's close
 * and looks like one of the other monsters. 
 */
public class Mage extends AbstractMonster {

    /**
     * A constructor for the Mage; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public Mage(final Position position, final Integer level, final FloorMap floorMap, final FloorManager floorManager) {
        super(position, level, floorMap, floorManager);
        setMonsterType(MonsterType.MAGE);
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "MAGE";
    }

    /** {@inheritDoc} */
    @Override
    public void steal(final Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        if (this.areNeighbours(floorManager, 1)) {
            this.attack();
        } else {
            Ai.move(this, floorManager.getPlayer());
        }
    }
}
