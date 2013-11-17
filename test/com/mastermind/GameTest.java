package com.mastermind;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameTest {
    Code secretCode = new Code(Color.red, Color.green, Color.blue, Color.yellow);
    Game game = new Game(secretCode);

    @Test
    public void returnsAllBlackWhenCorrectCode() {
        Feedback feedback = game.getFeedback(new Code(Color.red, Color.green, Color.blue, Color.yellow));
        assertEquals(new Integer(4), feedback.getNumberOfBlack());
        assertEquals(new Integer(0), feedback.getNumberOfWhite());
    }

    @Test
    public void return2BlacksAnd2WhitesWhen2CorrectOrder2Unordered() {
        Feedback feedback = game.getFeedback(new Code(Color.green, Color.red, Color.blue, Color.yellow));
        assertEquals(new Integer(2), feedback.getNumberOfBlack());
        assertEquals(new Integer(2), feedback.getNumberOfWhite());
    }

    @Test
    public void return2BlacksAnd2WhitesWhen2Unordered2CorrectOrder() {
        Feedback feedback = game.getFeedback(new Code(Color.red, Color.green, Color.yellow, Color.blue));
        assertEquals(new Integer(2), feedback.getNumberOfBlack());
        assertEquals(new Integer(2), feedback.getNumberOfWhite());
    }

    @Test
    public void return1BlackAnd2WhiteWhen1Correct2Unordered() {
        Feedback feedback = game.getFeedback(new Code(Color.red, Color.blue, Color.green, Color.orange));
        assertEquals(new Integer(1), feedback.getNumberOfBlack());
        assertEquals(new Integer(2), feedback.getNumberOfWhite());
    }

}
