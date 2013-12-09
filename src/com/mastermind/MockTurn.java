package com.mastermind;

import java.util.List;

public class MockTurn extends Turn {
	public List<Color> guess;
	public Feedback feedback;
	
	public MockTurn(List<Color> guess, Feedback feedback) {
		super(guess, feedback);
	}
	
	public void setGuess(List<Color> guess) {
		this.guess = guess;
	}
	
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

}
