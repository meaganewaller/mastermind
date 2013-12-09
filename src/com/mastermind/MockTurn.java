package com.mastermind;

import java.util.List;

public class MockTurn extends Turn {
	public List<Color> guess;
	public Feedback feedback;
	
	public MockTurn(List<Color> guess, Feedback feedback) {
		super(guess, feedback);
		this.guess = guess;
		this.feedback = feedback;
	}
	
}
