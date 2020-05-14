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
	
	void test_get_name()
	{
		assertEquals(player.getName(), name);
	}
	
	void test_set_name()
	{
		String newName = "Mary Johnson";
		player.setName(newName);
		
		assertEquals(player.getName(), newName);
	}
	
}
