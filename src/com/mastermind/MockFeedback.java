package com.mastermind;

public class MockFeedback extends Feedback  {
	private Integer numberOfX;
	private Integer numberOfO;

	public MockFeedback(int numberOfX, int numberOfO) {
		super(numberOfX, numberOfO);
		this.numberOfX = numberOfX;
		this.numberOfO = numberOfO;
	}
	
	public Integer getNumberOfX() {
		return numberOfX;
	}
	
	public Integer getNumberOfO() {
		return numberOfO;
	}
}
