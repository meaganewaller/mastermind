package com.mastermind;

import static org.junit.Assert.*;

import org.junit.Test;

public class FeedbackTest {
	@Test
	public void hasNumberOfX() {
		Feedback feedback = new Feedback(1,1);
		assertSame(1, feedback.getNumberOfX());
	}
	
	@Test
	public void hasNumberOfO() {
		Feedback feedback = new Feedback(1,1);
		assertSame(1, feedback.getNumberOfO());
	}
	
	@Test
	public void returnsFalseIfObjectNotInstanceOfFeedback() {
		Game game = new Game();
		Feedback feedback = new Feedback(0,0);
		assertFalse(feedback.equals(game));
	}
}
