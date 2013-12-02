
package com.mastermind;

import java.util.ArrayList;
import java.util.List;

public class MockDecoder extends Player {
    public List<Color> userGuess;
    private List<List<Color>> guesses = new ArrayList<List<Color>>();

    public void addGuess(List<Color> guess) {
        this.guesses.add(guess);
    }
    @Override
    public List<Color> promptGuess(List<Turn> turns, int size) {
        List<Color> guess = guesses.get(0);
        guesses.remove(0);
        return guess;
    }
}
