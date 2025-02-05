package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

import fargoal.model.interactable.pickUpAble.inChest.Spell.api.Spell;
import fargoal.model.interactable.pickUpAble.inChest.api.ChestItemType;

public class InvisibilitySpell implements Spell {

    public InvisibilitySpell() {
        this.store();
    }

    @Override
    public String getChestItemType() {
        return ChestItemType.SPELL.getName();
    }

    @Override
    public String getChestItemName() {
        return SpellType.INVISIBILITY.getName();
    }

    @Override
    public void store() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'store'");
    }

    @Override
    public void cast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cast'");
    }
    
}
