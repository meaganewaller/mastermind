package com.mastermind;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;

public class AITest {
    @Test
    public void generatesACodeWithSameSizePassedIn() {
        AI ai = new AI();
        List<Color> secretCode = ai.chooseSecretCode(4);
        assertEquals(4, secretCode.size());
    }

    @Test
    public void generatesARandomCode() {
        AI ai = new AI();
        List<Color> secretCode =  ai.chooseSecretCode(4);
        assertNotSame(secretCode.get(0), secretCode.get(1));

    }
}
