package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {

	private Game game;
	
	@BeforeEach
    public void setUp() {
		game = new Game();
    }
	
	@Test
	public void testGameConstructor()
	{
		assertEquals(game.getClass().getSimpleName(), "Game");
		
		ArrayList<Player> players = new ArrayList<Player>();
		for (int i = 1; i < 50; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		game = new Game(players);
		assertEquals(game.getPlayers().size(), players.size());
	}
	
	@Test
	public void testSetPlayers()
	{
		int size = 50;
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int i = 0; i < size; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		game.setPlayers(players);
		
		assertEquals(game.getPlayers().size(), size);
	}
	
	@Test
	public void testGetPlayers()
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
	
	@Test
	public void testSetAndGetCurrentPlayer()
	{
		String name1 = "John Doe";
		String name2 = "Mary Johnson";
		
		Player player1 = new Player(name1);
		Player player2 = new Player(name2);
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		
		game.setPlayers(players);
		
		game.setCurrentPlayer(game.getPlayers().get(1));
		
		assertEquals(game.getCurrentPlayer().getName(), name2);
	}
	
	@Test
	public void testSetAndGetWinner()
	{
		String name1 = "John Doe";
		String name2 = "Mary Johnson";
		
		Player player1 = new Player(name1);
		Player player2 = new Player(name2);
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		
		game.setPlayers(players);
		
		game.setWinner(game.getPlayers().get(1));
		
		assertEquals(game.getWinner().getName(), name2);
	}
	
	@Test
	public void testSetNextPlayer()
	{
		String name1 = "John Doe";
		String name2 = "Mary Johnson";
		String name3 = "James Smith";
		
		Player player1 = new Player(name1);
		Player player2 = new Player(name2);
		Player player3 = new Player(name3);
		
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		game.setPlayers(players);
		
		assertEquals(game.getCurrentPlayer().getName(), name1);
		
		game.setNextPlayer();
		assertEquals(game.getCurrentPlayer().getName(), name2);
		
		game.setNextPlayer();
		assertEquals(game.getCurrentPlayer().getName(), name3);
		
		game.setNextPlayer();
		assertEquals(game.getCurrentPlayer().getName(), name1);
	}
	
	@Test
	public void testEndTurn() {
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int i = 1; i <= 100; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		Game game = new Game(players);
		
		Turn turn = new Turn();
		game.getCurrentPlayer().setCurrentTurn(turn);
		
		int turnScore = 20;
		
		turn.setScore(turnScore);
		game.endTurn();
		
		assertEquals(game.getCurrentPlayer().getScore(), turnScore);
		
	}
	
	@Test
	public void testSetAndGetFirstWinner()
	{	
		Player player1 = new Player("John Doe");
		Player player2 = new Player("Mary Johnson");
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		players.add(player1);
		players.add(player2);
		
		game.setPlayers(players);
		
		assertEquals(game.getFirstWinner(), null);
		
		game.setWinner(player1);
		assertEquals(game.getFirstWinner(), player1);
		
		game.setWinner(player2);
		assertEquals(game.getFirstWinner(), player1);
	}
}
