package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TestCrookedDie1 {
	
	private CrookedDie1 crDie;
	
	//getLastRoll
	
	@Test
	public void testGetLastRollCrDie1()
	{
		crDie = new CrookedDie1();
		assertEquals(crDie.getLastRoll(), 1);
		
	}
	
	@Test
	public void testToStringCrDie1()
	{
		crDie = new CrookedDie1();
		assertEquals(crDie.toString(), "A CrookedDie1 always rolling 1 (a skunk)");
	}
}
