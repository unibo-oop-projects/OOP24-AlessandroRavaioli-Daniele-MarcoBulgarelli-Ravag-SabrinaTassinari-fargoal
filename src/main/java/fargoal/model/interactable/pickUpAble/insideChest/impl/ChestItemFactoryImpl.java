package fargoal.model.interactable.pickUpAble.insideChest.impl;

import fargoal.commons.api.Position;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.CeilingTrap;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.Explosion;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.Pit;
import fargoal.model.interactable.pickUpAble.insideChest.Trap.Teleport;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.api.Utility;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Beacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.EnchantedWeapon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.HealingPotion;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.MagicSack;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.impl.Map;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemFactory;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the interface ChestItemFactory. It generate the chest items.
 */
public class ChestItemFactoryImpl implements ChestItemFactory{

    /** {@inheritDoc} */
    @Override
    public Spell generateDriftSpell(FloorManager floorManager, final Position position) {
        return new DriftSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Spell generateInvisibilitySpell(FloorManager floorManager, final Position position) {
        return new InvisibilitySpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Spell generateLightSpell(FloorManager floorManager, final Position position) {
        return new LightSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Spell generateRegenerationSpell(FloorManager floorManager, final Position position) {
        return new RegenerationSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Spell generateShieldSpell(FloorManager floorManager, final Position position) {
        return new ShieldSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Spell generateTeleportSpell(FloorManager floorManager, final Position position) {
        return new TeleportSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateCeilingTrap(FloorManager floorManager, final Position position) {
        return new CeilingTrap(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateExplosion(FloorManager floorManager, final Position position) {
        return new Explosion(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generatePit(FloorManager floorManager, final Position position) {
        return new Pit(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleport(FloorManager floorManager, final Position position) {
        return new Teleport(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Utility generateBeacon(FloorManager floorManager, final Position position) {
        return new Beacon(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Utility generateEnchantedWeapon(FloorManager floorManager, final Position position) {
        return new EnchantedWeapon(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Utility generateHealingPotion(FloorManager floorManager, final Position position) {
        return new HealingPotion(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Utility generateMap(FloorManager floorManager, final Position position) {
        return new Map(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public Utility generateMagicSack(FloorManager floorManager, final Position position){
        return new MagicSack(floorManager);
    }

}
