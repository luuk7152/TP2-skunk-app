import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDie {
	
	private Die die;
	
	List<Integer> validValues = Arrays.asList(1,2,3,4,5,6);


	
	@BeforeEach
    public void setup() {
		die = new Die();
    }
	
	@Test
	public void test_get_last_roll() 
	{
		die.roll();
		int roll = die.getLastRoll();
		
		assertTrue(validValues.contains(roll));	
	}
	
	@Test
	public void test_generate_random_number_between_1_and_6()
	{
		Die die = new Die();
		
		for (int i = 1; i < 100000; i++) {
			
			die.roll();
			int roll = die.getLastRoll();
			
			assertTrue(validValues.contains(roll));
        }
	}
	
	@Test
	public void test_display_die_toString() 
	{
		die.roll();
		int roll = die.getLastRoll();
		
		assertTrue(die.toString().equals("A " + roll + " was rolled"));
	}
	
}
