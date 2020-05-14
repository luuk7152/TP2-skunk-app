package com.app.skunk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {

	private Game game;
	
	@BeforeEach
    void setUp() {
		game = new Game();
    }
	
	@Test
	void testGameConstructor()
	{
		assertEquals(game.getClass().getSimpleName(), "Game");
	}
	
}
