package model;

import java.util.Random;
/**
 * This class is an extend of the abstract class Square
 * It allows to create the beginning square
 * @author Thomas
 *
 */
public class SquareBegin extends Square {

	private Category cat;
	
	public SquareBegin(){
		super();
	}
	
	public Category getCategorie(){
		Random ran = new Random();
		int valCat= ran.nextInt(6)+1;
		for(Category c: Category.values()){
			if(c.getId()==valCat){
				cat=c;
			}
		}
		return cat;
	}
}
