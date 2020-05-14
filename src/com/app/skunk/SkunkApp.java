package com.app.skunk;

public class SkunkApp {

	public Interface ui;
	public SkunkDomain skunkDomain;;
	
	
	public SkunkApp()
	{
		// Create UI layer
		ui = new Interface();
		
		// Create domain layer
		skunkDomain = new SkunkDomain(ui);
	}
	
	public void run()
	{
		skunkDomain.run();
	}
	
	public static void main(String[] args) 
	{
		new SkunkApp().run();
	}

}
