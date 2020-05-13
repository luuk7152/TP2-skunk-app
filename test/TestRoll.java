import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRoll {
	
	private Roll roll;
	@BeforeEach
    public void setup() {
		roll = new Roll();
    }
	
	@Test
	void test_Roll_Constructor()
	{
		assertEquals(roll.getClass().getName(), "Roll");
	}
	
	@Test
	void test_Get_Dice()
	{
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		assertEquals(roll.getDice().getDie1Roll(), 1);
	}
	
	@Test
	void test_Get_Score()
	{
		Die die1 = new CrookedDie1();
		Die die2 = new CrookedDie1();
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getScore(), 2);
	}
}
