import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPlayer {

	private Player player;
	private String name;
	
	@BeforeEach
    void setup() {
		player = new Player(name);
    }
	
	@Test
	void test_player_constructor()
	{
		assertEquals(player.getClass().getName(), "Player");
	}
	
	@Test
	void test_get_name()
	{
		assertEquals(player.getName(), name);
	}
	
	@Test
	void test_set_name()
	{
		String newName = "Mary Johnson";
		player.setName(newName);
		
		assertEquals(player.getName(), newName);
	}
	
	@Test
	void test_get_chip_count()
	{
		int chipCount = 100;
		player = new Player(name, chipCount);
		
		assertEquals(player.getChipCount(), chipCount);
	}
	
	@Test
	void test_set_chip_count()
	{
		int newChipCount = 10;
		player.setChipCount(newChipCount);
		
		assertEquals(player.getChipCount(), newChipCount);
	}
	
}
