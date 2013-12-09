package com.mastermind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

public class AITest {
    private AI ai = new AI();

    @Test
    public void generatesACodeWithSameSizePassedIn() {
        List<Color> secretCode = ai.chooseSecretCode(4);
        assertEquals(4, secretCode.size());
    }

    @SuppressWarnings("deprecation")
	@Test // this fails sometimes because idk how to test randomness.
    public void generatesARandomCode() {
        List<Color> secretCode =  ai.chooseSecretCode(4);
        assertNotSame(secretCode.get(0), secretCode.get(1));
    }

    @Test
    public void allCodesWithSizeOne() {
        List<List<Color>> oneSecretCode = ai.allCodes(1);
        assertEquals(6, oneSecretCode.size()); // 6 to the power of 1
        for (List<Color> code : oneSecretCode) {
            assertEquals(1, code.size());
        }
        assertEquals(Color.yellow, oneSecretCode.get(0).get(0));
        assertEquals(Color.green, oneSecretCode.get(5).get(0));
    }

    @Test
    public void allCodesWorksWithSizeTwo() {
        List<List<Color>> twoSecretCode = ai.allCodes(2);
        assertEquals(36, twoSecretCode.size()); // 6 to the power of 2
        for (List<Color> code : twoSecretCode) {
            assertEquals(2, code.size());
        }
        assertEquals(Arrays.asList(Color.yellow, Color.yellow), twoSecretCode.get(0));
        assertEquals(Arrays.asList(Color.yellow, Color.red), twoSecretCode.get(1));
        assertEquals(Arrays.asList(Color.green, Color.green), twoSecretCode.get(35));
    }

    @Test
    public void allCodesWorksWithSizeFour() {
        List<List<Color>> fourSecretCode = ai.allCodes(4);
        assertEquals(1296, fourSecretCode.size()); // 6 to the power of 4
        for (List<Color> code : fourSecretCode) {
            assertEquals(4, code.size());
        }
        assertEquals(Arrays.asList(Color.yellow, Color.yellow, Color.yellow, Color.yellow), fourSecretCode.get(0));
        assertEquals(Arrays.asList(Color.yellow, Color.yellow, Color.yellow, Color.red), fourSecretCode.get(1));
        assertEquals(Arrays.asList(Color.green, Color.green, Color.green, Color.green), fourSecretCode.get(1295));
    }

    @Test
    public void makesAnInitialGuess() {
        List<Turn> emptyBoard = new ArrayList<Turn>();
        List<Color> initialGuess = ai.promptGuess(emptyBoard, 4);
        List<Color> expected = Arrays.asList(Color.green, Color.green, Color.yellow, Color.yellow);
        assertEquals(expected, initialGuess);
    }

    @Test
    public void makesAnotherGuess() {
        List<Color> guess = Arrays.asList(Color.green, Color.yellow, Color.blue, Color.red);
        Feedback feedback = new Feedback(2, 0);
        List<Turn> board = new ArrayList<Turn>();
        Turn turn = new Turn(guess, feedback);
        board.add(turn);
        List<Color> secondGuess = ai.promptGuess(board, 4);
        List<Color> expected = Arrays.asList(Color.yellow, Color.yellow, Color.yellow, Color.red);
        assertEquals(expected, secondGuess);
    }
    
}
