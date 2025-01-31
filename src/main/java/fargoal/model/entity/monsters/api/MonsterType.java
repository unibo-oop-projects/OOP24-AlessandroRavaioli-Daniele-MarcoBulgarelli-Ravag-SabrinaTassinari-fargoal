package fargoal.model.entity.monsters.api;

public enum MonsterType {
    /* an enemy that will always steal when attacking. */
    ROGUE,
    
    /* an enemy that simply attack the player. */
    BARBARIAN,

    /* an enemy that bring with him healing potions and can drink them. */
    MONK,

    /* an enemy who's generally invisible. */
    ASSASSIN,

    /* an enemy that often carry a War Shield. */
    WAR_LORD,

    /* an enemy who instantly steals spells and disguised as one of the other monsters. */
    MAGE,

    /* a monster that have the ability to climb walls. */
    SPIDER
}
