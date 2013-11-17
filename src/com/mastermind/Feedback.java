package com.mastermind;

public class Feedback {
    private final Integer numberOfBlack;
    private final Integer numberOfWhite;

    public Feedback(Integer numberOfBlack, Integer numberOfWhite) {
        this.numberOfBlack = numberOfBlack;
        this.numberOfWhite = numberOfWhite;
    }

    public Integer getNumberOfBlack() {
        return numberOfBlack;
    }

    public Integer getNumberOfWhite() {
        return numberOfWhite;
    }
}
