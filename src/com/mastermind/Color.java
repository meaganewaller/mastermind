package com.mastermind;

public enum Color {
    yellow(1), red(2), blue(3), purple(4), orange(5), green(6);
    private final int value;

    Color(int value) {
        this.value = value;
    }
}
