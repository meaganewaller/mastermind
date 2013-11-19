package com.mastermind;

public class Feedback {
    private final Integer numberOfX;
    private final Integer numberOfO;

    public Feedback(int numberOfX, int numberOfO) {
        this.numberOfX = numberOfX;
        this.numberOfO = numberOfO;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Feedback) {
            Feedback that = (Feedback) object;
            return that.numberOfX == this.numberOfX && that.numberOfO == this.numberOfO;
        }

        return false;
    }

    public Integer getNumberOfX() {
        return numberOfX;
    }

    public Integer getNumberOfO() {
        return numberOfO;
    }
}
