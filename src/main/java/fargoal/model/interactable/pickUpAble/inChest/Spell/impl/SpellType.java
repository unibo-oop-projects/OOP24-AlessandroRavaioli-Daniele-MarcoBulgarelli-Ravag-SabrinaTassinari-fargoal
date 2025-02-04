package fargoal.model.interactable.pickUpAble.inChest.Spell.impl;

public enum SpellType {
    SHIELD("SHIELD SPELL"),
    INVISIBILITY("INVISIBILITY SPELL"),
    LIGHT("LIGHT SPELL"),
    DRIFT("DRIFT SPELL"),
    TELEPORT("TELEPORT SPELL"),
    REGENERATION("REGENERATION SPELL");

    private final String name;

    private SpellType(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
