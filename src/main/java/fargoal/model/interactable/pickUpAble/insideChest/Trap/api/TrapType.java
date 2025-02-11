package fargoal.model.interactable.pickUpAble.insideChest.Trap.api;

/**
 * This is an enumeration of the name of the traps the player can found in a chest. 
 */
public enum TrapType {
    EXPLOSION("EXPLOSION"),
    PIT("PIT"),
    TELEPORT("TELEPORT"),
    CEILING_TRAP("CEILING TRAP");

    private final String name;

    /**
     * This is the constructor of the enumeration. It set all the names for the many types of traps.
     * @param name - it is the name of the trap.
     */
    private TrapType(final String name){
        this.name = name;
    }

    /**
     * With this method the actual name of the trap is revealed.
     * @return the name of the trap.
     */
    public String getName(){
        return this.name;
    }
}
