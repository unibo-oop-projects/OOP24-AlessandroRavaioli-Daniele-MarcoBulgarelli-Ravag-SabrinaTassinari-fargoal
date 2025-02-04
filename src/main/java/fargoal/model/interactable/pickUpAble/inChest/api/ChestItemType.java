package fargoal.model.interactable.pickUpAble.inChest.api;

public enum ChestItemType {
    TRAP("TRAP"),
    SPELL("SPELL"),
    UTILITY("UTILITY");

    private final String name;

    private ChestItemType(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
