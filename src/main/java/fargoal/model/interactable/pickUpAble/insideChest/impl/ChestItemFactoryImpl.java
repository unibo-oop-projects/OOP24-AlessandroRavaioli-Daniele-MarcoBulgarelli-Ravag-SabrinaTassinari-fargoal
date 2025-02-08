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
        return new DriftSpell(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateInvisibilitySpell(FloorManager floorManager, final Position position) {
        return new InvisibilitySpell(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateLightSpell(FloorManager floorManager, final Position position) {
        return new LightSpell(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateRegenerationSpell(FloorManager floorManager, final Position position) {
        return new RegenerationSpell(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateShieldSpell(FloorManager floorManager, final Position position) {
        return new ShieldSpell(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleportSpell(FloorManager floorManager, final Position position) {
        return new TeleportSpell(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateCeilingTrap(FloorManager floorManager, final Position position) {
        return new CeilingTrap(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateExplosion(FloorManager floorManager, final Position position) {
        return new Explosion(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generatePit(FloorManager floorManager, final Position position) {
        return new Pit(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleport(FloorManager floorManager, final Position position) {
        return new Teleport(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateBeacon(FloorManager floorManager, final Position position) {
        return new Beacon(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateEnchantedWeapon(FloorManager floorManager, final Position position) {
        return new EnchantedWeapon(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateHealingPotion(FloorManager floorManager, final Position position) {
        return new HealingPotion(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMap(FloorManager floorManager, final Position position) {
        return new Map(floorManager, position);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMagicSack(FloorManager floorManager, final Position position){
        return new MagicSack(floorManager, position);
    }

}
