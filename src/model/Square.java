package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows to create all the square of the gameboard
 * @author Thomas
 *
 */
public abstract class Square 
{
	private List<Piece>joueursSurLaCase;
	private int id;
	private static int nbCase=0;
	
	public Square() 
	{
		joueursSurLaCase=new ArrayList<>();
		id=nbCase;
		nbCase++;
	}
	
	/**
	 * add a piece on this square
	 * @param Piece p
	 */
	public void addPiece(Piece p){
		if(!joueursSurLaCase.contains(p)){
			joueursSurLaCase.add(p);
		}
	}
	
	/**
	 * remove a piece on this square
	 * @param Piece p
	 */
	public void removePiece(Piece p){
		if(joueursSurLaCase.contains(p)){
			joueursSurLaCase.remove(p);
		}
	}

	public int getIdCase() {
		return id;
	}

	public int getNbCase() {
		return nbCase;
	}
	
	public String toString(){
		return "id: "+id;
	}
	
	public abstract Category getCategorie();
	
	/**
	 * This method check if the player is on this square
	 * @param pie
	 * @return boolean
	 */
	public boolean getThisPiece(Piece pie){
		for(Piece p: joueursSurLaCase){
			if(p.equals(pie)){
				return true;
			}
		}
		return false;
	}
}
