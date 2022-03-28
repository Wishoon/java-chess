package chess.view;

import chess.domain.board.Board;
import chess.domain.board.File;
import chess.domain.board.Position;
import chess.domain.board.Rank;
import chess.domain.game.Status;
import chess.domain.piece.attribute.Color;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class OutputView {
    private static final String SEPARATOR = System.lineSeparator();
    private static final String ARROW = "> ";
    private static final String TEAM_STATUS = "%s 점수 : %.1f졈" + SEPARATOR;
    private static final String WINNER_TEAM = "게임 결과 : %s 승" + SEPARATOR;
    private static final String DRAW = "무승부";
    private static final String INIT_MESSAGE =
            ARROW + "체스 게임을 시작합니다." + SEPARATOR
                    + ARROW + "게임 시작 : start" + SEPARATOR
                    + ARROW + "게임 종료 : end" + SEPARATOR
                    + ARROW + "게임 이동 : move source위치 target위치 - 예. move b2 b3";

    public static void printInitMessage() {
        System.out.println(INIT_MESSAGE);
    }

    public static void printChessBoard(Board board) {
        List<Rank> ranks = Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        for (Rank rank : ranks) {
            for (File file : File.values()) {
                System.out.print(board.findByPiece(new Position(file, rank)).getName());
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printStatus(Map<Color, Double> colorsTotalScore) {
        for (Entry<Color, Double> entry : colorsTotalScore.entrySet()) {
            System.out.printf(TEAM_STATUS, entry.getKey().name(), entry.getValue());
        }
    }

    public static void printGameResult(Color winnerColor) {
        System.out.printf(WINNER_TEAM, winnerColor.name());
    }
}
