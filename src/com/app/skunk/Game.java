package com.app.skunk;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	
	private Player currentPlayer;
	
	private Player winner = null;
	
	//constructors
	public Game()
	{
		this.players = new ArrayList<Player>();
	}
	
	public Game(ArrayList<Player> players)
	{
		this.players = players;
		this.currentPlayer = this.players.get(0);
	}
	
	//getters and setters
	public void setPlayers(ArrayList<Player> players)
	{
		this.players = players;
		this.currentPlayer = this.players.get(0);
	}
	
	public ArrayList<Player> getPlayers()
	{
		return this.players;
	}
	
	public void setCurrentPlayer(Player player)
	{
		this.currentPlayer = player;
	}
	
	public Player getCurrentPlayer()
	{
		return this.currentPlayer;
	}
	
	public void setWinner(Player player)
	{
		this.winner = player;
	}
	
	public Player getWinner()
	{
		return this.winner;
	}
	
	//methods
	public void setNextPlayer()
	{	
		int nextPlayerIndex = (players.indexOf(currentPlayer) + 1) % players.size();
		currentPlayer = players.get(nextPlayerIndex);
	}
	
}
