package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTournament {

	private Tournament tournament;
	
	@BeforeEach
    public void setUp() {
		tournament = new Tournament();
    }
	
	@Test
	public void testConstructors()
	{
		int size = 50;
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int i = 0; i < size; i++) {
			String name = Integer.toString(i);
			Player player = new Player(name);
			players.add(player);
        }
		
		tournament = new Tournament(players);
		
		assertEquals(tournament.getPlayers().size(), size);
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
		
		tournament.setPlayers(players);
		
		assertEquals(tournament.getPlayers().size(), size);
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
		
		tournament.setPlayers(players);
		
		assertEquals(tournament.getPlayers().get(0).getName(), name1);
		assertEquals(tournament.getPlayers().get(1).getName(), name2);
	}
	
	@Test
	public void testAddGame()
	{
		int size = 50;
		
		for (int i = 0; i < size; i++) {
			Game game = new Game();
			tournament.addGame(game);
        }
		
		assertEquals(tournament.getGames().size(), size);
	}
	
	@Test
	public void testGetGames()
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
		
		Tournament tournament = new Tournament();
		
		Game game1 = new Game(players);
		tournament.addGame(game1);
		game1.setWinner(player1);

		Game game2 = new Game(players);
		tournament.addGame(game2);
		game2.setWinner(player2);
		

		Game game3 = new Game(players);
		tournament.addGame(game3);
		game3.setWinner(player3);
	}
}
