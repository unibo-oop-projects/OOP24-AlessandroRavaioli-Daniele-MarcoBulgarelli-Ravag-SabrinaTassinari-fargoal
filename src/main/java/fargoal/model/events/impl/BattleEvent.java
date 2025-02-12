package fargoal.model.events.impl;

import java.util.List;
import java.util.Random;

/**
 * BattleEvent is a class called everytime that
 * a battle between the player and a monster is underway.
 */
public class BattleEvent {
    private final Random random = new Random();
    private final List<String> list = List.of("Chop!", "Clang!",
            "Ouch!", "Thud!", "Clink!", "Shriek!", "Slash!", "Shred!",
            "Ugh!", "Claw!", "Crunch!", "Gnarl!", "Growl!", "Thump!");
    /**
     * Method that return a random textSound for the battle
     * to be displayed on the screen.
     * 
     * @return a string for the battle
     */
    public String getTextSound() {
        return list.get(random.nextInt(list.size()));
    }
}
