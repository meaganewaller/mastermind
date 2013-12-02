package com.mastermind;

public class MockCommandLineInterface extends CommandLineInterface {
    private boolean displayWelcomeMessageWasCalled = false;

    @Override
    public void displayWelcomeMessage() {
        this.displayWelcomeMessageWasCalled = true;
    }
    public boolean welcomeMessageWasDisplayed() {
        return this.displayWelcomeMessageWasCalled;
    }
}
