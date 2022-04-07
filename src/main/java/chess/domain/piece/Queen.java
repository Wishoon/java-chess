package chess.domain.piece;

import java.util.List;
import chess.domain.board.Direction;
import chess.domain.board.Position;

public class Queen extends Piece {

    public Queen(PieceColor pieceColor, Position position) {
        super(PieceType.QUEEN, pieceColor, position);
    }

    @Override
    public Direction findByDirection(Position from, Position to) {
        final int column = to.getColumn() - from.getColumn();
        final int row = to.getRow() - from.getRow();

        return Direction.ofAll(column, row);
    }

    @Override
    protected List<Direction> findByMovableDirection(Piece piece, Direction direction) {
        return Direction.EVERY_DIRECTION;
    }

    @Override
    public boolean isKing() {
        return false;
    }

    @Override
    public boolean isPawn() {
        return false;
    }
}
