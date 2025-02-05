package fargoal.model.interactable.pickUpAble.inChest.Trap;

public enum TrapType {
    EXPLOSION("EXPLOSION"),
    PIT("PIT"),
    TELEPORT("TELEPORT"),
    CEILING_TRAP("CEILING TRAP");

    private final String name;

    private TrapType(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
