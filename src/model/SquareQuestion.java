package model;

/**
 * This class is an extend of the abstract class Square
 * It allows to create a question square 
 * @author Thomas
 *
 */
public class SquareQuestion extends Square{

	private Category categorie;
	
	public SquareQuestion(Category cat){
		super();
		this.categorie=cat;
	}

	public Category getCategorie() {
		return categorie;
	}
}
