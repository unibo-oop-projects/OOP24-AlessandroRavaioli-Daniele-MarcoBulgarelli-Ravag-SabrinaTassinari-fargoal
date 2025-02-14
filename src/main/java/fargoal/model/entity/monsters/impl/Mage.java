package fargoal.model.entity.monsters.impl;

import fargoal.commons.api.Position;
import fargoal.model.entity.monsters.ai.Ai;
import fargoal.model.entity.monsters.api.AbstractMonster;
import fargoal.model.entity.monsters.api.MonsterType;
import fargoal.model.entity.player.api.Inventory;
import fargoal.model.events.impl.MonsterStealSpellEvent;
import fargoal.model.manager.api.FloorManager;
import fargoal.view.api.RenderFactory;

/**
 * A class that develops the monster Mage:
 * an enemy who steals spells at the player when he's close
 * and looks like one of the other monsters.
 */
public class Mage extends AbstractMonster {

    private static final int NEXT_MOVE = 2000;
    private static final int MAX_SPELLS = 6;
    private static final int MIN_WAIT = 1250;
    private static final int MAX_WAIT = 1750;
    private static final int FLOOR_CHANGE = 9;
    private final int minimumWait;
    private int nextMove;

    /**
     * A constructor for the Mage; it uses the
     * super of the AbstractMonster constructor.
     * 
     * @param position - the starting position
     * @param level - the level of the monster
     * @param floorManager - to get infos about the other entities/items
     * @param renderFactory - to give a render to the Mage
     */
    public Mage(final Position position, 
            final Integer level,
            final FloorManager floorManager,
            final RenderFactory renderFactory) {
        super(position, level, floorManager);
        if (floorManager.getFloorLevel() > FLOOR_CHANGE) {
            this.minimumWait = MIN_WAIT;
        } else {
            this.minimumWait = MAX_WAIT;
        }
        setMonsterType(MonsterType.MAGE);
        this.setRender(renderFactory.mageRenderer(this));
    }

    /** {@inheritDoc} */
    @Override
    public String getTag() {
        return "MAGE";
    }

    /** {@inheritDoc} */
    @Override
    public void steal() {
        final Inventory inventory = this.getFloorManager().getPlayer().getInventory();
        boolean check = false;
        while (!check) {
            final var num = this.getRandom(MAX_SPELLS);
            if (num == 0
                    && inventory.getInvisibilitySpell().getNumberInInventory() > 0) {
                        this.getFloorManager()
                                .notifyFloorEvent(new MonsterStealSpellEvent(inventory.getInvisibilitySpell(), this));
                        inventory.getInvisibilitySpell().removeSpell();
                        check = true;
            } else if (num == 1
                    && inventory.getRegenerationSpell().getNumberInInventory() > 0) {
                        this.getFloorManager()
                                .notifyFloorEvent(new MonsterStealSpellEvent(inventory.getRegenerationSpell(), this));
                        inventory.getRegenerationSpell().removeSpell();
                        check = true;
            } else if (num == 2
                    && inventory.getTeleportSpell().getNumberInInventory() > 0) {
                        this.getFloorManager()
                                .notifyFloorEvent(new MonsterStealSpellEvent(inventory.getTeleportSpell(), this));
                        inventory.getTeleportSpell().removeSpell();
                        check = true;
            } else if (num == 3
                    && inventory.getShieldSpell().getNumberInInventory() > 0) {
                        this.getFloorManager()
                                .notifyFloorEvent(new MonsterStealSpellEvent(inventory.getShieldSpell(), this));
                        inventory.getShieldSpell().removeSpell();
                        check = true;
            } else if (num == 4
                    && inventory.getLightSpell().getNumberInInventory() > 0) {
                        this.getFloorManager()
                                .notifyFloorEvent(new MonsterStealSpellEvent(inventory.getLightSpell(), this));
                        inventory.getLightSpell().removeSpell();
                        check = true;
            } else if (num == MAX_SPELLS - 1
                    && inventory.getDriftSpell().getNumberInInventory() > 0) {
                        this.getFloorManager()
                                .notifyFloorEvent(new MonsterStealSpellEvent(inventory.getDriftSpell(), this));
                        inventory.getDriftSpell().removeSpell();
                        check = true;
            }
        }


        if (inventory.getHealingPotions().getNumberInInventory() != 0) {
            inventory.getHealingPotions().removeUtility();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void update(final FloorManager floorManager) {
        final long temp = System.currentTimeMillis();
        if (Math.abs(this.getTimer() - temp) >= nextMove) {
        this.nextMove = this.getRandom(NEXT_MOVE * this.getSkill() / this.getLevel()) + minimumWait;
            this.setTimer();
            if (this.areNeighbours(floorManager, 1)
                    && !floorManager.getPlayer().isImmune()
                    && floorManager.getPlayer().isVisible()) {
                        if (floorManager.getPlayer().getInventory().areThereSpells()
                                && this.getRandom(4) == 0) {
                            this.steal();
                        } else {
                            floorManager.getPlayer().setIsAttacked(true);
                            this.setIsFighting(true);
                            floorManager.getPlayer().battle(this);
                        }
                    } else {
                        Ai.move(this, floorManager.getPlayer(), floorManager);
                    }
        }
    }
}
