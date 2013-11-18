package com.mastermind;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertSame;


public class PlayTest {
    @Test
    public void generatesRandomSecretCode() {
        Play play = new Play();
        Code secretCode = play.generateRandomSecretCode();
        assertNotNull(secretCode);
    }

    /*
    @Test
    public void startsAtZeroTurns() {
        Play play = new Play();
        assertSame(new Integer(0), play.turns());


    }
    */






}
