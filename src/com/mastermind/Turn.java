package com.mastermind;

import java.util.List;

public class Turn {
    public List<Color> guess;
    public Feedback feedback;

    public Turn(List<Color> guess, Feedback feedback) {
        this.guess = guess;
        this.feedback = feedback;
    }

    public void setGuess(List<Color> guess) {
        this.guess = guess;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }


    public List<Color> getGuess() {
        return guess;
    }

    public Feedback getFeedback() {
        return feedback;
    }
}
