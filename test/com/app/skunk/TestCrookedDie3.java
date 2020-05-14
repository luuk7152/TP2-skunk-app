package com.app.skunk;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestCrookedDie3 {
	
	private CrookedDie3 crDie;
	
	//getLastRoll
	
	@Test
	void test_Get_Last_Roll_Cr_Die3()
	{
		crDie = new CrookedDie3();
		assertEquals(crDie.getLastRoll(), 3);
		
	}
	
	@Test
	void test_To_String_Cr_Die3()
	{
		crDie = new CrookedDie3();
		assertEquals(crDie.toString(), "A CrookedDie3 always rolling 3");
	}
}
