import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestCrookedDie1 {
	
	private CrookedDie1 crDie;
	
	//getLastRoll
	
	@Test
	void test_Get_Last_Roll_Cr_Die1()
	{
		crDie = new CrookedDie1();
		assertEquals(crDie.getLastRoll(), 1);
		
	}
	
	@Test
	void test_To_String_Cr_Die1()
	{
		crDie = new CrookedDie1();
		assertEquals(crDie.toString(), "A CrookedDie1 always rolling 1 (a skunk)");
	}
}
