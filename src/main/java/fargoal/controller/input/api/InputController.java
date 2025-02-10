package fargoal.controller.input.api;

/**
 * KEYS:
 * SPACE BAR -> INTERACT
 * ARROW KEYS -> MOVE
 * H -> HEALING POTION
 * B -> PLACE BEACON
 * T -> TELEPORT SPELL
 * S -> SHIELD SPELL
 * D -> DRIFT SPELL
 * R -> REGENERATION SPELL
 * I -> INVISIBILITY SPELL
 * L -> LIGHT SPELL
 */
public interface InputController {

    boolean isMoveUp();
    boolean isMoveDown();
    boolean isMoveLeft();
    boolean isMoveRight();
    boolean isInteracting();

    boolean isUsingHealingPotion();
    boolean isPlacingBeacon();
    boolean isUsingTeleportSpell();
    boolean isUsingShieldSpell();
    boolean isUsingDriftSpell();
    boolean isUsingRegenerationSpell();
    boolean isUsingInvisibilitySpell();
    boolean isUsingLightSpell();
}
