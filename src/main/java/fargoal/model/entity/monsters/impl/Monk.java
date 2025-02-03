package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

public class Monk extends AbstractMonster {

    public Monk(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        setMonsterType(MonsterType.MONK);
        setPosition(position);
        setFloorMap(floorMap);
        setSkill(level);
        this.getHealth().setHealth(floorManager.getPlayer().getHealth().getCurrentHealth() / 3 * (this.getRandom(level) + 1));
    }

    @Override
    public String getTag() {
        return "MONK";
    }

    @Override
    public void steal(Player player) {
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

    @Override
    public void update(FloorManager floorManager) {
        if(this.areNeighbours(floorManager, 1)) {
            this.attack(floorManager.getPlayer());
        } else if(!this.getHealth().isHealthy() && !this.areNeighbours(floorManager, 2)) {
            this.heal();
        } else {
            Ai.move(this, floorManager.getPlayer());
        }
    }
}
