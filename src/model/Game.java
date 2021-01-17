package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * This class allow to create the game instance
 * @author Thomas
 *
 */
public class Game implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static int numGame = 0;
	private String date;
	private static Game instance = null;
	private GameBoard gameBoard;
	private Dice dice;
	private List<Piece> listGamers;
	
	private Game() 
	{
		date = dateToday();
		numGame++;
		dice = Dice.getInstance();
		gameBoard = GameBoard.getInstance();
		listGamers = new ArrayList<Piece>();
		
	}
	
	public Dice getDice() {
		return dice;
	}

	public static void resetInstance(){
		instance=null;
	}
	
	public static Game getInstance(){
		if(instance == null)
			instance = new Game();
		return instance;
	}
	
	public static int getNumGame()
	{
		return numGame;
	}
	
	public String getDate() 
	{
		return date;
	}
	
	public Piece getPiece(int index)
	{
		return listGamers.get(index);
	}
	
	
	/**
	 * Method wich allows to retrieve the date of today and which convert this into the type String
	 * @author Christophe Decroos
	 * @return String
	 */
	public static String dateToday()
	{
		Calendar calendar = Calendar.getInstance();
		
		int day  = calendar.get(Calendar.DAY_OF_MONTH);
		int month  = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);

		return String.format("%02d/%02d/%4d", day, month, year);
	}
	
	public boolean addPiece(Piece p)
	{
		if(!listGamers.contains(p))
			return listGamers.add(p);
		return false;
	}
	
	public boolean removePiece(Piece p)
	{
		return listGamers.remove(p);
	}

	public  GameBoard getGameBoard() {
		return gameBoard;
	}

	public List<Piece> getListGamers() {
		return listGamers;
	}
	
	/**
	 * This method check if one of players has the 6 cheeses
	 * @return boolean
	 */
	
	public boolean isGetSixCheese(){;
		for(Piece p: listGamers){
			if(p.isGetSixCheese()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method put the player on the gameboard
	 */
	public void putPlayerOnGameBoard(){
		for(Piece p: listGamers){
			gameBoard.initializePiece(p);
		}
	}
	
	
	
	
	
	
	

}
