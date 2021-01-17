package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utility.Audio;
import model.Game;
import model.Piece;
import model.Play;
import model.Question;
import model.SquareBegin;
import model.SquareQuestionCheese;
import model.Stack;

/**
 * This class allows the see all questions of the game
 * @author Romain V
 *
 */
public class PanelQuestionView extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	private JLabel jlQuestion;
	private JPanel jpStatement, jpChoices;
	private Question question;
	private JButton jbTables[]; //tableau des boutons de choix
	private String selection; //String du bouton selectionné
	private String answer;
	private JButton jbMainMenu;
	private JButton jbQuit;
	private Audio son;
	private PanelPlateau panelPlateau;
	private JpSouth jpSouth;
	private PanelCamembert panelCamembert;
	
	
	/**
	 * This class contains some panels to view all questions
	 */
	public PanelQuestionView()
	{
	
		
		//Panel composé de la question, des 4choix de reponses sous forme de boutons
		
		
		JPanel gl = new JPanel();
		
		//Panel des 4boutons - réponse
		gl.add(getJpChoices());
//		Dimension dim = new Dimension(600,500);
//		gl.setPreferredSize(dim);
//		
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,3,1,100));
		center.add(getPanelPlateau());
		center.add(gl);
		center.add(getPanelCamembert());
		
		
		this.setLayout(new BorderLayout());
		this.add(center,BorderLayout.CENTER);
		this.add(getJpSouth(),BorderLayout.SOUTH);
		
	}

	public JpSouth getJpSouth()
	{
		if(jpSouth == null)
			jpSouth = new JpSouth();
		return jpSouth;
	}
	
	
	
	public PanelCamembert getPanelCamembert() {
		if(panelCamembert==null){
			panelCamembert = new PanelCamembert();
		}
		return panelCamembert;
	}

	public JPanel getPanelPlateau()
	{
		if(panelPlateau == null)
			panelPlateau = new PanelPlateau();
		return panelPlateau;
	}
	
	
	public JLabel getJlQuestion() 
	{
		jlQuestion = null;
		jlQuestion = new JLabel(getQuestion().getStatement());
		return jlQuestion;
	}


	public JPanel getJpStatement() 
	{
		if(jpStatement == null)
		{
			jpStatement = new JPanel();
			jpStatement.add(getJlQuestion());
		}
		return jpStatement;
	}


	public JPanel getJpChoices() 
	{
		if(jpChoices == null)
		{
			jpChoices = new JPanel(new GridLayout(5,1,10,10));
			jpChoices.add(getJpStatement());
			
			jbTables = new JButton[4];
			
			Set<Entry<String,Boolean>> entrees = question.getChoices().entrySet();
			Dimension dim = new Dimension(150, 35);
			int i=0;
			for(Entry<String, Boolean> e : entrees)
			{
			
				
				jbTables[i] = new JButton((String) e.getKey());
				jbTables[i].setPreferredSize(dim);
				jbTables[i].setBackground(Color.WHITE);
				if(e.getValue()==true){
					answer=e.getKey();
				}
				jpChoices.add(jbTables[i]);
				jbTables[i].addActionListener(this);
				i++;
			}
		}
		return jpChoices;
	}


	public Question getQuestion()
	{
		//Panel composé de la question, des 4choix de reponses sous forme de boutons
		question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
		
		return question;
	}


	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class, PanelQuestionView.this);
		selection = e.getActionCommand();
		if(selection==answer){
			Piece.getInstance().incrementCorrectAnswer();
			
			//réponse correcte sur une case camembert
			if(fenetre.isActiver()==true) // on joue le son si le son est activé
			{
				son = new Audio("Music/Correct.wav");
				son.start();
			}
			if(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()) instanceof SquareQuestionCheese)
			{
				String cheese="";
				if(Piece.getInstance().getCheese(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie())==false){
					cheese = " and the "+Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie()+" cheese.";
					Piece.getInstance().addCheese(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
				}
				else
				{
					cheese=".";
				}
				Piece.getInstance().addPoint(5);
				JOptionPane.showMessageDialog(null, "You won 5 points"+cheese,"Correct answer", JOptionPane.INFORMATION_MESSAGE);
			}
			
			//réponse correcte sur la case centrale
			else if(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()) instanceof SquareBegin){
				
				Piece.getInstance().addPoint(2);
				JOptionPane.showMessageDialog(null, "You won 2 points.","Correct answer", JOptionPane.INFORMATION_MESSAGE);
			}
			//réponse correcte à une simple case question
			else
			{
				Piece.getInstance().addPoint(1);
				JOptionPane.showMessageDialog(null, "You won 1 points","Correct answer", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
			
			
			//test pour savoir si la partie est terminé
			if(Play.isGameFinish(Game.getInstance()))
			{
				String message="Congratulations you finished the game.\n\nPoints: "+Piece.getInstance().getNbPoint()+"\nCorrect answer: "+Piece.getInstance().getCorrectAnswer()+"\nWrong answer: "+Piece.getInstance().getWrongAnswer();
				JOptionPane.showMessageDialog(null, message);
				//reset des données de l'instance Game et de l'instance Piece pour permettre de lancer une nouvelle partie sans être obligé de fermer l'application
//				Game.resetInstance();
//				Piece.resetInstance();
				//retour à la fenêtre d'accueil
				
//				fenetre.repaint();
//				fenetre.validate();
				//TODO j'ai mis quitter la partie sinon il se passe rien, quand j'essaye de quitter les panels du jeu
				System.exit(0);
				
			}
		}
		
		//réponse incorrecte
		
		else
		{
			Piece.getInstance().incrementWrongAnswer();
			JOptionPane.showMessageDialog(null, "You won nothing.","Wrong answer", JOptionPane.YES_OPTION);
		}
		Stack.getInstance().mixQuestion();
		fenetre.setContentPane(new PanelDice());
		fenetre.repaint();
		fenetre.revalidate();
	}
	
	
	

	

}


