package commons.api;

public record Position(int x, int y) {

    public Position add(Position position) {
        return new Position(x + position.x(), y + position.y());
    }

    public Position negate(Position position) {
        return new Position(-position.x(), -position.y());
    }

    public Position negateX(Position position) {
        return new Position(-position.x(), y);
    }

    public Position negateY(Position position) {
        return new Position(x, -position.y());
    }
}
