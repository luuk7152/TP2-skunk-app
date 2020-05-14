import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTurn {
	Turn turn;

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
	
}
