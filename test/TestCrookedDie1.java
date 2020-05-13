import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	
}
