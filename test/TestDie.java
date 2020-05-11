import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDie {
	
	private Die die;
	
	@BeforeEach
    public void setup() {
		die = new Die();
    }
	
	@Test
	public void test_get_last_roll() 
	{
		die.roll();
		int roll = die.getLastRoll();
	}

	@Test
	public void test_generate_random_number_between_1_and_6()
	{
		Die die = new Die();
		
		for (int i = 1; i < 100000; i++) {
			
			die.roll();
			int roll = die.getLastRoll();
			
			assertTrue(roll >= 1 && roll <= 6);
			
        }
	}
	
	@Test
	public void test_display_class_toString_message() 
	{
		die.roll();
		int roll = die.getLastRoll();
		
		assertTrue(die.toString().equals("A " + roll + " was rolled"));
	}
	
}
