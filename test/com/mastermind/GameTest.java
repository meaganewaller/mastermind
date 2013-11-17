package com.mastermind;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameTest {

    @Test
    public void returnsAllBlackWhenCorrectCode() {
        Code secretCode = new Code(Color.red, Color.green, Color.blue, Color.yellow);
        Game game = new Game(secretCode);
        Feedback feedback = game.getFeedback(new Code(Color.red, Color.green, Color.blue, Color.yellow));
        assertEquals(new Integer(4), feedback.getNumberOfBlack());
        assertEquals(new Integer(0), feedback.getNumberOfWhite());
    }
}
