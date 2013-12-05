package com.mastermind;

import java.util.List;

public class Player extends AI implements Encoder, Decoder{
    private CommandLineInterface cli = new CommandLineInterface();

    @Override
    public List<Color> chooseSecretCode(int size) {
        return cli.promptCode();
    }

    @Override
    public List<Color> promptGuess(List<Turn> turns, int size) {
        cli.showBoard(turns);
        cli.promptForGuess();
        return cli.promptCode();

    }
}
