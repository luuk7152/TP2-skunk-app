import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTurn {
	Turn turn = new Turn();
	Roll roll;
	@BeforeEach
	void setUp()
	{
		turn = new Turn();
	}

	@Test
	void test_Turn_Constructor() 
	{
		assertEquals(turn.getClass().getName(), "Turn");
	
	
	}

	@Test
	void test_set_score()
	{
		turn.setScore(666);
		assertEquals(turn.getScore(), 666);
	}
	
	@Test
	void test_get_score()
	{
		turn.setScore(1122);
		assertEquals(turn.getScore(), 1122);
	}
	
	@Test
	void test_boolean_is_skunked()
	{
		assertFalse(turn.isSkunked());
	}
	
	@Test
	void test_add_roll()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie3(); //Rolls a 3
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice); //total roll 6
		
		turn.addRoll(roll);
		assertEquals(turn.getLastRoll(), 6);
		
	}
	
	@Test
	void test_get_last_roll()
	{
		Die die1 = new CrookedDie3(); //Rolls a 3
		Die die2 = new CrookedDie2(); //Rolls a 2
		
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);  //total roll 5
		
		turn.addRoll(roll);
		assertEquals(turn.getLastRoll(), 5);
	}
	
	
	
}
