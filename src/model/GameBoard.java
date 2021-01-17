package model;

import java.util.ArrayList;
import java.util.List;

public class GameBoard 
{
	private List<Square> listSquare;
	private static GameBoard instance = null;
	private final int NB_SQUARE=73;
	
	private GameBoard()
	{
		listSquare = new ArrayList<Square>();
		fillGameBoard();
	}
	
	/**
	 * This method add a square in the Game Board
	 * @param Square s
	 */
	private void addSquare(Square s){
		listSquare.add(s);
	}
	
	/**
	 * This method do a new SquareQuestion
	 * @param cheese
	 * @param cat
	 * @return
	 */
	private Square newSquareQuestion(boolean cheese,Category cat){
		if(cheese==true){
			return new SquareQuestionCheese(cat);
		}
		return new SquareQuestion(cat);
	}
	
	/**
	 *This method fill the gameboard with the Squares
	 */
	private void fillGameBoard(){
		SquareBegin begin = new SquareBegin();
		addSquare(begin);
		//correspond au numéro id des catégories pour les CaseQuestionCamembert
		int numCamembert=1;
		
		//Boucle qui va remplir le plateau des différentes cases 
		while(begin.getNbCase()!=NB_SQUARE){
			
			//création des cases camemberts
			if(begin.getNbCase()==6 || begin.getNbCase()==18 || begin.getNbCase()==30 || begin.getNbCase()==42 || begin.getNbCase()==54 || begin.getNbCase()==66){
				for(Category c:Category.values()){
					if(c.getId()==numCamembert){
						addSquare(newSquareQuestion(true, c));
					}
				}
				numCamembert++;
			}
			
			//création de case relancer dés
			if(begin.getNbCase()==8 || begin.getNbCase()==11 || begin.getNbCase()==20 || begin.getNbCase()==23 || begin.getNbCase()==32 || begin.getNbCase()==35 || begin.getNbCase()==44 || begin.getNbCase()==47 || begin.getNbCase()==56 || begin.getNbCase()==59 || begin.getNbCase()==68 || begin.getNbCase()==71){
				addSquare(new SquareDice());
			}
			
			//création des cases questions
			//case Geography
			if(begin.getNbCase()==13 || begin.getNbCase()==22 || begin.getNbCase()==28 || begin.getNbCase()==36 || begin.getNbCase()==41 || begin.getNbCase()==43 || begin.getNbCase()==51 || begin.getNbCase()==57 || begin.getNbCase()==62){
				for(Category c:Category.values()){
					if(c.getId()==1){
						addSquare(newSquareQuestion(false, c));
					}
				}
			}
			//case Entertainement
			if(begin.getNbCase()==2 || begin.getNbCase()==25 || begin.getNbCase()==34 || begin.getNbCase()==40 || begin.getNbCase()==48 || begin.getNbCase()==53 || begin.getNbCase()==55 || begin.getNbCase()==63 || begin.getNbCase()==69){
				for(Category c:Category.values()){
					if(c.getId()==2){
						addSquare(newSquareQuestion(false, c));
					}
				}
			}
			//case History
			if(begin.getNbCase()==3 || begin.getNbCase()==9 || begin.getNbCase()==14 || begin.getNbCase()==37 || begin.getNbCase()==46 || begin.getNbCase()==52 || begin.getNbCase()==60 || begin.getNbCase()==65 || begin.getNbCase()==67){
				for(Category c:Category.values()){
					if(c.getId()==3){
						addSquare(newSquareQuestion(false, c));
					}
				}
			}
			//case Business
			if(begin.getNbCase()==5 || begin.getNbCase()==7 || begin.getNbCase()==15 || begin.getNbCase()==21 || begin.getNbCase()==26 || begin.getNbCase()==49 || begin.getNbCase()==58 || begin.getNbCase()==64 || begin.getNbCase()==72){
				for(Category c:Category.values()){
					if(c.getId()==4){
						addSquare(newSquareQuestion(false, c));
					}
				}
			}
			//case Science Nature
			if(begin.getNbCase()==4 || begin.getNbCase()==12 || begin.getNbCase()==17 || begin.getNbCase()==19 || begin.getNbCase()==27 || begin.getNbCase()==33 || begin.getNbCase()==38 || begin.getNbCase()==61 || begin.getNbCase()==70){
				for(Category c:Category.values()){
					if(c.getId()==5){
						addSquare(newSquareQuestion(false, c));
					}
				}
			}
			//case Sport Leisure
			if(begin.getNbCase()==1 || begin.getNbCase()==10 || begin.getNbCase()==16 || begin.getNbCase()==24 || begin.getNbCase()==29 || begin.getNbCase()==31 || begin.getNbCase()==39 || begin.getNbCase()==45 || begin.getNbCase()==50 ){
				for(Category c:Category.values()){
					if(c.getId()==6){
						addSquare(newSquareQuestion(false, c));
					}
				}
			}
		}
	}
	
	public int getNB_SQUARE() {
		return NB_SQUARE;
	}

	public static GameBoard getInstance()
	{
		if(instance == null)
			instance = new GameBoard();
		return instance;
	}
	
	public Square getSquare(int ind)
	{
		return listSquare.get(ind);
	}

	/**
	 * Cette méthode renvoie la catégorie de la case dont l'id est passé en paramètre
	 * @param id
	 * @return Category
	 */
	public Category getCategorySquare(int id){
		for(Square s: listSquare){
			if(s.getIdCase()==id){
				return s.getCategorie();
			}
		}
		return null;
	}
	
	/**
	 * This method put a piece at the beginning of the gameboard
	 * @param p
	 */
	public void initializePiece(Piece p){
		for(Square s: listSquare){
			if(s instanceof SquareBegin){
				s.addPiece(p);
			}
		}
	}
	
	/**
	 * This method return the square where the player is
	 * @param p
	 * @return
	 */
	
	public Square getSquareContainsPiece(Piece p){
		for(Square s: listSquare){
			if(s.getThisPiece(p)){
				return s;
			}
		}
		return null;
	}
	
	/**
	 * This method return the id of the square where the player is
	 * @param p
	 * @return
	 */
	public int getIdSquareContainsPiece(Piece p){
		for(Square s: listSquare){
			if(s.getThisPiece(p)){
				return s.getIdCase();
			}
		}
		return 0;
	}
	
	
}
