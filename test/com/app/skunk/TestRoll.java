package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestRoll {
	
	private Roll roll;
	
	@BeforeEach
	public void setUp() {
		roll = new Roll();
    }
	
	@Test
	public void testRollConstructor()
	{
		assertEquals(roll.getClass().getSimpleName(), "Roll");
	}
	
	@Test
	public void testGetDice()
	{
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getDice().getDie1Roll(), 1);
	}
	
	@Test
	public void testGetScore()
	{
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getScore(), 2);
	}
	
	@Test
	public void testSingleSkunkOutcome()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie3(); //forces a roll of 3
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getPenalty(), 1);
		
	}
	
	@Test
	public void testDoubleSkunkOutcome()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie1(); //forces a roll of 1
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getPenalty(), 4);
		
	}
	
	@Test
	public void testSkunkDeuceOutcome()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie2(); //forces a roll of 2
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getPenalty(), 2);
		
	}
	
	@Test
	public void testNoSkunkOutcome()
	{
		Die die1 = new CrookedDie3(); //forces a roll of 3
		Die die2 = new CrookedDie3(); //forces a roll of 3
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getPenalty(), 0);
		
	}
	
	//Test Roll Booleans
	
	@Test
	public void testIsSingleSkunk()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie3(); //forces a roll of 3
		
		Dice dice1 = new Dice(die1, die2);
		Roll roll1 = new Roll(dice1);
		
		assertTrue(roll1.isSingleSkunk());
		
		Dice dice2 = new Dice(die2, die1);
		Roll roll2 = new Roll(dice2);
		
		assertTrue(roll2.isSingleSkunk());
	}
	
	@Test
	public void testIsDoubleSkunk()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie1(); //forces a roll of 1
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertTrue(roll.isDoubleSkunk());
	}
	
	@Test
	public void testIsSkunkDeuce()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie2(); //forces a roll of 2
		
		Dice dice1 = new Dice(die1, die2);
		Roll roll1 = new Roll(dice1);
		
		assertTrue(roll1.isDeuceSkunk());
		
		Dice dice2 = new Dice(die2, die1);
		Roll roll2 = new Roll(dice2);
		
		assertTrue(roll2.isDeuceSkunk());
	}
	
	//Test ToString Outcomes
	
	@Test
	public void testToStringSingleSkunk()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie3(); //forces a roll of 3
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.toString(), "You rolled a Single Skunk => 1 and 3.");
	}
	
	@Test
	public void testToStringDoubleSkunk()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie1(); //forces a roll of 1
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.toString(), "You rolled a Double Skunk => 1 and 1.");
	}
	
	@Test
	public void testToStringSkunkDeuce()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie2(); //forces a roll of 2
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.toString(), "You rolled a Deuce Skunk => 1 and 2.");
	}
	
	@Test
	public void testToStringNoSkunk()
	{
		Die die1 = new CrookedDie3(); //forces a roll of 3
		Die die2 = new CrookedDie3(); //forces a roll of 3
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.toString(), "You rolled a 6 => 3 and 3.");
	}
}
