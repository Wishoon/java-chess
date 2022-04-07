package chess.domain.piece;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import chess.domain.board.Direction;
import chess.domain.board.Position;

class PieceTest {

    @Test
    @DisplayName("기물을 생성할 수 있다.")
    void createValidPiece() {
        assertDoesNotThrow(PieceTest::getFakePiece);
    }

    private static Piece getFakePiece() {
        return new Piece(PieceType.NO_PIECE, PieceColor.NONE, Position.valueOf("a1")) {
            @Override
            protected Direction findByDirection(Position from, Position to) {
                return null;
            }

            @Override
            protected List<Direction> findByMovableDirection(Piece piece, Direction direction) {
                return null;
            }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isPawn() {
                return false;
            }
        };
    }
}
