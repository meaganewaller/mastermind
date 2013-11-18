package com.mastermind;

public class Feedback {
    private final Integer numberOfBlack;
    private final Integer numberOfWhite;

    public Feedback(int numberOfBlack, int numberOfWhite) {
        this.numberOfBlack = numberOfBlack;
        this.numberOfWhite = numberOfWhite;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Feedback) {
            Feedback that = (Feedback) object;
            return that.numberOfBlack == this.numberOfBlack && that.numberOfWhite == this.numberOfWhite;
        }

        return false;
    }

    public Integer getNumberOfBlack() {
        return numberOfBlack;
    }

    public Integer getNumberOfWhite() {
        return numberOfWhite;
    }
}
