package fargoal.model.interactable.pickUpAble.inChest.impl;

import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.DriftSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.InvisibilitySpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.LightSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.RegenerationSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.ShieldSpell;
import fargoal.model.interactable.pickUpAble.inChest.Spell.impl.TeleportSpell;
import fargoal.model.interactable.pickUpAble.inChest.Trap.impl.CeilingTrap;
import fargoal.model.interactable.pickUpAble.inChest.Trap.impl.Explosion;
import fargoal.model.interactable.pickUpAble.inChest.Trap.impl.Pit;
import fargoal.model.interactable.pickUpAble.inChest.Trap.impl.Teleport;
import fargoal.model.interactable.pickUpAble.inChest.Utility.impl.Beacon;
import fargoal.model.interactable.pickUpAble.inChest.Utility.impl.EnchantedWeapon;
import fargoal.model.interactable.pickUpAble.inChest.Utility.impl.HealingPotion;
import fargoal.model.interactable.pickUpAble.inChest.Utility.impl.MagicSack;
import fargoal.model.interactable.pickUpAble.inChest.Utility.impl.Map;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemFactory;
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
    public ChestItem generateInvisibilitySpell(FloorManager floorManager) {
        return new InvisibilitySpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateLightSpell(FloorManager floorManager) {
        return new LightSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateRegenerationSpell(FloorManager floorManager) {
        return new RegenerationSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateShieldSpell(FloorManager floorManager) {
        return new ShieldSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleportSpell(FloorManager floorManager) {
        return new TeleportSpell(floorManager);
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateCeilingTrap(FloorManager floorManager) {
        return new CeilingTrap();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateExplosion(FloorManager floorManager) {
        return new Explosion();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generatePit(FloorManager floorManager) {
        return new Pit();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleport(FloorManager floorManager) {
        return new Teleport();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateBeacon(FloorManager floorManager) {
        return new Beacon();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateEnchantedWeapon(FloorManager floorManager) {
        return new EnchantedWeapon();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateHealingPotion(FloorManager floorManager) {
        return new HealingPotion();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMap(FloorManager floorManager) {
        return new Map();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMagicSack(FloorManager floorManager){
        return new MagicSack();
    }

}
