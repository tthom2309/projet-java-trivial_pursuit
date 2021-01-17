package add;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Calendar;
import java.util.List;

import model.Administrator;
import model.Category;
import model.Game;
import model.IteratorQuestionCategory;
import model.Piece;
import model.Question;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.Explorateur;

public class GameTest
{
	private Game game;
	private List<Piece> listGamers;
	private Piece p;
	@Before
	public void setUp() throws Exception 
	{
		game = Game.getInstance();
		listGamers =(List<Piece>)Explorateur.getField(game,"listGamers");
		p = Piece.getInstance();
	}

	@After
	public void tearDown() throws Exception 
	{
		// Les 3 instructions suivantes permettent de tester n'importe quel Singleton grâce à l'introspection.
				java.lang.reflect.Field instance = Game.class.getDeclaredField("instance");// On récupère l'attribut "instance".
				// que l'on place dans un objet "Field".
				instance.setAccessible(true); // On rend l'objet "Field" accessible.
				instance.set(null, null);// On donne la valeur null à l'attribut "instance".
				game = null; // On donne la valeur null au référent de l'instance.
				p=null;
	}
	
	@Test
	public void testDateToday()
	{
		Calendar calendar = Calendar.getInstance();
		int day  = calendar.get(Calendar.DAY_OF_MONTH);
		int month  = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		assertTrue(String.format("%02d/%02d/%4d", day, month, year).equals(Game.dateToday()));
	}
	
	@Test
	public void testAddPiece()
	{
		
		listGamers.add(p);
	}

}
