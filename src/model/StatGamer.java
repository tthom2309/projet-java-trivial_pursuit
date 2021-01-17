package model;

/**
 * This class allows to create objects wich contains a set of informations against of a gamer's statistiques of game.
 * Attribut nbVic concern the number of game won.
 * Attribut nbPoint concern the total of point won during games.
 * Attribut rankingPosVic concern the position that take up a gamer in the victory ranking.
 * Attribut rankingPosPoint concern the position that take up a gamer in the point ranking.
 * Attribut nbPart is the number of game played.
 * @author Christophe Decroos
 *
 */
public class StatGamer
{
	private int nbVic;
	private int nbPoint;
	private int rankingPosVic;
	private int rankingPosPoint;
	private int nbPart;
	
	public StatGamer(int rankingPosPoint, int rankingPosVic) 
	{
		nbVic = 0;
		nbPoint = 0;
		this.rankingPosPoint = rankingPosPoint;
		this.rankingPosVic = rankingPosVic;
		nbPart = 0;
	}

	public int getNbVic() 
	{
		return nbVic;
	}

	public int getNbPoint()
	{
		return nbPoint;
	}

	public int getRankingPosVic()
	{
		return rankingPosVic;
	}

	public int getRankingPosPoint() 
	{
		return rankingPosPoint;
	}
	
	

	public int getNbPart()
	{
		return nbPart;
	}

	/**
	 * @author Christophe Decroos
	 * Method which allows to increment nbVic.
	 */
	public void IncrementNbVic() 
	{
		nbVic++;
	}

	/**
	 * @author Christophe Decroos
	 * Method wich allows to increment nbPoint.
	 */
	public void IncrementNbPoint() 
	{
		nbPoint++;
	}
	
	/**
	 * @author Christophe Decroos
	 * Method wich allows to increment nbPart.
	 */
	public void IncrementNbPart()
	{
		nbPart++;
	}

	public void setRankingPosVic(int rankingPosVic)
	{
		this.rankingPosVic = rankingPosVic;
	}

	public void setRankingPosPoint(int rankingPosPoint) 
	{
		this.rankingPosPoint = rankingPosPoint;
	}
	
	
}
