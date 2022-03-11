package com.example.ticTacToeSpring;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

enum CellStatus {EMPTY, X, O}

enum Player {X, O}

class InvalidTicTacToeInput extends RuntimeException {
    InvalidTicTacToeInput(String msg) {
        super(msg);
    }
}

public class TicTacToeSpringLogic {
    CellStatus[][] gameTable = new CellStatus[3][3];
    Player currentPlayer;

    TicTacToeSpringLogic() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                gameTable[i][j] = CellStatus.EMPTY;

        currentPlayer = Player.X;
    }

    static private boolean isWinning(CellStatus c0, CellStatus c1, CellStatus c2) {
        return c0 != CellStatus.EMPTY && c0 == c1 && c1 == c2;
    }

    public void printBoard() {
        for (var row : gameTable) {
            for (var cell : row)
                System.out.print(cell == CellStatus.EMPTY ? "." : cell.toString());
            System.out.println();
        }
    }

    public void makeMove(int i, int j) throws InvalidTicTacToeInput {
        if (i < 0 || i > 2 || j < 0 || j > 2) {
            throw new InvalidTicTacToeInput("Out of Bounds");
        }

        if (gameTable[i][j] != CellStatus.EMPTY) {
            throw new InvalidTicTacToeInput("Position already used");
        }

        gameTable[i][j] = currentPlayer == Player.X ? CellStatus.X : CellStatus.O;
        currentPlayer = currentPlayer == Player.X ? Player.O : Player.X;
    }

    public Optional<Player> getTheWinner() {
        var g = this.gameTable;

        if (isWinning(g[0][0], g[0][1], g[0][2])) {
            return Optional.of(g[0][0] == CellStatus.X ? Player.X : Player.O);
        }
        if (g[1][0] != CellStatus.EMPTY && g[1][0] == g[1][1] && g[1][1] == g[1][2]) {
            return Optional.of(g[1][0] == CellStatus.X ? Player.X : Player.O);
        }
        if (g[2][0] != CellStatus.EMPTY && g[2][0] == g[2][1] && g[2][1] == g[2][2]) {
            return Optional.of(g[2][0] == CellStatus.X ? Player.X : Player.O);
        }

        if (g[0][0] != CellStatus.EMPTY && g[0][0] == g[1][0] && g[1][0] == g[2][0]) {
            return Optional.of(g[0][0] == CellStatus.X ? Player.X : Player.O);
        }
        if (g[0][1] != CellStatus.EMPTY && g[0][1] == g[1][1] && g[1][1] == g[2][1]) {
            return Optional.of(g[0][1] == CellStatus.X ? Player.X : Player.O);
        }
        if (g[0][2] != CellStatus.EMPTY && g[0][2] == g[1][2] && g[1][2] == g[2][2]) {
            return Optional.of(g[0][2] == CellStatus.X ? Player.X : Player.O);
        }

        if (g[0][0] != CellStatus.EMPTY && g[0][0] == g[1][1] && g[1][1] == g[2][2]) {
            return Optional.of(g[0][0] == CellStatus.X ? Player.X : Player.O);
        }
        if (g[0][2] != CellStatus.EMPTY && g[0][2] == g[1][1] && g[1][1] == g[2][0]) {
            return Optional.of(g[0][2] == CellStatus.X ? Player.X : Player.O);
        }

        return Optional.empty();
    }

    public boolean isDraw() {
        for (var row : gameTable)
            for (var l : row)
                if (l == CellStatus.EMPTY)
                    return false;

        return true;
    }

    public String gameTableSerialized(TicTacToeSpringLogic ticTacToeSpringLogic) {
        return Arrays.stream(ticTacToeSpringLogic.gameTable)
                .map(x -> Arrays.stream(x).map(Enum::toString).collect(Collectors.joining(",")))
                .collect(Collectors.joining(";"));
    }
}
