package fargoal.model.interactable.pickUpAble.inChest.impl;

import java.util.Random;

import fargoal.commons.api.Position;
import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.Chest;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;
import fargoal.model.manager.api.FloorManager;

public class ChestImpl implements Chest{

    final static int N_CHEST_ITEM = 15;
    final private Position position;
    private boolean open;

    public ChestImpl(final Position position) {
        this.position = position;
        this.open = false;
    }

    public boolean isOpen() {
        return this.open;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public boolean isColliding() {
        return false;
    }

    @Override
    public String getTag() {
        return "CHEST";
    }

    /*generare casualmente un chestItem (lo faccio quando la cassa viene aperta) */
    @Override
    public String getChestItem() {
        int num = new Random().nextInt(N_CHEST_ITEM);
        ChestItem item;
        if (num == 0) {
            item = new ChestItemFactoryImpl().generateDriftSpell();
        } else if (num == 1) {
            item = new ChestItemFactoryImpl().generateInvisibilitySpell();
        } else if (num == 2) {
            item = new ChestItemFactoryImpl().generateLightSpell();
        } else if (num == 3) {
            item = new ChestItemFactoryImpl().generateRegenerationSpell();
        } else if (num == 4) {
            item = new ChestItemFactoryImpl().generateShieldSpell();
        } else if (num == 5) {
            item = new ChestItemFactoryImpl().generateTeleportSpell();
        } else if (num == 6) {
            item = new ChestItemFactoryImpl().generateCeilingTrap();
        } else if (num == 7) {
            item = new ChestItemFactoryImpl().generateExplosion();
        } else if (num == 8) {
            item = new ChestItemFactoryImpl().generatePit();
        } else if (num == 9) {
            item = new ChestItemFactoryImpl().generateTeleport();
        } else if (num == 10) {
            item = new ChestItemFactoryImpl().generateBeacon();
        } else if (num == 11) {
            item = new ChestItemFactoryImpl().generateEnchantedWeapon();
        } else if (num == 12) {
            item = new ChestItemFactoryImpl().generateEnchantedWeapon();
        } else if (num == 13) {
            item = new ChestItemFactoryImpl().generateHealingPotion();
        } else if (num == 14) {
            item = new ChestItemFactoryImpl().generateMap();
        } else {
            item = new ChestItemFactoryImpl().generateMagicSack();
        }
        return item.getChestItemName();
    }

    /*apri la cesta con barra spaziatrice quando ci sei vicino*/
    @Override
    public void interact() {
        String item = this.getChestItem();
    }

    @Override
    public void update(FloorManager floorManager) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
