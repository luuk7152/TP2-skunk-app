package com.app.skunk;

import java.util.ArrayList;

public class Tournament {

	private ArrayList<Player> players;
	private ArrayList<Game> games;
	
	//constructors
	public Tournament()
	{
		this.players = new ArrayList<Player>();
		this.games = new ArrayList<Game>();
	}
	
	public Tournament(ArrayList<Player> players)
	{
		this.players = players;
		this.games = new ArrayList<Game>();
	}
	
	//getters and setters
	public void setPlayers(ArrayList<Player> players)
	{
		this.players = players;
	}
	
	public ArrayList<Player> getPlayers()
	{
		return this.players;
	}
	
	public void addGame(Game game)
	{
		this.games.add(game);
	}
	
	public ArrayList<Game> getGames()
	{
		return this.games;
	}
	
	//methods
	public void resetPlayersScore()
	{
		for (Player player : players) {
			player.setScore(0);
		}
	}
	
}
