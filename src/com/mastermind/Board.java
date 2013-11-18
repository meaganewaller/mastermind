package com.mastermind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    public static Feedback getFeedback(List<Color> guess, List<Color> actual) {
        int numOfBlacks = numberOfBlacks(guess, actual);
        int numOfWhites = numberOfWhites(guess, actual);
        return new Feedback(numOfBlacks, numOfWhites - numOfBlacks);
    }

    private static int numberOfBlacks(List<Color> userGuess, List<Color> actual) {
        int blacks = 0;
        for (int index = 0; index < actual.size(); index++) {
            if (actual.get(index) == userGuess.get(index)) {
                blacks++;
            }
        }

        return blacks;
    }

    private static int numberOfWhites(List<Color> userGuess, List<Color> actual) {
        Map<Color, Integer> guessFrequency = count(userGuess);
        Map<Color, Integer> actualFrequency = count(actual);
        return getWhites(guessFrequency, actualFrequency);
        }

    private static Map<Color,Integer> count(List<Color> userGuess) {
        Map<Color,Integer> frequencies = new HashMap<Color, Integer>();
        for (Color color : userGuess) {
            if (frequencies.containsKey(color)) {
                Integer count = frequencies.get(color);
                frequencies.put(color, ++count);

            } else {
                frequencies.put(color, 1);
            }
        }
        return frequencies;
    }

    private static int getWhites(Map<Color, Integer> guessFrequency, Map<Color, Integer> actualFrequency) {
        int whites = 0;
        for (Color guessColor : guessFrequency.keySet()) {
            if (actualFrequency.containsKey(guessColor)) {
                whites += Math.min(guessFrequency.get(guessColor), actualFrequency.get(guessColor));
            }
        }
        return whites;

    }

}
