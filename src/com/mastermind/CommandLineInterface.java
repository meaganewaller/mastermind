package com.mastermind;

import java.util.ArrayList;
import java.util.List;

public class CommandLineInterface {

    List<Color> convertInput(String input) {
        char[] chars = input.replaceAll("\\W", "").toLowerCase().toCharArray();
        List<Color> color = new ArrayList<Color>();
        for (char c : chars) {
            color.add(Color.charToColor.get(c));
        }

        return color;
    }
}
