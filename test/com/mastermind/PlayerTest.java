package com.mastermind;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PlayerTest {
	@Test
	public void playerCanChooseSecretCode() {
		Player player = new Player();
		MockCommandLineInterface cli = new MockCommandLineInterface();
		player.setCommandLineInterface(cli);
		cli.setInput("rrrr");
		assertEquals("[red, red, red, red]", player.chooseSecretCode(4).toString());
	}
	
	@Test
	public void playerIsPromptedForGuess() {
		Player player = new Player();
		MockCommandLineInterface cli = new MockCommandLineInterface();
		player.setCommandLineInterface(cli);
		cli.setInput("rrrr");
		List<Turn> turns = new ArrayList<Turn>();
		assertEquals("[red, red, red, red]", player.promptGuess(turns, 4).toString());
	}
}
