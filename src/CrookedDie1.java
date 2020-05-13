public class CrookedDie1 extends Die
{
	public CrookedDie1()
	{
		
	}
	
	@Override
	public int getLastRoll()
	{
		return 1;
	}

	@Override
	public String toString()
	{
		return "A CrookedDie1 always rolling 1 (a skunk)";
	}
}
