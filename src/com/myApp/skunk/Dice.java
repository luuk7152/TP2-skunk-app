package com.myApp.skunk;

public class Dice {
	private Die die1;
	private Die die2;
	private int lastRoll;

	// constructors
	public Dice()
	{
		this.die1 = new Die();
		this.die2 = new Die();
		this.roll();
	}

	public Dice(Die die1, Die die2)
	{
		this.die1 = die1;
		this.die2 = die2;
		this.roll();
	}
	
	
	// getters and setters
	public int getLastRoll()
	{
		return this.lastRoll;
	}
	
	public Die getDie1() 
	{
		return die1;
	}
	
	public Die getDie2() 
	{
		return die2;
	}

	public int getDie1Roll() 
	{
		return die1.getLastRoll();
	}
	
	public int getDie2Roll() 
	{
		return die2.getLastRoll();
	}

	
	// methods
	public void roll()
	{
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}
	
	public String toString()
	{
		return "Dice Roll: " + lastRoll + " => " + getDie1Roll() + " + " + getDie2Roll();
	}
}
