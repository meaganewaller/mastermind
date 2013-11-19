package com.mastermind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void returnsFalseWhenNotSolved() {
        Game game = new Game();
        List<Turn> turns = new ArrayList<Turn>();
        assertTrue(game.notSolved(turns, 4));
    }


}
