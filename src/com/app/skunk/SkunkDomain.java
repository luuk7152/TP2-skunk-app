package com.app.skunk;

import java.util.ArrayList;


public class SkunkDomain {

	public Interface ui;
	
	private Tournament tournament;
	private int kitty;
	
	private int TARGET_SCORE = 20;
	
	public SkunkDomain(Interface ui)
	{
		this.ui = ui;
		this.kitty = 0;
		this.tournament = new Tournament();
	}
	
	
	//game logic
	public void run()
	{
		ui.welcomeMessage();
		
		ArrayList<Player> players = this.setupPlayers();

		tournament.setPlayers(players);
		Boolean tournamentEnded = false;
		
		//start a tournament
		while (!tournamentEnded) {
			
			//start a new game
			Game game = new Game(tournament.getPlayers());

			tournament.addGame(game);
			ui.gameStartedMessage(tournament.getGames().size());
			
			Boolean gameEnded = false;
			Player currentPlayer = null;
			
			while (!gameEnded) {
				currentPlayer = game.getCurrentPlayer();
				gameEnded = this.playATurn(game, currentPlayer, false);
				game.setNextPlayer();
			}
			
			
			// game ended - allow one more turn for each non winner
			while (game.getCurrentPlayer() != game.getFirstWinner()) {
				currentPlayer = game.getCurrentPlayer();
				this.playATurn(game, currentPlayer, true);
				game.setNextPlayer();
			}
			
			Player winner = game.getWinner();
			winner.setChipCount(winner.getChipCount() + kitty);
			kitty = 0;
			
			ui.displayWinnerMessage(winner);
			
			//game ended
			ui.displayGameEndedMessage();
			//option to show current standing
			showStandingSummaryOption();
			
			Boolean playAgain = playAnotherGame();
			if(!playAgain) {
				tournamentEnded = true;
			} else {
				tournament.resetPlayersScore();
			}
		}
		
		ui.displayTournamentEndedMessage();
	}
	
	
	//setup players
	private ArrayList<Player> setupPlayers()
	{
		Integer playerCount = ui.promptPlayerCount();
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (int index = 1; index <= playerCount; index++) {
			String playerName = ui.promptPlayerName(index);
			Player player = new Player(playerName);
			players.add(player);
		}
		
		return players;
	}
	
	private Boolean playATurn(Game game, Player currentPlayer, Boolean lastTurn)
	{
		Boolean gameEnded = false;
		
		//start new turn
		Turn turn = new Turn();
		currentPlayer.setCurrentTurn(turn);
		
		if (lastTurn) {
			ui.lastTurnStartedMessage(currentPlayer);
		} else {
			ui.turnStartedMessage(currentPlayer);
		}
		
		String playerDecision = "";
		Boolean skunkRolled = false;
		
		
		//do while player chooses to roll
		do {
			
			//ask player's to roll or pass
			playerDecision = ui.promptRollOrPass(currentPlayer.getName()).toLowerCase();
			
			//handle player's decision
			switch (playerDecision) 
			{
				case "r":
					
					//roll dice and handle roll
					turn.roll();
					
					if (turn.isSkunked()) {
						
						skunkRolled = true;
						
						currentPlayer.handleSkunk();
						
						int penalty = turn.getPenalty();
						kitty = kitty + penalty;
						currentPlayer.setChipCount(currentPlayer.getChipCount() - penalty);
						
						game.endTurn();
						
						ui.skunkRolledMessage();
					}
					
					ui.turnRollReport(currentPlayer, turn);
					
					break;
					
				case "p":
					
					//end player's turn
					game.endTurn();
					ui.endTurnMessage(currentPlayer.getName());
					break;
				
				default: 
					ui.invalidInputMessage(); //handle invalid user input
					break;
			}
			
		} while (!"p".equals(playerDecision) && !skunkRolled);
		
		
		if (lastTurn) {
			
			if (currentPlayer.getScore() > game.getWinner().getScore()) { // if player reached previous winner score - set as new winner
				Player previousWinner = game.getWinner();
				game.setWinner(currentPlayer);
				ui.newWinnerMessage(currentPlayer, previousWinner);
			}
			
		} else {
			
			if (currentPlayer.getScore() >= TARGET_SCORE) { //player reached target score - end the game
				game.setWinner(currentPlayer);
				ui.targetScoreReachedMessage(currentPlayer);
				gameEnded = true; 
			}
			
		}
		
		this.showTurnSummaryOption(currentPlayer, turn);
		
		return gameEnded;
	}
	
	private void showTurnSummaryOption(Player player, Turn turn)
	{
		Boolean validSummaryInput = false;
		
		while (!validSummaryInput) {
			
			String showSummary = ui.promptShowTurnSummary();
		
			switch (showSummary)
			{
				case "y":
					ui.turnReport(player, turn);
					validSummaryInput = true;
					break;
					
				case "n":
					validSummaryInput = true;
					break;
				
				default: 
					ui.invalidInputMessage(); //handle invalid user input
					break;
			}
			
		}
	}
	
	private Boolean playAnotherGame()
	{
		Boolean playAgain = true;
		
		Boolean validInput = false;
		while (!validInput) {
			
			String continueTournamentDecision = ui.promptContinueTournament();
		
			switch (continueTournamentDecision)
			{
				case "y":
					playAgain = true;
					validInput = true;
					break;
					
				case "n":
					playAgain = false;
					validInput = true;
					break;
				
				default: 
					ui.invalidInputMessage(); //handle invalid user input
					break;
			}
			
		}
		
		return playAgain;
	}
	
	private void showStandingSummaryOption()
	{
		Boolean validSummaryInput = false;
		
		while (!validSummaryInput) {
			
			String showSummary = ui.promptShowStandingSummary();
		
			switch (showSummary)
			{
				case "y":
					ui.standingReport(tournament);
					validSummaryInput = true;
					break;
					
				case "n":
					validSummaryInput = true;
					break;
				
				default: 
					ui.invalidInputMessage(); //handle invalid user input
					break;
			}
			
		}
	} 
}
