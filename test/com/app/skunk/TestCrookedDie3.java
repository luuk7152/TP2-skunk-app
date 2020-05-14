package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TestCrookedDie3 {
	
	private CrookedDie3 crDie;
	
	//getLastRoll
	
	@Test
	public void testGetLastRollCrDie3()
	{
		crDie = new CrookedDie3();
		assertEquals(crDie.getLastRoll(), 3);
		
	}
	
	@Test
	public void testToStringCrDie3()
	{
		crDie = new CrookedDie3();
		assertEquals(crDie.toString(), "A CrookedDie3 always rolling 3");
	}
}
