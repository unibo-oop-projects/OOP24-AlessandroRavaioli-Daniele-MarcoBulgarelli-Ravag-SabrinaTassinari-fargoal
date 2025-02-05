package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

/**
 * A class that develops the monster Barbarian:
 * an enemy that is simple, he only attacks the player
 * and tries to kill him.
 */
public class Barbarian extends AbstractMonster {

    /**
     * A constructor to set the field that the monster needs
     * to be able to walk in the map, interacts with the items
     * and, in case, attacks the player.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorMap - the floorMap where the monster is located
     * @param floorManager - to get infos about the other entities/items
     */
    public Barbarian(final Position position, final Integer level, final FloorMap floorMap, final FloorManager floorManager) {
        setMonsterType(MonsterType.BARBARIAN);
        setPosition(position);
        setFloorMap(floorMap);
        setSkill(level);
        //this.getHealth().setHealth(floorManager.getPlayer().getHealth().getCurrentHealth() / 3 * (this.getRandom(level) + 1));
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "BARBARIAN";
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
            this.attack(floorManager.getPlayer());
        } else {
            Ai.move(this, floorManager.getPlayer());
        }
    }
}
