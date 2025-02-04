package fargoal.model.interactable.pickUpAble.inChest.api;

public interface ChestItemFactory {
    
    ChestItem generateSpell();

    ChestItem generateTrap();

    ChestItem generateUtility();
}
