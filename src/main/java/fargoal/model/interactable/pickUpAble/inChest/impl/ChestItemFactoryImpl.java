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

public class ChestItemFactoryImpl implements ChestItemFactory{

    @Override
    public Spell generateDriftSpell() {
        return new DriftSpell();
    }

    @Override
    public ChestItem generateInvisibilitySpell() {
        return new InvisibilitySpell();
    }

    @Override
    public ChestItem generateLightSpell() {
        return new LightSpell();
    }

    @Override
    public ChestItem generateRegenerationSpell() {
        return new RegenerationSpell();
    }

    @Override
    public ChestItem generateShieldSpell() {
        return new ShieldSpell();
    }

    @Override
    public ChestItem generateTeleportSpell() {
        return new TeleportSpell();
    }

    @Override
    public ChestItem generateCeilingTrap() {
        return new CeilingTrap();
    }

    @Override
    public ChestItem generateExplosion() {
        return new Explosion();
    }

    @Override
    public ChestItem generatePit() {
        return new Pit();
    }

    @Override
    public ChestItem generateTeleport() {
        return new Teleport();
    }

    @Override
    public ChestItem generateBeacon() {
        return new Beacon();
    }

    @Override
    public ChestItem generateEnchantedWeapon() {
        return new EnchantedWeapon();
    }

    @Override
    public ChestItem generateHealingPotion() {
        return new HealingPotion();
    }

    @Override
    public ChestItem generateMap() {
        return new Map();
    }

    @Override
    public ChestItem generateMagicSack(){
        return new MagicSack();
    }

}
