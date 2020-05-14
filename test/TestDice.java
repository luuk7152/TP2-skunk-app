import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDice {

	private Dice dice;
	
	List<Integer> validDieValues = Arrays.asList(1,2,3,4,5,6);
	List<Integer> validDiceValues = Arrays.asList(2,3,4,5,6,7,8,9,10,11,12);
	
	@BeforeEach
    public void setUp() {
		dice = new Dice();
    }
	
	@Test
	public void test_constructor_with_initial_die() 
	{
		Die die1 = new Die();
		Die die2 = new Die();
		
		Object dice = new Dice(die1, die2);
		
		assertEquals(dice.getClass().getName(), "Dice");
	}
	
	@Test
	public void test_get_die() 
	{
		Object die1 = dice.getDie1();
		Object die2 = dice.getDie2();
		
		assertEquals(die1.getClass().getName(), "Die");
		assertEquals(die2.getClass().getName(), "Die");
		
	}
	
	@Test
	public void test_get_die_roll() 
	{
		dice.roll();
		int die1roll = dice.getDie1Roll();
		int die2roll = dice.getDie2Roll();
		
		assertTrue(validDieValues.contains(die1roll));
		assertTrue(validDieValues.contains(die2roll));
	}
	
	
	@Test
	public void test_get_last_roll() 
	{
		dice.roll();
		int roll = dice.getLastRoll();
		
		assertTrue(validDiceValues.contains(roll));
	}
	
	@Test
	public void test_generate_random_number_between_2_and_12()
	{
		for (int i = 1; i < 100000; i++) {
			
			dice.roll();
			int roll = dice.getLastRoll();
			
			assertTrue(validDiceValues.contains(roll));
        }
	}
	
	@Test
	public void test_display_dice_toString() 
	{
		dice.roll();	
		assertTrue( dice.toString().equals("Dice Roll: " + dice.getLastRoll() + " => " + dice.getDie1Roll() + " + " + dice.getDie2Roll()) );
	}
}
