package com.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

public class GameTest {
    Game game = new Game();
    MockDecoder decoder = new MockDecoder();
    MockEncoder encoder = new MockEncoder();
    MockCommandLineInterface cli = new MockCommandLineInterface();

    @Before
    public void setUp() {
        game.setDecoder(decoder);
        game.setEncoder(encoder);
        game.setUserInterface(cli);
    }

    @Test
    public void displaysWelcomeMessage() {
        List<Color> sequenceOfColors = Arrays.asList(Color.blue, Color.green, Color.blue, Color.green);
        decoder.addGuess(sequenceOfColors);
        encoder.secretCode = sequenceOfColors;
        game.gameSetUp();
        assertTrue(cli.welcomeMessageWasDisplayed());
    }

    @Test
    public void showsInitialBoard() {
        List<Color> sequenceOfColors = Arrays.asList(Color.blue, Color.green, Color.blue, Color.green);
        decoder.addGuess(sequenceOfColors);
        encoder.secretCode = sequenceOfColors;
        game.startGame(sequenceOfColors.size());
        assertSame(1, cli.numberOfTimesShowBoardDisplayed());
    }
    
    @Test
    public void canSetAsAIAsEncoder() {
    	MockCommandLineInterface cli = new MockCommandLineInterface();
    	cli.setInput("n");
    	game.setCodeMaker();
    	assertSame("", game.getEncoder());
    }

}
