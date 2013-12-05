package com.mastermind;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertSame;

public class CommandLineInterfaceTest {
    private CommandLineInterface cli = new CommandLineInterface();
    @Test
    public void itConvertsInputToProperColor() {
        String userGuess = "y, r, b, g";
        List<Color> actual = cli.convertInput(userGuess);
        List<Color> expected = Arrays.asList(Color.yellow, Color.red, Color.blue, Color.green);
        assertEquals(expected, actual);
    }

    @Test
    public void convertUserGuessToAllLowerCase() {
        String userGuess = "GBRY";
        List<Color> code = cli.convertInput(userGuess);
        List<Color> expected = Arrays.asList(Color.green, Color.blue, Color.red, Color.yellow);
        assertEquals(expected, code);
    }

    @Test
    public void convertUserGuessWithBadInput() {
        String userGuess = "y.r,b g";
        List<Color> code = cli.convertInput(userGuess);
        List<Color> expected = Arrays.asList(Color.yellow, Color.red, Color.blue, Color.green);
        assertEquals(expected, code);
    }

    @Test
    public void keepsGuessHistory() {
        List<Color> color = Arrays.asList(Color.purple, Color.yellow, Color.green, Color.blue);
        Feedback feedback = new Feedback(1, 2);
        Turn turn = new Turn(color, feedback);
        turn.setGuess(color);
        turn.setFeedback(feedback);
        String actual = cli.convertOutput(turn);
        String expected = "--------------\n|pygb|  |XOO |";
        assertEquals(expected, actual);
    }

    @Test
    public void itDisplaysAWelcomeMessage() {
        OutputStream outputStream = new MockOutputStream();
        MockPrintStream printStream = new MockPrintStream(outputStream);
        printStream.setStringHistory(new ArrayList<String>());
        cli.setOutput(printStream);
        cli.displayWelcomeMessage();
        assertEquals("[Welcome to Mastermind!, The code is made up from 4 colors, the initials of the colors are r, g, y, b, p, o (red, green, yellow, blue, purple, orange), Good luck!\n]", printStream.getStringHistory().toString());
    }


    @Test
    public void promptsForUsersGuess() {
        OutputStream outputStream = new MockOutputStream();
        MockPrintStream printStream = new MockPrintStream(outputStream);
        printStream.setStringHistory(new ArrayList<String>());
        cli.setOutput(printStream);
        cli.promptForGuess();
        assertEquals("[Enter Your Guess: ]", printStream.getStringHistory().toString());
    }

    @Test
    public void itConvertsGuessToAString() {
        List<Color> guess = Arrays.asList(Color.purple, Color.purple, Color.blue, Color.blue);
        String actual = cli.guessToString(guess);
        String expected = "ppbb";
        assertEquals(expected, actual);
    }

    @Test
    public void itCanRepeatAString() {
        String input = "X";
        Integer times = 4;
        String actual = cli.repeatString(input, times);
        String expected = "XXXX";
        assertEquals(expected, actual);
    }


}
