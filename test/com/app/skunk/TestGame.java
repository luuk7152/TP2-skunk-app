package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {

	private Game game;
	
	@BeforeEach
    void setUp() {
		game = new Game();
    }
	
	@Test
	void testGameConstructor()
	{
		assertEquals(game.getClass().getSimpleName(), "Game");
		
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 1; i < 50; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		game = new Game(players);
		assertTrue(game.getPlayers().size() == players.size());
	}
	
	@Test
	void testSetPlayers()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 1; i < 50; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		game.setPlayers(players);
		assertTrue(game.getPlayers().size() == players.size());
	}
	
	@Test
	void testGetPlayers()
	{
		String name1 = "John Doe";
		String name2 = "Mary Johnson";
		
		Player player1 = new Player(name1);
		Player player2 = new Player(name2);
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		
		game.setPlayers(players);
		
		assertEquals(game.getPlayers().get(0).getName(), name1);
		assertEquals(game.getPlayers().get(1).getName(), name2);
	}
}
