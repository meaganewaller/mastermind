package com.mastermind;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ColorTest {
    @Test
    public void colorReturnsColors() {
        assertNotNull(Color.red);
        assertNotNull(Color.blue);
        assertNotNull(Color.green);
        assertNotNull(Color.yellow);
        assertNotNull(Color.purple);
        assertNotNull(Color.orange);
    }


}
