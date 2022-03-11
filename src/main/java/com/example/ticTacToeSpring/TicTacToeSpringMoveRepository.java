package com.example.ticTacToeSpring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicTacToeSpringMoveRepository extends JpaRepository<TicTacToeSpringMove, Long> {
    Optional<TicTacToeSpringMove> findTopByOrderByIdDesc();
}