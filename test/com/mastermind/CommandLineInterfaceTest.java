package com.mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
        assertEquals("Enter Your Guess: ", printStream.lastOutput());
    }

    @Test
    public void getsCodeFromUser() throws IOException {
        MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(cli.input));
        cli.setBufferedReader(bufferedReader);
        bufferedReader.setInputHistory(new ArrayList<String>(Arrays.asList("rrrr")));
        cli.promptCode();
        assertEquals("rrrr", bufferedReader.readLine());

    }
    
    @Test
    public void showsTheBoard() throws IOException {
    	OutputStream outputStream = new MockOutputStream();
    	MockPrintStream printStream = new MockPrintStream(outputStream);
    	printStream.setStringHistory(new ArrayList<String>());
    	cli.setOutput(printStream);
    	List<Color> guess = Arrays.asList(Color.red, Color.red, Color.red, Color.red);
    	MockFeedback feedback = new MockFeedback(1,1);
    	MockTurn turn = new MockTurn(guess, feedback);
    	List<Turn> turns = new ArrayList<Turn>();
    	turns.add(turn);
    	cli.showBoard(turns);
    	assertEquals("--------------\n|rrrr|  |XO  |", printStream.lastOutput());

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
