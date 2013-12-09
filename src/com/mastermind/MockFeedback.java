package com.mastermind;

public class MockFeedback extends Feedback  {
	private Integer numberOfX;
	private Integer numberOfO;

	public MockFeedback(int numberOfX, int numberOfO) {
		super(numberOfX, numberOfO);
		this.numberOfX = numberOfX;
		this.numberOfO = numberOfO;
	}
	
	public void setNumberOfX(int numberOfX) {
		this.numberOfX = numberOfX;
	}
	
	public void setNumberOfO(int numberOfO) {
		this.numberOfO = numberOfO;
	}
	
	public Integer getNumberOfX() {
		return 1;
	}
	
	public Integer getNumberOfO() {
		return 1;
	}
	
	
	

}
