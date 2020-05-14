package com.myApp.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestTurn {
	
	Turn turn = new Turn();
	Roll roll;
	Roll roll2;
	
	@BeforeEach
	void setUp()
	{
		turn = new Turn();
	}

	@Test
	void test_Turn_Constructor() 
	{
		assertEquals(turn.getClass().getSimpleName(), "Turn");
	}

	@Test
	void test_set_score()
	{
		turn.setScore(666);
		assertEquals(turn.getScore(), 666);
	}
	
	@Test
	void test_get_score()
	{
		turn.setScore(1122);
		assertEquals(turn.getScore(), 1122);
	}
	
	@Test
	void test_boolean_is_skunked()
	{
		assertFalse(turn.isSkunked());
	}
	
	@Test
	void test_add_roll()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie3(); //Rolls a 3
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice); //total roll 6
		
		turn.addRoll(roll);
		assertEquals(turn.getLastRoll(), roll);
		
	}
	
	@Test
	void test_get_last_roll()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie2(); //Rolls a 2
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);  //total roll 5
		
		turn.addRoll(roll);
		assertEquals(turn.getLastRoll(), roll);
	}
	
	@Test
	void test_add_score()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie2(); //Rolls a 2
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);  //total roll 5
		
		turn.addScore(roll);
		
		assertEquals(turn.getScore(), 5);
	}
	
	@Test
	void test_get_turn_rolls()
	{
		Die die1 = new CrookedDie1(); //Rolls a 1
		Die die2 = new CrookedDie2(); //Rolls a 2
		Die die3 = new CrookedDie3(); //Rolls a 3
		Die die4 = new CrookedDie3(); //Rolls a 3
		
		Dice dice1 = new Dice(die1, die2);
		Dice dice2 = new Dice(die3, die4);
		
		roll = new Roll(dice1);  //total roll 3
		roll2 = new Roll(dice2); //total roll 6
		
		ArrayList<Roll> testRolls = new ArrayList<Roll>();
		
		testRolls.add(roll);
		testRolls.add(roll2);
		
		turn = new Turn(testRolls);
		
		assertEquals(turn.getTurnRolls(), testRolls);
	}
	
	@Test
	void test_get_turn_penalty()
	{
		Die die1 = new CrookedDie1(); //Rolls a 1
		Die die2 = new CrookedDie1(); //Rolls a 1
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);  //total roll 2
		turn.addRoll(roll);
		
		assertEquals(turn.getPenalty(), 4);
	}
	
	@Test
	void outcome_single_skunk() {
		
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
	void outcome_deuce_skunk() {
		
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
	void outcome_double_skunk() {
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		Turn turn = new Turn();
		turn.roll(dice);
		
		assertEquals(turn.getPenalty(), 4);
		assertTrue(turn.isSkunked());
	}
	
	@Test
	public void score_accumulation()
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
	public void turn_to_string()
	{
		Turn turn = new Turn();
		
		assertTrue(turn.toString().equals("Your turn score is " + turn.getScore() + "."));
		
	}
	
	@Test
	public void get_turn_rolls()
	{
		Turn turn = new Turn();
		
		int count = 0;
		
		assertTrue(turn.getTurnRolls().size() == count);
		
		for (int i = 1; i < 1000; i++) {
			
			turn.roll();
			count++;
			
			assertTrue(turn.getTurnRolls().size() == count);
			
        }
	}
}
