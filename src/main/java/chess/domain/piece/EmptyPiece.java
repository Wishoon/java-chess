package chess.domain.piece;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.piece.attribute.Color;
import chess.domain.piece.attribute.Name;

public class EmptyPiece extends Piece {
    public EmptyPiece() {
        super(new Name("."), Color.NONE, null);
    }

    @Override
    public boolean canMove(Board board, Position from, Position to) {
        throw new IllegalArgumentException("해당 칸에는 움직일 기물이 없습니다.");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
