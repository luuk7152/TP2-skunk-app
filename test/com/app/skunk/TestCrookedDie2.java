package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TestCrookedDie2 {
	
	private CrookedDie2 crDie;
	
	//getLastRoll
	
	@Test
	void testGetLastRollCrDie2()
	{
		crDie = new CrookedDie2();
		assertEquals(crDie.getLastRoll(), 2);
		
	}
	
	@Test
	void testToStringCrDie2()
	{
		crDie = new CrookedDie2();
		assertEquals(crDie.toString(), "A CrookedDie2 always rolling 2");
	}
}
