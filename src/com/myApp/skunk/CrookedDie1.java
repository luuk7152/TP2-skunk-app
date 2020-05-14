package com.myApp.skunk;
public class CrookedDie1 extends Die
{	
	@Override
	public int getLastRoll()
	{
		return 1;
	}

	@Override
	public String toString()
	{
		return "A CrookedDie1 always rolling 1 (a skunk)";
	}
}
