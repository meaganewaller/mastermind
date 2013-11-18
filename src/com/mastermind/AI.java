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
            List<Color> firstGuess = Arrays.asList(
                    Color.red, Color.red, Color.blue, Color.blue, Color.green, Color.green,
                    Color.purple, Color.purple, Color.orange, Color.orange, Color.yellow, Color.yellow);
            return firstGuess.subList(0, size);
            } else {
                List<List<Color>> possible = allConsistent(turns, size);
                if (possible.size() > 0) {
                    return possible.get(0);
                }
                return null;
            }
        }

    public List<List<Color>> allConsistent(List<Turn> turns, int size) {
        List<List<Color>> possible = theCodes(size);
        for (Turn turn : turns) {
            possible = filterByTurn(possible, turn);
        }

        return possible;
    }

    private List<List<Color>> filterByTurn(List<List<Color>> possible, Turn turn) {
        List<List<Color>> consistent = new ArrayList<List<Color>>();
        for (List<Color> code : possible) {
            if (consistent(turn, code)) {
                consistent.add(code);
            }
        }
        return consistent;
    }

    private boolean consistent(Turn turn, List<Color> code) {
        return Board.getFeedback(turn.getGuess(), code).equals(turn.getFeedback());
    }

    public List<List<Color>> theCodes(int size) {
        Color[] colors = Color.values();
        List<List<Color>> codes = new ArrayList<List<Color>>();
        if (size == 1) {
            for (Color color : colors) {
                codes.add(Arrays.asList(color));
            }
        } else {
            List<List<Color>> smallerCodes = theCodes(size - 1);
            for (Color color : colors) {
                for (List<Color> smallCode : smallerCodes) {
                    List<Color> code = new ArrayList<Color>(Arrays.asList(color));
                    code.addAll(smallCode);
                    codes.add(code);
                }
            }
        }

        return codes;
    }


}
