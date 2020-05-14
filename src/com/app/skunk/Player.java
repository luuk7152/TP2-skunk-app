package com.app.skunk;

public class Player {

	private String name;
	private int chipCount;
	private int score;
	private Turn currentTurn;
	
	
	//constructors
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
	
	
	//getters and setters
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
	
	//methods
	public void setCurrentTurn(Turn turn)
	{
		currentTurn = turn;
	}
	
	public Turn getCurrentTurn()
	{
		return currentTurn;
	}
	
	public void handleSkunk()
	{
		if (currentTurn.isSkunked()) {
			currentTurn.setScore(0);
		}
		
		if (currentTurn.getLastRoll().isDoubleSkunk()) {
			score = 0;
		}
	}
	
	public void endTurn()
	{
		setScore(score + currentTurn.getScore());

	}
}
