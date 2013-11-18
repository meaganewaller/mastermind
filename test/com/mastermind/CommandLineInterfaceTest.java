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
}
