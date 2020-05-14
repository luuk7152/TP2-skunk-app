package com.app.skunk;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestPlayer {

	private Player player;
	private String name;
	
	@BeforeEach
	public void setUp() {
		player = new Player(name);
    }
	
	@Test
	public void testPlayerConstructor()
	{
		assertEquals(player.getClass().getSimpleName(), "Player");
	}
	
	@Test
	public void testGetName()
	{
		assertEquals(player.getName(), name);
	}
	
	@Test
	public void testSetName()
	{
		String newName = "Mary Johnson";
		player.setName(newName);
		
		assertEquals(player.getName(), newName);
	}
	
	@Test
	public void testGetChipCount()
	{
		int chipCount = 100;
		player = new Player(name, chipCount);
		
		assertEquals(player.getChipCount(), chipCount);
	}
	
	@Test
	public void testSetChipCount()
	{
		int newChipCount = 10;
		player.setChipCount(newChipCount);
		
		assertEquals(player.getChipCount(), newChipCount);
	}
	
	@Test
	public void testGetScore()
	{
		player = new Player(name);
		
		assertEquals(player.getScore(), 0);
	}
	
	@Test
	public void testSetScore()
	{
		int newScore = 10;
		player.setScore(newScore);
		
		assertEquals(player.getScore(), newScore);
	}
	

	@Test
	public void testSetCurrentTurn()
	{
		Turn turn = new Turn();
		player.setCurrentTurn(turn);
		
		assertEquals(player.getCurrentTurn().getClass().getSimpleName(), "Turn");
	}
	
	@Test
	public void testGetCurrentTurn()
	{
		Turn turn = new Turn();
		player.setCurrentTurn(turn);
		
		assertEquals(player.getCurrentTurn(), turn);
	}
	
	
	@Test
	public void testHandleSkunked()
	{	
		player.setScore(100);
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie2();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		Turn turn = new Turn();
		turn.setScore(50);
		
		player.setCurrentTurn(turn);
		
		turn.addRoll(roll);
		
		player.handleSkunk();
		
		assertTrue(player.getCurrentTurn().isSkunked());
		assertEquals(player.getCurrentTurn().getScore(), 0);
	}
	
	@Test
	public void testHandleDoubleSkunked()
	{
		player.setScore(100);
		
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		Turn turn = new Turn();
		turn.setScore(50);
		
		player.setCurrentTurn(turn);
		
		turn.addRoll(roll);
		
		player.handleSkunk();
		
		assertTrue(player.getCurrentTurn().isSkunked());
		assertEquals(player.getCurrentTurn().getScore(), 0);
		assertEquals(player.getScore(), 0);
	}
	
	@Test
	public void testHandleNoSkunked()
	{
		player.setScore(100);
		
		Die die1 = new CrookedDie3();
		Die die2 = new CrookedDie3();
		Dice dice = new Dice(die1, die2);
		
		Roll roll = new Roll(dice);
		
		Turn turn = new Turn();
		turn.setScore(50);
		
		player.setCurrentTurn(turn);
		
		turn.addRoll(roll);
		turn.addScore(roll);
		
		player.handleSkunk();
		
		assertFalse(player.getCurrentTurn().isSkunked());
		assertEquals(player.getCurrentTurn().getScore(), 56);
		assertEquals(player.getScore(), 100);
	}
	
	@Test
	public void testEndPlayerTurn()
	{
		player.setScore(100);
		
		Turn turn = new Turn();
		turn.setScore(50);
		
		player.setCurrentTurn(turn);
		player.endTurn();
		
		assertEquals(player.getScore(), 100 + 50);
	}
	
}
