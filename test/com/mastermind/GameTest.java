package com.mastermind;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

public class GameTest {


    @Test
    public void displaysWelcomeMessage() {
        Game game = new Game();
        MockDecoder decoder = new MockDecoder();
        MockEncoder encoder = new MockEncoder();
        List<Color> sequenceOfColors = Arrays.asList(Color.blue, Color.green, Color.blue, Color.green);
        decoder.addGuess(sequenceOfColors);
        encoder.secretCode = sequenceOfColors;
        MockCommandLineInterface cli = new MockCommandLineInterface();
        game.setDecoder(decoder);
        game.setEncoder(encoder);
        game.setUserInterface(cli);

        game.startGame(sequenceOfColors.size());

        assertTrue(cli.welcomeMessageWasDisplayed());
    }

    @Test
    public void showsInitialBoard() {
        Game game = new Game();
        MockDecoder decoder = new MockDecoder();
        MockEncoder encoder = new MockEncoder();
        MockCommandLineInterface cli = new MockCommandLineInterface();
        List<Color> sequenceOfColors = Arrays.asList(Color.blue, Color.green, Color.blue, Color.green);
        decoder.addGuess(sequenceOfColors);
        encoder.secretCode = sequenceOfColors;
        game.setDecoder(decoder);
        game.setEncoder(encoder);
        game.setUserInterface(cli);
        game.startGame(sequenceOfColors.size());
        assertSame(1, cli.numberOfTimesShowBoardDisplayed());
    }



}
