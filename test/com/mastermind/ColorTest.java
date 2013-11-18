package com.mastermind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void randomReturnsAColor() {
        List<Color> colors =  new ArrayList<Color>();
        colors.add(Color.red);
        colors.add(Color.blue);
        colors.add(Color.green);
        colors.add(Color.yellow);
        colors.add(Color.purple);
        colors.add(Color.orange);
        assertTrue(colors.contains(Color.random()));
    }




}
