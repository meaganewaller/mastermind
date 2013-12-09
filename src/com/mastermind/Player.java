package com.mastermind;

import java.util.List;

public class Player extends AI implements Encoder, Decoder{
	CommandLineInterface cli = new CommandLineInterface();
	
	public void setCommandLineInterface(CommandLineInterface cli) {
		this.cli = cli;
	}

    @Override
    public List<Color> chooseSecretCode(int size) {
        String secretCode = cli.promptCode();
        return cli.convertInput(secretCode);
    }

    @Override
    public List<Color> promptGuess(List<Turn> turns, int size) {
        cli.showBoard(turns);
        cli.promptForGuess();
        String guess = String.valueOf(cli.promptCode());
        return cli.convertInput(guess);

    }
}
