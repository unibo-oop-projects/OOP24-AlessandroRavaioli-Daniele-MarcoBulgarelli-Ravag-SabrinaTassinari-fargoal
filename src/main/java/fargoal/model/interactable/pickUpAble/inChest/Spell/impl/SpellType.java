package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

/**
 * This is an enumeration of the spells the player can found in a chest. 
 */
public enum SpellType {
    SHIELD("SHIELD SPELL"),
    INVISIBILITY("INVISIBILITY SPELL"),
    LIGHT("LIGHT SPELL"),
    DRIFT("DRIFT SPELL"),
    TELEPORT("TELEPORT SPELL"),
    REGENERATION("REGENERATION SPELL");

    private final String name;

    /**
     * This is the constructor of the enumeration.
     * @param name - it is the name of the spell.
     */
    private SpellType(final String name){
        this.name = name;
    }

    /**
     * With this method, the actual name of the spell can be revealed
     * @return the name of the spell
     */
    public String getName(){
        return this.name;
    }
}
