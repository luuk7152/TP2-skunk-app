
public class Player {

	private String name;
	private int chipCount;
	
	
	// constructors
	Player(String name)
	{
		this.name = name;
		this.chipCount = 50; // starting chip count 
	}
	
	Player(String name, int chipCount)
	{
		this.name = name;
		this.chipCount = chipCount; // starting chip count 
	}
	
	
	// getters and setters
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public int getChipCount() 
	{
		return chipCount;
	}

	public void setChipCount(int chipCount) 
	{
		this.chipCount = chipCount;
	}
}
