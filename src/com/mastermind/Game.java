package com.mastermind;

public class Game {
    private final Code secretCode;

    public Game(Code secretCode) {
        this.secretCode = secretCode;
    }

    public Feedback getFeedback(Code code) {
        Integer numBlacks = 0;
        Integer numWhites = 0;
        Color firstGuessCode = code.getCode1();
        if (firstGuessCode.equals(secretCode.getCode1())) {
            numBlacks++;
        } else if (firstGuessCode.equals(secretCode.getCode2())) {
            numWhites++;
        }

        Color secondGuessCode = code.getCode2();
        if(secondGuessCode.equals(secretCode.getCode2())) {
            numBlacks++;
        } else if (secondGuessCode.equals(secretCode.getCode1())) {
            numWhites++;
        }

        Color thirdGuessCode = code.getCode3();
        if(thirdGuessCode.equals(secretCode.getCode3())) {
            numBlacks++;
        }

        Color fourthGuessCode = code.getCode4();
        if(fourthGuessCode.equals(secretCode.getCode4())) {
            numBlacks++;
        }

        return new Feedback(numBlacks, numWhites);
    }
}
