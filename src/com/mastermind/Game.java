package com.mastermind;

import java.util.ArrayList;
import java.util.List;

import static com.mastermind.Board.getFeedback;

public class Game {

    private CommandLineInterface cli = new CommandLineInterface();
    private Encoder encoder;
    private Decoder decoder;


    public void startGame(int size) {

        List<Color> secretCode = encoder.chooseSecretCode(size);
        List<Turn> turns = new ArrayList<Turn>();
        cli.displayWelcomeMessage();
        while(notSolved(turns, size)) {
            List<Color> userGuess = decoder.promptGuess(turns, size);
            Feedback feedback = getFeedback(userGuess, secretCode);
            Turn turn = new Turn(userGuess, feedback);
            turns.add(turn);
        }
        cli.showBoard(turns);
        System.out.println();
    }

    private boolean notSolved(List<Turn> turns, int size) {
        if (turns.isEmpty()) {
            return true;
        }
        Turn last = turns.get(turns.size() - 1);
        Feedback feedback = last.getFeedback();
        return feedback.getNumberOfBlack() != size;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setEncoder(new Player());
        game.setDecoder(new AI());
        game.startGame(4);
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }


}
