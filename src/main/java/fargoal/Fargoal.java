package fargoal;

import fargoal.model.core.GameEngine;

/**
 * this class is the entry point of the application fargoal
 */
public class Fargoal {

    private Fargoal() { }

    /**
     * starts the application
     * 
     * @param args
     */
    public static void main(final String[] args) {
        new GameEngine().start();
    }
}
