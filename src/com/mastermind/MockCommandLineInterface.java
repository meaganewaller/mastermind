package com.mastermind;

import java.util.List;

public class MockCommandLineInterface extends CommandLineInterface {
    private boolean displayWelcomeMessageWasCalled = false;
    private Integer timesShowBoardDisplayed = 0;

    @Override
    public void displayWelcomeMessage() {
        this.displayWelcomeMessageWasCalled = true;
    }

    @Override
    public void showBoard(List<Turn> turns) {
        timesShowBoardDisplayed++;
    }

    /* @Override
    public String readLine() {
        return some output
    } */



    public boolean welcomeMessageWasDisplayed() {
        return this.displayWelcomeMessageWasCalled;
    }

    public int numberOfTimesShowBoardDisplayed() {
        return this.timesShowBoardDisplayed;
    }
}
