package com.learning.java.model;

public class Score {
	private int scoreValue;
	private String name;
	
	public Score(int scoreValue, String name) {
		super();
		this.scoreValue = scoreValue;
		this.name = name;
	}
	
	public int getScoreValue() {
		return scoreValue;
	}
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Score [scoreValue=" + scoreValue + ", name=" + name + "]";
	}

}
