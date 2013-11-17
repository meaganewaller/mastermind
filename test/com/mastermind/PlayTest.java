package com.mastermind;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;



public class PlayTest {
    @Test
    public void generatesRandomSecretCode() {
        Play play = new Play();
        Code secretCode = play.generateRandomSecretCode();
        assertNotNull(secretCode);



    }



}
