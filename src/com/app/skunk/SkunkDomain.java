package com.app.skunk;

import java.util.ArrayList;


public class SkunkDomain {

	public Interface ui;
	private ArrayList<Player> players;
	private int kitty;
	
	private int TARGET_SCORE = 20;
	
	public SkunkDomain(Interface ui)
	{
		this.ui = ui;
		this.kitty = 0;
		this.players = new ArrayList<Player>();
	}
	
	
	//game logic
	public void run()
	{
		ui.welcomeMessage();
		
		Integer playerCount = ui.promptPlayerCount();
		
		for (int index = 1; index <= playerCount; index++) {
			
			String playerName = ui.promptPlayerName(index);
			Player player = new Player(playerName);
			
			this.players.add(player);
		}
		
		
		//start a new game
		Game game = new Game(this.players);
		
		Boolean gameEnded = false;
		Player currentPlayer = null;
		
		while (!gameEnded) {
			
			currentPlayer = game.getCurrentPlayer();
			
			//start new turn
			Turn turn = new Turn();
			currentPlayer.setCurrentTurn(turn);
			
			ui.turnStartedMessage(currentPlayer);
			
			String playerDecision = "";
			Boolean skunkRolled = false;
			
			//do while player chooses to roll
			do {
				
				//ask player's to roll or pass
				playerDecision = ui.promptRollOrPass(currentPlayer.getName());
				
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
				}
				
			} while (!playerDecision.equals("p") && !skunkRolled);
			
			
			//player reached target score - end game
			if (currentPlayer.getScore() >= TARGET_SCORE) {
				gameEnded = true; 
				game.setWinner(currentPlayer);
				ui.targetScoreReachedMessage(currentPlayer);
			};
			
			boolean validSummaryInput = false;
			
			while (!validSummaryInput) {
	
				String showSummary = ui.promptShowTurnSummary();
			
				switch (showSummary)
				{
					case "y":
						ui.turnReport(currentPlayer, turn);
						validSummaryInput = true;
						break;
						
					case "n":
						validSummaryInput = true;
						break;
					
					default: 
						ui.invalidInputMessage(); //handle invalid user input
				}
				
			};
			
			game.setNextPlayer();
		}
		
		
		// game ended - allow one more turn for each non winner
		while (game.getCurrentPlayer() != game.getFirstWinner()) {
			
			currentPlayer = game.getCurrentPlayer();
			
			Turn turn = new Turn();
			currentPlayer.setCurrentTurn(turn);
			
			ui.lastTurnStartedMessage(currentPlayer);
			
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
				}
				
			} while (!playerDecision.equals("p") && !skunkRolled);
			
			
			// if player reached target score
			if (currentPlayer.getScore() > game.getWinner().getScore()) {
				Player previousWinner = game.getWinner();
				game.setWinner(currentPlayer);
				ui.newWinnerMessage(currentPlayer, previousWinner);
			};

			game.setNextPlayer();
		}
		
		Player winner = game.getWinner();
		winner.setChipCount(winner.getChipCount() + kitty);
		kitty = 0;
		
		ui.displayWinnerMessage(winner);
		
		// Game ended
		ui.displayGameEndedMessage();
	}
}
