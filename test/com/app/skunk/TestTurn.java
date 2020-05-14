package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestTurn {
	
	private Turn turn = new Turn();
	private Roll roll;
	
	@BeforeEach
	public void setUp()
	{
		turn = new Turn();
	}

	@Test
	public void testTurnConstructor() 
	{
		assertEquals(turn.getClass().getSimpleName(), "Turn");
	}

	@Test
	public void testSetScore()
	{
		turn.setScore(666);
		assertEquals(turn.getScore(), 666);
	}
	
	@Test
	public void testGetScore()
	{
		turn.setScore(1122);
		assertEquals(turn.getScore(), 1122);
	}
	
	@Test
	public void testBooleanIsSkunked()
	{
		assertFalse(turn.isSkunked());
	}
	
	@Test
	public void testAddRoll()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie3(); //Rolls a 3
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice); //total roll 6
		
		turn.addRoll(roll);
		assertEquals(turn.getLastRoll(), roll);
		
	}
	
	@Test
	public void testGetLastRoll()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie2(); //Rolls a 2
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);  //total roll 5
		
		turn.addRoll(roll);
		assertEquals(turn.getLastRoll(), roll);
	}
	
	@Test
	public void testAddScore()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie2(); //Rolls a 2
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);  //total roll 5
		
		turn.addScore(roll);
		
		assertEquals(turn.getScore(), 5);
	}
	
	@Test
	public void testGetTurnRoll()
	{
		Die die1 = new CrookedDie1(); //Rolls a 1
		Die die2 = new CrookedDie2(); //Rolls a 2
		Die die3 = new CrookedDie3(); //Rolls a 3
		Die die4 = new CrookedDie3(); //Rolls a 3
		
		Dice dice1 = new Dice(die1, die2);
		Dice dice2 = new Dice(die3, die4);
		
		roll = new Roll(dice1);  //total roll 3
		
		Roll roll2 = new Roll(dice2); //total roll 6
		
		ArrayList<Roll> testRolls = new ArrayList<Roll>();
		
		testRolls.add(roll);
		testRolls.add(roll2);
		
		turn = new Turn(testRolls);
		
		assertEquals(turn.getTurnRolls(), testRolls);
	}
	
	@Test
	public void testGetTurnPenalty()
	{
		Die die1 = new CrookedDie1(); //Rolls a 1
		Die die2 = new CrookedDie1(); //Rolls a 1
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);  //total roll 2
		turn.addRoll(roll);
		
		assertEquals(turn.getPenalty(), 4);
	}
	
	@Test
	public void outcomeSingleSkunk() 
	{	
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie3();
		
		Dice dice1 = new Dice(die1, die2);
		Dice dice2 = new Dice(die2, die1);
		
		Turn turn1 = new Turn();
		turn1.roll(dice1);
		
		assertEquals(turn1.getPenalty(), 1);
		assertTrue(turn1.isSkunked());
		
		Turn turn2 = new Turn();
		turn2.roll(dice2);
		
		assertEquals(turn2.getPenalty(), 1);
		assertTrue(turn2.isSkunked());
	}
	
	@Test
	public void testOutcomeDeuceSkunk() 
	{	
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie2();
		
		Dice dice1 = new Dice(die1, die2);
		
		Turn turn1 = new Turn();
		turn1.roll(dice1);
		
		assertEquals(turn1.getPenalty(), 2);
		assertTrue(turn1.isSkunked());
		
		Dice dice2 = new Dice(die2, die1);
		
		Turn turn2 = new Turn();
		turn2.roll(dice2);
		
		assertEquals(turn2.getPenalty(), 2);
		assertTrue(turn2.isSkunked());
	}
	
	@Test
	public void testOutcomeDoubleSkunk() 
	{
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		Turn turn = new Turn();
		turn.roll(dice);
		
		assertEquals(turn.getPenalty(), 4);
		assertTrue(turn.isSkunked());
	}
	
	@Test
	public void testOutcomeNoSkunk() 
	{
		Die die1 = new CrookedDie3();
		Die die2 = new CrookedDie3();
		Dice dice = new Dice(die1, die2);
		
		Turn turn = new Turn();
		turn.roll(dice);
		
		assertEquals(turn.getPenalty(), 0);
		assertFalse(turn.isSkunked());
	}
	
	@Test
	public void testScoreAccumulation()
	{
		Turn turn = new Turn();
		
		int prevScore = 0;
		
		for (int i = 1; i < 100000; i++) {
			
			prevScore = turn.getScore();
			turn.roll();
						
			assertEquals(turn.getScore(), prevScore + turn.getLastRoll().getScore());
			
        }
	}
	
	@Test
	public void testTurnToString()
	{
		Turn turn = new Turn();
		
		assertTrue(turn.toString().equals("Your turn score is " + turn.getScore() + "."));
		
	}
	
	@Test
	public void testGetTurnRolls()
	{
		Turn turn = new Turn();
		
		int count = 0;
		
		assertEquals(turn.getTurnRolls().size(), count);
		
		for (int i = 1; i < 1000; i++) {
			
			turn.roll();
			count++;
			
			assertEquals(turn.getTurnRolls().size(), count);
			
        }
	}
}
