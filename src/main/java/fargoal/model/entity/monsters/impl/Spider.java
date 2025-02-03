package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Player;
import fargoal.model.manager.api.FloorManager;
import fargoal.model.map.api.FloorMap;

public class Spider extends AbstractMonster {

    public Spider(Position position, Integer level, FloorMap floorMap, FloorManager floorManager) {
        setMonsterType(MonsterType.SPIDER);
        setPosition(position);
        setFloorMap(floorMap);
        setSkill(level);
        this.getHealth().setHealth(floorManager.getPlayer().getHealth().getCurrentHealth() / 3 * (this.getRandom(level) + 1));
    }

    @Override
    public String getTag() {
        return "SPIDER";
    }

    @Override
    public void move(FloorManager floorManager) {
        Ai.moveSpider(this, floorManager.getPlayer());
    }

    @Override
    public void steal(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'steal'");
    }

    @Override
    public void update(FloorManager floorManager) {
        if(this.areNeighbours(floorManager, 1)) {
            this.attack(floorManager.getPlayer());
        } else {
            Ai.move(this, floorManager.getPlayer());
        }
    }
}
