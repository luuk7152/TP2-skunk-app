import java.util.ArrayList;

public class Turn {
	
	private int turnScore;
	private boolean skunked;
	private ArrayList<Roll> turnRolls;
	
	//constructors
	public Turn()
	{
		this.turnRolls = new ArrayList<Roll>();
		this.skunked = false;
	}
	
	public Turn(ArrayList<Roll> Rolls) //This constructor simply for testing the getTurnRolls()
	{
		this.turnRolls = Rolls;
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
	
	public boolean isSkunked()
	{
		return skunked;
	}
	
	public void addRoll(Roll roll)
	{
		turnRolls.add(roll);
	}
	
	public Roll getLastRoll()
	{
		return turnRolls.get(turnRolls.size()-1);
	}
	
	public void addScore(Roll roll)
	{
		
	}
}
