package com.mastermind;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertSame;

public class BoardTest {

    @Test
    public void returnsAllBlackWhenCorrectCode() {
        List<Color> userGuess = Arrays.asList(Color.yellow, Color.blue, Color.orange, Color.green);
        List<Color> secretCode = Arrays.asList(Color.yellow, Color.blue, Color.orange, Color.green);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(4, feedback.getNumberOfBlack());
        assertSame(0, feedback.getNumberOfWhite());
    }


    @Test
    public void returns3Black() {
        List<Color> userGuess = Arrays.asList(Color.purple, Color.red, Color.blue, Color.green);
        List<Color> secretCode = Arrays.asList(Color.purple, Color.red, Color.blue, Color.orange);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(3, feedback.getNumberOfBlack());
        assertSame(0, feedback.getNumberOfWhite());
    }


    @Test
    public void returns1Black3White() {
        List<Color> userGuess = Arrays.asList(Color.orange, Color.blue, Color.green, Color.yellow);
        List<Color> secretCode=  Arrays.asList(Color.orange, Color.green, Color.yellow, Color.blue);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(1, feedback.getNumberOfBlack());
        assertSame(3, feedback.getNumberOfWhite());
    }

    @Test
    public void returns2Black1White() {
        List<Color> userGuess = Arrays.asList(Color.purple, Color.green, Color.red, Color.orange);
        List<Color> secretCode = Arrays.asList(Color.purple, Color.green, Color.orange, Color.blue);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(2, feedback.getNumberOfBlack());
        assertSame(1, feedback.getNumberOfWhite());
    }

    @Test
    public void returns1Black1White() {
        List<Color> userGuess = Arrays.asList(Color.red, Color.green, Color.blue, Color.purple);
        List<Color> secretCode = Arrays.asList(Color.red, Color.blue, Color.orange, Color.yellow);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(1, feedback.getNumberOfBlack());
        assertSame(1, feedback.getNumberOfWhite());
    }

    @Test
    public void returns0Black4White() {
        List<Color> userGuess = Arrays.asList(Color.red, Color.blue, Color.orange, Color.yellow);
        List<Color> secretCode = Arrays.asList(Color.orange, Color.yellow, Color.red, Color.blue);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(0, feedback.getNumberOfBlack());
        assertSame(4, feedback.getNumberOfWhite());
    }


}
