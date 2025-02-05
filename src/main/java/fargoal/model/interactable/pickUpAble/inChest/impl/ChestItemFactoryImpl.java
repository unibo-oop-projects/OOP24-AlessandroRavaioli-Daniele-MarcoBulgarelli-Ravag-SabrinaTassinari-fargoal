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

/**
 * This class implements the interface ChestItemFactory. It generate the chest items.
 */
public class ChestItemFactoryImpl implements ChestItemFactory{

    /** {@inheritDoc} */
    @Override
    public Spell generateDriftSpell() {
        return new DriftSpell();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateInvisibilitySpell() {
        return new InvisibilitySpell();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateLightSpell() {
        return new LightSpell();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateRegenerationSpell() {
        return new RegenerationSpell();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateShieldSpell() {
        return new ShieldSpell();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleportSpell() {
        return new TeleportSpell();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateCeilingTrap() {
        return new CeilingTrap();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateExplosion() {
        return new Explosion();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generatePit() {
        return new Pit();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateTeleport() {
        return new Teleport();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateBeacon() {
        return new Beacon();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateEnchantedWeapon() {
        return new EnchantedWeapon();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateHealingPotion() {
        return new HealingPotion();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMap() {
        return new Map();
    }

    /** {@inheritDoc} */
    @Override
    public ChestItem generateMagicSack(){
        return new MagicSack();
    }

}
