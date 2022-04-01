package chess.domain.game;

import chess.domain.piece.attribute.Color;
import java.util.Map;

public class Status {

    private final Color winnerColor;

    public Status(Map<Color, Double> colorsTotalScore) {
        this.winnerColor = judgeWinner(colorsTotalScore);
    }

    private Color judgeWinner(Map<Color, Double> colorsTotalScore) {
        if (colorsTotalScore.get(Color.BLACK) < colorsTotalScore.get(Color.WHITE)) {
            return Color.WHITE;
        }
        if (colorsTotalScore.get(Color.BLACK) > colorsTotalScore.get(Color.WHITE)) {
            return Color.BLACK;
        }
        return Color.NONE;
    }

    public Color getWinnerColor() {
        return winnerColor;
    }
}
