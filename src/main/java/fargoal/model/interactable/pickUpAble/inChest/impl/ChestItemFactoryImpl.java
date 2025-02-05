package fargoal.model.interactable.pickUpAble.inChest.impl;

import fargoal.commons.api.Position;
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
