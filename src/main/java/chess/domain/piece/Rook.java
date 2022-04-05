package chess.domain.piece;

import chess.domain.board.Direction;
import chess.domain.board.Position;
import java.util.List;

public class Rook extends Piece {

    public Rook(PieceColor pieceColor, Position position) {
        super(PieceType.ROOK, pieceColor, position);
    }

    @Override
    public List<Direction> findByMovableDirection(Piece piece, Direction direction) {
        return Direction.LINEAR_DIRECTION;
    }

    @Override
    public Direction findByDirection(Position from, Position to) {
        final int column = to.getColumn() - from.getColumn();
        final int row = to.getRow() - from.getRow();

        return Direction.ofLinear(column, row);
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
