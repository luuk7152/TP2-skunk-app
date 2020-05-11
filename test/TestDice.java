import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDice {

	private Dice dice;
	
	List<Integer> validDieValues = Arrays.asList(1,2,3,4,5,6);
	List<Integer> validDiceValues = Arrays.asList(2,3,4,5,6,7,8,9,10,11,12);
	
	@BeforeEach
    public void setup() {
		dice = new Dice();
    }
	
	@Test
	public void test_get_die() 
	{
		

	}
	
	@Test
	public void test_get_die_roll() 
	{
		

	}
	
	
	@Test
	public void test_get_last_roll() 
	{
		

	}
	
	@Test
	public void test_display_dice_toString() 
	{
		
		
	}

}
