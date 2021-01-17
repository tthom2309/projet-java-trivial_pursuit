package add;

import static org.junit.Assert.*;
import model.Gamer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.BirthdayGamerException;
import exception.EmailGamerException;

public class GamerTest 
{
	Gamer gamer;
	
	@Before
	public void setUp() throws Exception 
	{
		gamer = new Gamer("toto01", "helha", "toto01@student.helha.be", "Reporter", "Tintin", "28/04/1998");
	}

	@After
	public void tearDown() throws Exception
	{
		gamer = null;
	}

	@Test
	public void testEquals() 
	{
		Gamer gamerTest1 = null;
		try {
			gamerTest1 = new Gamer("toto01", "helha", "toto01@student.helha.be", "Reporter", "Tintin", "28/04/1998");
		} catch (BirthdayGamerException | EmailGamerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gamer gamerTest2 = null;
		try {
			gamerTest2 = new Gamer("toto02", "helha", "toto01@student.helha.be", "Reporter", "Tintin", "28/04/1998");
		} catch (BirthdayGamerException | EmailGamerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(gamer.equals(gamerTest1) && !gamer.equals(gamerTest2));
	}

	
}
