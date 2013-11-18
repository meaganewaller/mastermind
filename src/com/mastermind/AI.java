package com.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AI implements Encoder {

    @Override
    public List<Color> chooseSecretCode(int size) {
        List<Color> secretCode = new ArrayList<Color>();
        for (int index = 0; index < size; index++) {
            secretCode.add(Color.random());
        }

        return secretCode;
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
