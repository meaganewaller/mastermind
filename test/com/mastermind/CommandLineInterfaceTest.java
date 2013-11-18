package com.mastermind;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CommandLineInterfaceTest {
    private CommandLineInterface cli = new CommandLineInterface();

    @Test
    public void convertUserGuessToCode() {
        String userGuess = "yrbg";
        List<Color> code = cli.convertInput(userGuess);
        List<Color> expected = Arrays.asList(Color.yellow, Color.red, Color.blue, Color.green);
        assertEquals(expected, code);
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
}
