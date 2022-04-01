package chess.domain.piece;


import static chess.domain.board.Direction.DOWN;
import static chess.domain.board.Direction.LEFT;
import static chess.domain.board.Direction.RIGHT;
import static chess.domain.board.Direction.TOP;

import chess.domain.piece.attribute.Color;
import java.util.Arrays;

public class Rook extends MultipleMovablePiece {

    private static final String ROOK_INITIAL = "R";

    public Rook(Color color) {
        super(color, ROOK_INITIAL, Arrays.asList(TOP, DOWN, LEFT, RIGHT));
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
