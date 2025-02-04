package fargoal.model.interactable.pickUpAble.inChest.Spell.api;

import fargoal.model.interactable.pickUpAble.inChest.api.ChestItem;

public interface Spell extends ChestItem {

    public void store();

    public void cast();
}
