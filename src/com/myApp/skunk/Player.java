package com.myApp.skunk;

public class Player {

	private String name;
	private int chipCount;
	private int score;
	
	
	// constructors
	Player(String name)
	{
		this.name = name;
		this.chipCount = 50; // starting chip count 
		this.score = 0;
	}
	
	Player(String name, int chipCount)
	{
		this.name = name;
		this.chipCount = chipCount; // starting chip count 
		this.score = 0;
	}
	
	
	// getters and setters
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getChipCount() 
	{
		return chipCount;
	}

	public void setChipCount(int chipCount) 
	{
		this.chipCount = chipCount;
	}
	
	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
	}
}
