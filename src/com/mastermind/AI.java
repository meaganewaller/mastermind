package com.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AI implements Encoder, Decoder{

    @Override
    public List<Color> chooseSecretCode(int size) {
        List<Color> secretCode = new ArrayList<Color>();
        for (int index = 0; index < size; index++) {
            secretCode.add(Color.random());
        }

        return secretCode;
    }

    @Override
    public List<Color> promptGuess(List<Turn> turns, int size) {
        if (turns.size() == 0) {
            List<Color> initialGuess = Arrays.asList(
                    Color.green, Color.green, Color.yellow, Color.yellow, Color.red, Color. red,
                    Color.purple, Color.purple, Color.blue, Color.blue, Color.orange, Color.orange);
            return initialGuess.subList(0, size);
        } else {
            List<List<Color>> possible = remainingCodes(turns, size);
            if (possible.size() > 0 ) {
                return possible.get(0);
            }
            return null;
        }
    }

    // filters to the remaining possible secret code combos
    public List<List<Color>> remainingCodes(List<Turn> turns, int size) {
        List<List<Color>> possible = allCodes(size);
        for (Turn turn: turns) {
            possible = filterByTurn(possible, turn);
        }
        return possible;
    }

    public List<List<Color>> filterByTurn(List<List<Color>> possible, Turn turn) {
        List<List<Color>> sameFeedback = new ArrayList<List<Color>>();
        for (List<Color> code : possible) {
            if (producedSameFeedback(turn, code)) {
                sameFeedback.add(code);
            }
        }
        return sameFeedback;
    }


    // given feedback returns t/f if another code would've produced same feedback
    public boolean producedSameFeedback(Turn turn, List<Color> code) {
        return Board.getFeedback(turn.getGuess(), code).equals(turn.getFeedback());
    }
        // produces a sequence of all possible codes for a given size
    public List<List<Color>> allCodes(int size) {
        Color[] colors = Color.values();
        List<List<Color>> codes = new ArrayList<List<Color>>();
        if (size == 1) {
            for (Color color : colors) {
                codes.add(Arrays.asList(color));
            }
        } else {
            List<List<Color>> smallerCodes = allCodes(size - 1);
            for (Color color : colors) {
                for (List<Color> smallCodes : smallerCodes) {
                    List<Color> code = new ArrayList<Color>(Arrays.asList(color));
                    code.addAll(smallCodes);
                    codes.add(code);
                }
            }
        }
        return codes;
    }
}
