package com.mastermind;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertSame;

public class BoardTest {
    @Test
    public void returns4XForFeedbackWhenCorrectCode() {
        List<Color> userGuess = Arrays.asList(Color.yellow, Color.blue, Color.orange, Color.green);
        List<Color> secretCode = Arrays.asList(Color.yellow, Color.blue, Color.orange, Color.green);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(4, feedback.getNumberOfX());
        assertSame(0, feedback.getNumberOfO());
    }


    @Test
    public void returns3XForFeedBack() {
        List<Color> userGuess = Arrays.asList(Color.purple, Color.red, Color.blue, Color.green);
        List<Color> secretCode = Arrays.asList(Color.purple, Color.red, Color.blue, Color.orange);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(3, feedback.getNumberOfX());
        assertSame(0, feedback.getNumberOfO());
    }


    @Test
    public void returns3XAnd1OForFeedback() {
        List<Color> userGuess = Arrays.asList(Color.orange, Color.blue, Color.green, Color.yellow);
        List<Color> secretCode=  Arrays.asList(Color.orange, Color.green, Color.yellow, Color.blue);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(1, feedback.getNumberOfX());
        assertSame(3, feedback.getNumberOfO());
    }

    @Test
    public void returns2XAnd1OForFeedback() {
        List<Color> userGuess = Arrays.asList(Color.purple, Color.green, Color.red, Color.orange);
        List<Color> secretCode = Arrays.asList(Color.purple, Color.green, Color.orange, Color.blue);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(2, feedback.getNumberOfX());
        assertSame(1, feedback.getNumberOfO());
    }

    @Test
    public void returns1XAnd1OForFeedback() {
        List<Color> userGuess = Arrays.asList(Color.red, Color.green, Color.blue, Color.purple);
        List<Color> secretCode = Arrays.asList(Color.red, Color.blue, Color.orange, Color.yellow);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(1, feedback.getNumberOfX());
        assertSame(1, feedback.getNumberOfO());
    }

    @Test
    public void returns4OForFeedback() {
        List<Color> userGuess = Arrays.asList(Color.red, Color.blue, Color.orange, Color.yellow);
        List<Color> secretCode = Arrays.asList(Color.orange, Color.yellow, Color.red, Color.blue);
        Feedback feedback = Board.getFeedback(userGuess, secretCode);
        assertSame(0, feedback.getNumberOfX());
        assertSame(4, feedback.getNumberOfO());
    }


}
