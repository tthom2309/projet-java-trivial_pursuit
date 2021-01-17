package add;

import static org.junit.Assert.*;

import java.util.List;

import model.Category;
import model.Gamer;
import model.Piece;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.Explorateur;

public class PieceTest 
{
	private Gamer gamer;
	private Piece piece;
	private List<Category> cheese;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
	}

	@Before
	public void setUp() throws Exception 
	{
		gamer = new Gamer(null,null,null,null, null, null);
		//piece = new Piece(gamer);
		cheese = (List<Category>)Explorateur.getField(piece,"cheese");
	}

	@After
	public void tearDown() throws Exception 
	{
		piece = null;
		cheese = null;
	}

	
	

}
