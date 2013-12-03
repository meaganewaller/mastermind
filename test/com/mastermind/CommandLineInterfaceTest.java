package com.mastermind;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
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

        MockOutputStream out = new MockOutputStream();
        PrintStream printStream = new PrintStream(out);
        cli.setOutput(printStream);
        cli.displayWelcomeMessage();
        assertEquals("", out.getStringHistory());
    }


    @Test
    public void itPromptsForTheUsersGuess() {

        // Mock System.out and assert that it displays "Enter Guess: "
    }

    @Test
    public void itGetsAUsersGuess() {
        // Mock System.in and readLine to ensure that it gets a user's guess
    }

    @Test
    public void itConvertsFeedbackToString() {
        // Mock feedback to pass into the CLI
        // Assert that it displays proper string for given feedback
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
