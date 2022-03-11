package com.example.ticTacToeSpring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

class NotNotFoundException extends RuntimeException {
    NotNotFoundException(String message) {
        super(message);
    }


    @RestController
    public static class TicTacToeSpringMoveController {

        private final TicTacToeSpringMoveRepository ticTacToeSpringMoveRepository;

        public TicTacToeSpringMoveController(TicTacToeSpringMoveRepository ticTacToeSpringMoveRepository) {
            this.ticTacToeSpringMoveRepository = ticTacToeSpringMoveRepository;
        }

        @PostMapping("/CreateNewGame")
        public TicTacToeSpringMove createNewGame() {
            TicTacToeSpringMove move = new TicTacToeSpringMove();
            return ticTacToeSpringMoveRepository.save(move);
        }

        /*@PostMapping("/MakeMove")
        public TicTacToeSpringMove makeMove(@RequestParam int i, @RequestParam int j) {
            var move = TicTacToeSpringMoveRepository.findTopByOrderByIdDesc().get();
            return ticTacToeSpringMoveRepository.save(move);
        }*/
    }
}
