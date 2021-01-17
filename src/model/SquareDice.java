package model;

/**
 * This class is an extend of the abstract class Square
 * It allows to create a throw dice square
 * @author Thomas
 *
 */
public class SquareDice extends Square{

	private Category cat;
	
	public SquareDice(){
		super();
		cat=null;
	}
	
	public Category getCategorie(){
		return cat;
	}
}
