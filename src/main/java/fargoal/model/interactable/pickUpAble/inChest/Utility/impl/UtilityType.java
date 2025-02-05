package fargoal.model.interactable.pickUpAble.inChest.Utility.impl;

/**
 * This is an enumeration of the name of the utilities the player can found in a chest. 
 */
public enum UtilityType {
    ENCHANTED_WEAPON("ENCHANTED WEAPON"),
    HEALING_POTION("HEALING POTION"),
    BEACON("BEACON"),
    MAGIC_SACK("MAGIC SACK"),
    MAP("MAP");

    private final String name;

    /**
     * This is the constructor of the enumeration. It set all the names for the many types of utilities.
     * @param name - it is the name of the utility,
     */
    private UtilityType(final String name){
        this.name = name;
    }

    /**
     * With this method the actual name of the utilities is revealed.
     * @return the name of the utility.
     */
    public String getName(){
        return this.name;
    }
}
