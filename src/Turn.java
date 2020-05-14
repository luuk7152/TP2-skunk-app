import java.util.ArrayList;

public class Turn {
	
	private int turnScore;
	private boolean skunked;
	private ArrayList<Roll> turnRolls;
	
	
	public Turn()
	{
		this.turnRolls = new ArrayList<Roll>();
		this.skunked = false;
	}
	
	//getters and setters, baby!
	public void setScore(int score)
	{
		this.turnScore = score;
	}
	
	public int getScore()
	{
		return turnScore;
	}
}
