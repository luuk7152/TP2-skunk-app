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
}
