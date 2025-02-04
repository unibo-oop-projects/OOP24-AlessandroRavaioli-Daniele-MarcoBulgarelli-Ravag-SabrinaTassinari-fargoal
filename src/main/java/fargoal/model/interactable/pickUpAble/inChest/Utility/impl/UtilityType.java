package fargoal.model.interactable.pickUpAble.inChest.Utility.impl;

public enum UtilityType {
    ENCHANTED_WEAPON("ENCHANTED WEAPON"),
    HEALING_POTION("HEALING POTION"),
    BEACON("BEACON"),
    MAGIC_SACK("MAGIC SACK"),
    MAP("MAP");

    private final String name;

    private UtilityType(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
