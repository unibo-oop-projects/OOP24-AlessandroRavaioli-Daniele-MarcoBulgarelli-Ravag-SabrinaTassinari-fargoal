package fargoal.model.interactable.pickUpAble.inChest.api;

/**
 * This is an enumeration of the types the player can found in a chest. 
 * Inside he can found traps, spells or utilities.
 */
public enum ChestItemType {
    TRAP("TRAP"),
    SPELL("SPELL"),
    UTILITY("UTILITY");

    private final String name;

    /**
     * This is the constructor of the enumeration.
     * @param name - it is the name of the chest item type.
     */
    private ChestItemType(final String name){
        this.name = name;
    }

    /**
     * With this method, the actual name of the type of the chest item can be revealed
     * @return the name of the chest item's type
     */
    public String getName(){
        return this.name;
    }
}
