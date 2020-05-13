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
	
	@Test
	void test_Single_Skunk_Outcome()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie3(); //forces a roll of 3
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getPenalty(), 1);
		
	}
	
	@Test
	void test_Double_Skunk_Outcome()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie1(); //forces a roll of 1
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getPenalty(), 4);
		
	}
	
	@Test
	void test_Skunk_Deuce_Outcome()
	{
		Die die1 = new CrookedDie1(); //forces a roll of 1
		Die die2 = new CrookedDie2(); //forces a roll of 2
		Dice dice = new Dice(die1, die2);
		roll = new Roll(dice);
		
		assertEquals(roll.getPenalty(), 2);
		
	}
}
