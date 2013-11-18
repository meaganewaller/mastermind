package com.mastermind;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum Color {
    yellow('y'), red('r'), blue('b'), purple('p'), orange('o'), green('g');

    public char c;

    private Color(char c) {
        this.c = c;
    }

    public static Map<Character, Color> charToColor = new HashMap<Character, Color>();

    static {
        for (Color color : Color.values()) {
            charToColor.put(color.c, color);
        }
    }

    private static Random random = new Random();

    public static Color random() {
        Color[] colors = Color.values();
        return colors[random.nextInt(colors.length)];
    }
}
