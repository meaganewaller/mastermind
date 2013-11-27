package com.mastermind;

import java.util.ArrayList;
import java.util.List;

import static com.mastermind.Board.getFeedback;

public class Game {
    private Encoder encoder;
    private CommandLineInterface cli;
    private Decoder decoder;

    public void startGame(int size) {
        cli.displayWelcomeMessage();
        List<Color> secretCode = encoder.chooseSecretCode(size);
        List<Turn> turns = new ArrayList<Turn>();
        while(notSolved(turns, size)) {
            List<Color> userGuess = decoder.promptGuess(turns, size);
            Feedback feedback = getFeedback(userGuess, secretCode);
            Turn turn = new Turn(userGuess, feedback);
            turns.add(turn);
        }
        cli.showBoard(turns);
        System.out.println();
    }

    protected boolean notSolved(List<Turn> turns, int size) {
        if (turns.isEmpty()) {
            return true;
        }
        Turn last = turns.get(turns.size() - 1);
        Feedback feedback = last.getFeedback();
        return feedback.getNumberOfX() != size;
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }

    public void setDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    public void setUserInterface(CommandLineInterface cli) {
        this.cli = cli;
    }

}
