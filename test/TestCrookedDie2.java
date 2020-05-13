import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCrookedDie2 {
	private CrookedDie2 crDie;
	//getLastRoll
	
	@Test
	void test_Get_Last_Roll_Cr_Die2()
	{
		crDie = new CrookedDie2();
		assertEquals(crDie.getLastRoll(), 2);
		
	}
	
	@Test
	void test_To_String_Cr_Die2()
	{
		crDie = new CrookedDie2();
		assertEquals(crDie.toString(), "A CrookedDie2 always rolling 2");
	}
}
