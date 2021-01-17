package view;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import utility.Serialisation;
import model.Category;
import model.Game;
import model.Piece;
import model.Question;
import model.Stack;

/**
 * 
 * @author Romain V
 *
 */
public class PanelCartes extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	private CardLayout cl;
	private PanelStart panelStart;
	private PanelAddQuestion panelAddQuestion;
	private PanelRanking panelRanking;
	private PanelQuestion panelQuestion;
	private PanelGame panelGame;
	private PanelJoueur panelJoueur;


	/**
	 * class of JPanel whit a CardLayout to display the other panel
	 */
	public PanelCartes()
	{
		/*
		 * Panel composé d'un cardlayout possédant le panel start (boutons du depart), panel pour ajouter une question
		 * et le panel classement pour afficher le classement
		 */
		this.setLayout(getCl());
		this.add(getPanelStart(),"Start");
		this.add(getPanelAddQuestion(),"AddQuestion");
		this.add(getPanelRanking(),"Classement");
		this.add(getPanelQuestion(),"Question"); 
		this.add(getPanelJoueur(),"Joueur");
		this.add(getPanelGame(),"Game");
	}

	
	
	/**
	 * Return the gamer of the game
	 * @return a player
	 */
	public PanelJoueur getPanelJoueur() 
	{
		if(panelJoueur == null)
		{
			panelJoueur = new PanelJoueur();
		}
		return panelJoueur;
	}

	
	
	/**
	 * Return the PanelGame 
	 * @return the first game panel
	 */
	public PanelGame getPanelGame() 
	{
		if(panelGame == null)
		{
			
			panelGame = new PanelGame();
		}
		return panelGame;
	}

	/**
	 * Return the cardlayout to show the correct panel
	 * @return the cardlayout associated to PanelCarte
	 */
	public CardLayout getCl()
	{
		if(cl == null)
			cl = new CardLayout();
		return cl;
	}

	/**
	 * The panel with the ranking of gamers
	 * @return PanelRanking
	 */
	public PanelRanking getPanelRanking() 
	{
		if(panelRanking == null)
			panelRanking = new PanelRanking();
		return panelRanking;
	}
	
	/**
	 * Return the start panel with the compoundButtons
	 * @return  PanelStart
	 */
	public PanelStart getPanelStart()
	{
		if(panelStart == null)
		{	
		        
			panelStart = new PanelStart(new Dimension(400,400));
		}
		return panelStart;
	}

	/**
	 * Return the panel to add a question
	 * @return PanelAddQuestion
	 */
	public PanelAddQuestion getPanelAddQuestion()
	{
		if(panelAddQuestion == null)
			panelAddQuestion = new PanelAddQuestion();
		return panelAddQuestion;
	}

	
	/**
	 * Return the panel with the questions' table
	 * @return PanelQuestion
	 */
	public PanelQuestion getPanelQuestion() 
	{
		if(panelQuestion == null)
		{
			panelQuestion = new PanelQuestion();
			Stack.getInstance().ajoute(panelQuestion); // on Ajoute l'observer 
		}
		return panelQuestion;
	}


}
