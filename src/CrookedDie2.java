public class CrookedDie2 extends Die
{
	public CrookedDie2()
	{
		
	}
	
	@Override
	public int getLastRoll()
	{
		return 2;
	}

	@Override
	public String toString()
	{
		return "A CrookedDie2 always rolling 2";
	}

}
