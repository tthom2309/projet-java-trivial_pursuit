package model;

import java.util.Random;

/**
 * 
 *This class create the dice used in the game
 */
public class Dice 
{
	private int face;
	private static Dice instance = null;
	
	private Dice()
	{
		face = 1;
	}
	
	public static Dice getInstance()
	{
		if(instance == null)
			instance = new Dice();
		return instance;
	}
	
	/**
	 * This method "throw the dice" and return the value of this throw
	 * @return int 
	 */
	public int rollDice()
	{
		Random rand = new Random();
		face = rand.nextInt(6)+1;
		return face;
	}

	public int getFace() {
		return face;
	}

	
}
