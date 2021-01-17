package model;

import java.io.Serializable;
import java.util.HashMap;


/**
 * This class allows to associate a Gamer with a Piece to play a game of Trivial Pursuit.
 * Attribut nbPoint is the number of point that the gamer (object Piece) has won during the game.
 * Attribut result is the rank that the gamer (object Piece) has reached at the end of the game.
 * Attribut cheese contains the list of type of special question answered by a gamer (object Piece) during the game.
 * Atribut gamer is the Gamer associted with the Piece.
 * Attribut square is the Square of the GameBoard where is the Piece.
 * @author Christophe Decroos
 *
 */
public class Piece implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int nbPoint;
	private int result;
	private static Piece instance = null;
	private HashMap<Category,Boolean> cheese;
	private int id;
	private int correctAnswer;
	private int wrongAnswer;
	private static int nbPiece=1;
	//private Gamer gamer;
	
	private Piece()
	{
		//this.gamer=gamer;
		this.nbPoint=0;
		this.id=nbPiece;
		this.result=nbPiece;
		this.cheese = new HashMap<Category, Boolean>(6);
		this.correctAnswer=0;
		this.wrongAnswer=0;
		initializeCheese();
	}

	public static void resetInstance(){
		instance=null;
	}
	
	public static Piece getInstance(){
		if(instance == null)
			instance = new  Piece();
		return instance;
	}

	public int getResult() {
		return result;
	}


	/**
	 * This method check if the player got the cheese of the category in the parameter
	 * @param cat
	 * @return
	 */
	public boolean getCheese(Category cat) {
		if(cheese.containsKey(cat)){
			return cheese.get(cat);
		}
		return false;
	}



	public int getId() {
		return id;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public int getWrongAnswer() {
		return wrongAnswer;
	}

	public static int getNbPiece() {
		return nbPiece;
	}


	public int getNbPoint() 
	{
		return nbPoint;
	}

	
	/**
	 * This method initialize the cheese of the gamer 
	 * @author Thomas Tratskas
	 */
	
	public void initializeCheese(){
		for(int i=1;i<=6;i++){
			for(Category c: Category.values()){
				if(c.getId()==i){
					cheese.put(c,false);
				}
			}
		}
	}
	

	/**
	 * This method allows to add points.
	 * @author Christophe Decroos
	 * @param result
	 */
	public void addPoint(int point)
	{
		nbPoint+=point;
	}
	
	
	/**
	 * This method add one cheese at this player
	 * @param c Category of the cheese added
	 */
	public void addCheese(Category c){
		if(cheese.containsKey(c)){
			cheese.put(c, true);
		}
	}
	
	/**
	 * This method check if the player got the six cheeses
	 * @return boolean
	 */
	
	public boolean isGetSixCheese(){
		if(cheese.containsValue(false)){
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void incrementWrongAnswer(){
		this.wrongAnswer++;
	}
	
	public void incrementCorrectAnswer(){
		this.correctAnswer++;
	}
}
