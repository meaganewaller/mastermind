package com.mastermind;

import java.util.List;

public class MockCommandLineInterface extends CommandLineInterface {
    private boolean displayWelcomeMessageWasCalled = false;
    private Integer timesShowBoardDisplayed = 0;
	public String input;
	
	public void setInput(String input) {
		this.input = input;
	}

    @Override
    public void displayWelcomeMessage() {
        this.displayWelcomeMessageWasCalled = true;
    }

    @Override
    public void showBoard(List<Turn> turns) {
        timesShowBoardDisplayed++;
    }
    
    @Override
    public String promptCode() {
    	return input;
    }
    
    @Override
    public void promptForGuess() {
    }
    
    @Override 
    public String promptPlayers() {
    	return input;
    }
    
    public boolean welcomeMessageWasDisplayed() {
        return this.displayWelcomeMessageWasCalled;
    }

    public int numberOfTimesShowBoardDisplayed() {
        return this.timesShowBoardDisplayed;
    }
}
