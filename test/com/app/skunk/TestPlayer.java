package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestPlayer {

	private Player player;
	private String name;
	
	@BeforeEach
    void setUp() {
		player = new Player(name);
    }
	
	@Test
	void testPlayerConstructor()
	{
		assertEquals(player.getClass().getSimpleName(), "Player");
	}
	
	@Test
	void testGetName()
	{
		assertEquals(player.getName(), name);
	}
	
	@Test
	void testSetName()
	{
		String newName = "Mary Johnson";
		player.setName(newName);
		
		assertEquals(player.getName(), newName);
	}
	
	@Test
	void testGetChipCount()
	{
		int chipCount = 100;
		player = new Player(name, chipCount);
		
		assertEquals(player.getChipCount(), chipCount);
	}
	
	@Test
	void testSetChipCount()
	{
		int newChipCount = 10;
		player.setChipCount(newChipCount);
		
		assertEquals(player.getChipCount(), newChipCount);
	}
	
	@Test
	void testGetScore()
	{
		player = new Player(name);
		
		assertEquals(player.getScore(), 0);
	}
	
	@Test
	void testSetScore()
	{
		int newScore = 10;
		player.setScore(newScore);
		
		assertEquals(player.getScore(), newScore);
	}
	
}
