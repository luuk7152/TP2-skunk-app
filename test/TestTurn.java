import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
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
	void test_Turn_Constructor		() 
	{
		assertEquals(turn.getClass().getName(), "Turn");
	
	}

}
