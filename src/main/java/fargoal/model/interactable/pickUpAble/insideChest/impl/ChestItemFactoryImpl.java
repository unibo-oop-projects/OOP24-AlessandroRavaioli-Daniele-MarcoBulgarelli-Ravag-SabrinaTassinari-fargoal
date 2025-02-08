package fargoal.model.interactable.pickUpAble.insideChest.impl;

import fargoal.commons.api.Position;
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
import fargoal.model.interactable.pickUpAble.insideChest.Utility.Beacon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.EnchantedWeapon;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.HealingPotion;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.MagicSack;
import fargoal.model.interactable.pickUpAble.insideChest.Utility.Map;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.insideChest.api.ChestItemFactory;
import fargoal.model.manager.api.FloorManager;

/**
 * This class implements the interface ChestItemFactory. It generate the chest items.
 */
public class ChestItemFactoryImpl implements ChestItemFactory{

    /** {@inheritDoc} */
    @Override
    public ChestItem generateDriftSpell(FloorManager floorManager, final Position position) {
        return new DriftSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateInvisibilitySpell(FloorManager floorManager, final Position position) {
        return new InvisibilitySpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateLightSpell(FloorManager floorManager, final Position position) {
        return new LightSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateRegenerationSpell(FloorManager floorManager, final Position position) {
        return new RegenerationSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateShieldSpell(FloorManager floorManager, final Position position) {
        return new ShieldSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleportSpell(FloorManager floorManager, final Position position) {
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
    public ChestItem generateBeacon(FloorManager floorManager, final Position position) {
        return new Beacon(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateEnchantedWeapon(FloorManager floorManager, final Position position) {
        return new EnchantedWeapon(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateHealingPotion(FloorManager floorManager, final Position position) {
        return new HealingPotion(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMap(FloorManager floorManager, final Position position) {
        return new Map(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMagicSack(FloorManager floorManager, final Position position){
        return new MagicSack(floorManager);
    }

}
