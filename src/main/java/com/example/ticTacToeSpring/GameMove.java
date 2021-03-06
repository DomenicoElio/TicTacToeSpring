package com.example.ticTacToeSpring;

import javax.persistence.*;

enum CellStatus {EMPTY, X, O}

enum Player {X, O}

@Entity
@Table(name = "gameTable")
public class GameMove {
    public String table;
    public Player player;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    public GameMove() {
        this(new GameLogic());
    } //calls game logic and allows for a new move

    public GameMove(GameLogic game) { //calls game logic and allows for a new move
        this.player = game.player;
        this.table = GameLogic.serializeTable(game.table);
    }

    public Long getId() {
        return id;
    }
}

