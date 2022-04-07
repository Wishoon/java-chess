package chess.domain.board;

import java.util.Iterator;
import java.util.Objects;

public class MovePath implements Iterator<Position> {

    private final Position to;
    private final Direction direction;
    private Position from;

    public MovePath(Position from, Position to, Direction direction) {
        this.from = from;
        this.to = to;
        this.direction = direction;
    }

    public Position getFrom() {
        return from;
    }

    public Position getTo() {
        return to;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean hasNext() {
        return from.add(direction.getColumn(), direction.getRow()) != to;
    }

    @Override
    public Position next() {
        return from.add(direction.getColumn(), direction.getRow());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MovePath)) {
            return false;
        }
        MovePath movePath = (MovePath) o;
        return Objects.equals(from, movePath.from) && Objects.equals(to, movePath.to)
                && direction == movePath.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, direction);
    }

    @Override
    public String toString() {
        return "MovePath{" +
                "from=" + from +
                ", to=" + to +
                ", direction=" + direction +
                '}';
    }
}
