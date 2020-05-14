package com.myApp.skunk;
public class Die {
	
	private int lastRoll;

	// constructors
	public Die()
	{
		this.roll();
	}

	
	// getters and setters
	public int getLastRoll() 
	{
		return this.lastRoll;
	}
	
	
	// methods
	public void roll() 
	{
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}

	public String toString()
	{
		return "A " + this.lastRoll + " was rolled";
	}
	
}
