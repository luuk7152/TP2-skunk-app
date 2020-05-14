package com.myApp.skunk;
public class CrookedDie3 extends Die
{
	@Override
	public int getLastRoll()
	{
		return 3;
	}

	@Override
	public String toString()
	{
		return "A CrookedDie3 always rolling 3";
	}

}