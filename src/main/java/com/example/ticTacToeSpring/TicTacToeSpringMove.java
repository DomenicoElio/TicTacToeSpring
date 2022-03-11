package com.example.ticTacToeSpring;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Optional;

@Entity
public class TicTacToeSpringMove {

    public String gameTableSerialized;
    Player currentPlayer;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    public TicTacToeSpringMove() {
        this.currentPlayer = Player.X;
        this.gameTableSerialized = "W,W,W;W,W,W;W,W,W";
    }

    public TicTacToeSpringMove(TicTacToeSpringLogic ticTacToeSpringLogic) {
        this.currentPlayer = ticTacToeSpringLogic.currentPlayer;
        this.gameTableSerialized = Arrays.deepToString(ticTacToeSpringLogic.gameTable);
    }

    static private Optional<Player> getWinner(CellStatus c) {
        return Optional.empty();
    }

    public Long getId() {
        return id;
    }
}


