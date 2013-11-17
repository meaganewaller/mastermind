package com.mastermind;

public enum Color {
    red(1), black(2), green(3), blue(4), white(5), yellow(6), purple(7), orange(8);
    private final int value;

    Color(int value) {
        this.value = value;
    }
}
