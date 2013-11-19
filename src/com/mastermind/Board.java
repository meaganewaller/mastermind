package com.mastermind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    public static Feedback getFeedback(List<Color> guess, List<Color> actual) {
        int numOfX = numberOfX(guess, actual);
        int numOfO = numberOfO(guess, actual);
        return new Feedback(numOfX, numOfO - numOfX);
    }

    private static int numberOfX(List<Color> userGuess, List<Color> actual) {
        int x = 0;
        for (int index = 0; index < actual.size(); index++) {
            if (actual.get(index) == userGuess.get(index)) {
                x++;
            }
        }

        return x;
    }

    private static int numberOfO(List<Color> userGuess, List<Color> actual) {
        Map<Color, Integer> guessFrequency = count(userGuess);
        Map<Color, Integer> actualFrequency = count(actual);
        return getOs(guessFrequency, actualFrequency);
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

    private static int getOs(Map<Color, Integer> guessFrequency, Map<Color, Integer> actualFrequency) {
        int o = 0;
        for (Color guessColor : guessFrequency.keySet()) {
            if (actualFrequency.containsKey(guessColor)) {
                o += Math.min(guessFrequency.get(guessColor), actualFrequency.get(guessColor));
            }
        }
        return o;

    }

}
