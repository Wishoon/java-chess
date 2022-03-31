package chess.domain.refactorPiece;

import chess.domain.piece.attribute.Color;
import chess.domain.refactorBoard.ChessBoard;
import chess.domain.refactorBoard.Direction;
import chess.domain.refactorPosition.Position;
import java.util.List;

public abstract class MultipleMovablePiece extends Piece {

    private List<Direction> directions;

    MultipleMovablePiece(Color color, String name, List<Direction> directions) {
        super(color, name);
        this.directions = directions;
    }

    @Override
    public boolean isMovable(Position from, Position to, ChessBoard chessBoard) {
        final List<Position> route = calculateRoute(from, to);
        return isEmptyRouteWithToPosition(to, route, chessBoard);
    }

    private List<Position> calculateRoute(Position from, Position to) {
        return directions.stream()
                .map(direction -> direction.route(from, to))
                .filter(route -> !route.isEmpty())
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("이동할 수 있는 경로가 없습니다."));
    }

    private boolean isEmptyRouteWithToPosition(Position to, List<Position> route, ChessBoard chessBoard) {
        return route.stream()
                .filter(position -> !position.equals(to))
                .allMatch(position -> chessBoard.isEmptyPosition(position));
    }
}
