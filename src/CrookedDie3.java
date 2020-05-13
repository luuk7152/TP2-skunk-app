public class CrookedDie3 extends Die
{
	public CrookedDie3()
	{
		
	}
	
	@Override
	public int getLastRoll()
	{
		return 3;
	}

	@Override
	public String toString()
	{
		return "A CrookedDie3 always rolling 3";
	}

}