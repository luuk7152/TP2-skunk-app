package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestDie {
	
	private Die die;
	
	private List<Integer> validValues = Arrays.asList(1,2,3,4,5,6);
	
	@BeforeEach
	public void setUp() {
		die = new Die();
    }
	
	@Test
	public void testGetLastRoll() 
	{
		die.roll();
		int roll = die.getLastRoll();
		
		assertTrue(validValues.contains(roll));	
	}
	
	@Test
	public void testGenerateRandomNumberBetween1And6()
	{	
		for (int i = 1; i < 100000; i++) {
			
			die.roll();
			int roll = die.getLastRoll();
			
			assertTrue(validValues.contains(roll));
        }
	}
	
	@Test
	public void testDisplayDieToString() 
	{
		die.roll();
		int roll = die.getLastRoll();
		
		assertTrue(die.toString().equals("A " + roll + " was rolled"));
	}
	
}
