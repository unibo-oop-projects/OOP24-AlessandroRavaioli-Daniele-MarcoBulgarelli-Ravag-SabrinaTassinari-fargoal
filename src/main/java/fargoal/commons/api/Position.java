package fargoal.commons.api;

/**
 * A record used for positions on the map for every FloorElement.
 * @param x - the abscissae of the position
 * @param y - the ordinate of the position
 */

public record Position(int x, int y) {

    /**
     * Method to add a position to another selected position.
     * 
     * @param position - the position to add
     * @return the new position, that is the sum
     */
    public Position add(Position position) {
        return new Position(x + position.x(), y + position.y());
    }

    /**
     * Method to deny both the variable of a position.
     * 
     * @param position - the position to be denied
     * @return the new position that has been denied
     */
    public Position negate(Position position) {
        return new Position(-position.x(), -position.y());
    }

    /**
     * Method to deny the variable X of a position.
     * 
     * @param position - the position which the variable X has to be denied
     * @return the new position with the X denied
     */
    public Position negateX(Position position) {
        return new Position(-position.x(), y);
    }

    /**
     * Method to deny the variable Y of a position.
     * 
     * @param position - the position which the variable Y has to be denied
     * @return the new position with the Y denied
     */
    public Position negateY(Position position) {
        return new Position(x, -position.y());
    }

    public Position decreaseX() {
        return new Position(x - 1, y);
    }

    public Position decreaseY() {
        return new Position(x, y - 1);
    }

    public Position increaseX() {
        return new Position(x + 1, y);
    }

    public Position increaseY() {
        return new Position(x, y + 1);
    }
}
