
public class Roll {
	private Dice dice;
	private int score;
	
	Roll() 
	{
		dice = new Dice();
		dice.roll();
		this.score = dice.getLastRoll();
	}
	
	Roll(Dice dice) 
	{
		this.dice = dice;
		this.dice.roll();
		
		this.score = this.dice.getLastRoll();
	}
	
	public Dice getDice()
	{
		return dice;
	}
	
}
