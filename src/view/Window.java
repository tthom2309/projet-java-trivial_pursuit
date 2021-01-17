package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import utility.Audio;
import model.Gamer;
import model.Stack;

/**
 * 
 * @author Romain V
 *
 */
public class Window extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private Audio son;
	boolean activer = true; // Son activer/désactiver
	

	private JMenuBar jmBar;
	
	private JMenu jmFichier;
	private JMenu jmQuestion;
	private JMenu jmAboutQuestions;
	

	private JMenuItem jmiFermer;
	private JMenuItem jmiSon;
	

	private JMenuItem jmiAddQuestion;
	private JMenuItem jmiLogout; // se deconnecter
	private JMenuItem jmiLogin; // se connecter

	private PanelCartes panelCartes;
	
	private Stack stack;
	
	private Boolean isAdmin; //true si connecté en tant qu'administrateur pour ajouter ou supprimer des questions
	private Boolean isConnected; // true si un joueur est connecté
	
	private Gamer player; //joueur qui est connecté au jeu
	


	/**
	 * This class contains the main frame of the game
	 */
	public Window()
	{
		/*
		 * Fenetre principale du jeu
		 */
		
		this.setTitle("Trivial Pursuit");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension taille = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int) taille.getWidth()/4, (int) taille.getWidth()/4);
		this.setMinimumSize(new Dimension(1300,800));
		this.setLocationRelativeTo(null);
		son = new Audio("Music/Trivia.wav");
		son.start();
		
		
		
		//Initialisation des menus
		
		
		this.getJmAboutQuestions().add(getJmiAddQuestion());
		this.getJmFichier().add(getJmiLogin());
		this.getJmFichier().add(getJmAboutQuestions());
		this.getJmFichier().add(getJmiLogout());
		this.getJmFichier().add(getJmiSon());
		this.getJmFichier().add(getJmiFermer());
		this.getJmBar().add(getJmFichier());
		this.getJmBar().add(getJmQuestion());
		
		//ajout du menu à la Frame
		this.setJMenuBar(jmBar);
		
	
		// ajout du panel cardLayout
		this.add(getPanelCartes(), BorderLayout.CENTER);
        this.pack();
        
        //initialisations des connections
        this.isAdmin = false;
        this.isConnected = false;
		
		
	}
	
	
	/**
	 * Return the player of the game
	 * @return Player
	 */
	public Gamer getPlayer()
	{
		return player;
	}


	/**
	 * Change the game player
	 * @param player
	 */
	public void setPlayer(Gamer player) 
	{
		this.player = player;
	}


	/**
	 * Return the list of questions
	 * @return stack
	 */
	public Stack getStack() 
	{
		if(stack == null)
			stack = Stack.getInstance();
		return stack;
	}
	
	
	/**
	 * Return the main Panel with the cardLayout to show panels of the game
	 * @return panelcartes
	 */
	public PanelCartes getPanelCartes()
	{
		if(panelCartes == null)
			panelCartes = new PanelCartes();
		return panelCartes;
	}
	


	/**
	 * The JMenu about questions
	 * @return JMenu
	 */
	public JMenu getJmAboutQuestions() 
	{
		if(jmAboutQuestions == null)
		{
			jmAboutQuestions = new JMenu("About Questions");
		}
		return jmAboutQuestions;
	}


	/**
	 * Return the boolean is the player connected is an admin
	 * @return true if admin, false if not admin
	 * 
	 */
	public Boolean getIsAdmin() 
	{
		return isAdmin;
	}


	/**
	 * Change the value of admin boolean
	 * @param isAdmin
	 */
	public void setIsAdmin(Boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}


	/**
	 * Return the boolean about connection
	 * @return true if a player is logged, false if not
	 */
	public Boolean getIsConnected() 
	{
		return isConnected;
	}


	/**
	 * Change the value of the boolean about the logged player
	 * @param isConnected
	 */
	public void setIsConnected(Boolean isConnected) 
	{
		this.isConnected = isConnected;
	}


	/**
	 * Return the JMenuItem to logout of the game
	 * @return JMenuItem logout
	 */
	public JMenuItem getJmiLogout() 
	{
		if(jmiLogout == null)
		{
			jmiLogout = new JMenuItem("Logout");
			jmiLogout.setEnabled(false);
			jmiLogout.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e)
				{
					//on passe à false toutes les valeurs
					setIsAdmin(false);
					setIsConnected(false);
					setPlayer(null);
					
					//on desactive le bouton Logout
					Window.this.getJmiLogout().setEnabled(false);	
					
					//Comme on se deconnecte on revient sur la page du début
					getPanelCartes().getCl().show(getPanelCartes(), "Start");
					
					// On desactive les boutons Admin
					desactiveButtonsQuestions();
					
					//on active le bouton login
					Window.this.getJmiLogin().setEnabled(true);
				
					JOptionPane.showMessageDialog(null, "Logout succesfull !", "Information", JOptionPane.INFORMATION_MESSAGE);
				
					
				}
				
			});
		}
		return jmiLogout;
	}


	/**
	 * This method can disabled all buttons which the admin can use
	 */
	private void desactiveButtonsQuestions()
	{
		//desactivation du bouton ajouterQuestion dans la barre de fenetre
		getJmiAddQuestion().setEnabled(false);
		
		//desactivation des boutons ajouter et supprimer question du panelQuestion
		PanelButtons panelButtonsQuestion = Window.this.getPanelCartes().getPanelQuestion().getPanelButtons();
		panelButtonsQuestion.getJbAjouter().setVisible(false);
		panelButtonsQuestion.getjbSupprimer().setVisible(false);
		
		//désactivation du bouton login //TODO changer par le nom de la personne
		getJmiLogin().setEnabled(false);
		
	}
	
	/**
	 * Return the JMenuItem wich the player enters his login and password
	 * @return JMenuItem login
	 */
	public JMenuItem getJmiLogin()
	{
		if(jmiLogin == null)
		{
			jmiLogin = new JMenuItem("Login");
			jmiLogin.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					PanelLogin panelLogin = new PanelLogin();
					
					
					int choixLog = panelLogin.isVerifyLoginAdmin();
					
					if(choixLog == 0) // annulation
					{
						
					}
					else if(choixLog == 1) // connecté
					{
						isConnected = true;
						
						//on récupere le joueur connecté
						Window.this.setPlayer(panelLogin.getPlayer()); 
						
						//on active le logout
						Window.this.getJmiLogout().setEnabled(true);
						
						// on desactive les boutons Admin
						desactiveButtonsQuestions();
					
						JOptionPane.showMessageDialog(null, "Logout succesfull as player !", "Information", JOptionPane.INFORMATION_MESSAGE);
						
					}
						
					else // connecté en admin
					{
						
						//TODO on ne recupere pas l'admin pour le jeu ici
						
						// on active le bouton ajouter question et le logout
						isAdmin = true;
						isConnected = true;
						Window.this.getJmiAddQuestion().setEnabled(true);
						Window.this.getJmiLogout().setEnabled(true);
						
						// on active les boutons ajouter et supprimer du panelQuestion
						PanelButtons panelButtonsQuestion = Window.this.getPanelCartes().getPanelQuestion().getPanelButtons();
						panelButtonsQuestion.getJbAjouter().setVisible(true);
						panelButtonsQuestion.getjbSupprimer().setVisible(true);
						
						JOptionPane.showMessageDialog(null, "Login succesfull as Admin!", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			});
		}
		return jmiLogin;
	}

	
	/**
	 * Return the JMenuItem which can activate or deactivate sound
	 * @return JMenuItem son
	 */
	public JMenuItem getJmiSon() {
		if(jmiSon == null)
		{
			jmiSon = new JMenuItem("Activate /deactivate sound");
			   // Son activer
			jmiSon.addActionListener(new ActionListener(){

				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					if(isActiver() == true){
						setActiver(false);
						getSon().stop(); // on stoppe tout son
					}
					else
					{
						setActiver(true);
						setSon(new Audio("Music/Trivia.wav")); // Je recrée le son pour éviter un bug de thread
						getSon().start(); // on relance le son
					}
					
				}
				
			});
		}
		return jmiSon;
	}
	
	/**
	 * Return the JMenuItem to add a question
	 * @return JMenuItem add a question
	 */
	public JMenuItem getJmiAddQuestion()
	{
		if(jmiAddQuestion == null)
		{
			jmiAddQuestion = new JMenuItem("Add Question");
			jmiAddQuestion.setEnabled(false);
			jmiAddQuestion.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) 
				{
					Window.this.getPanelCartes().getCl().show(Window.this.getPanelCartes(),"AddQuestion");
					
				}
				
			});
		}
		return jmiAddQuestion;
	}


	/**
	 * Return the main JMenu
	 * @return JMenu file
	 */
	public JMenu getJmFichier()
	{
		if(jmFichier == null)
			jmFichier = new JMenu("File");
		return jmFichier;
	}

	/**
	 * Return the JMenu question
	 * @return JMenu question
	 */
	public JMenu getJmQuestion()
	{
		if(jmQuestion == null)
			jmQuestion = new JMenu("?");
		return jmQuestion;
	}

	/**
	 * Return the JMenuItem wich can close the application
	 * @return JMenuItem close
	 */
	public JMenuItem getJmiFermer() 
	{
		if(jmiFermer == null)
		{
			jmiFermer = new JMenuItem("Close");
			jmiFermer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0)
				{
					int reponse = JOptionPane.showConfirmDialog(Window.this,"Voulez-vous quitter l'application","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (reponse==JOptionPane.YES_OPTION) 
						System.exit(0);
				}
			});
		}
		return jmiFermer;
	}

	/**
	 * Return the JMenuBar
	 * @return JMenuBar
	 */
	private JMenuBar getJmBar()
	{
		if(jmBar == null)
			jmBar = new JMenuBar();
		return jmBar;
	}
	
	/**
	 * Return the game's sound
	 * @return the sound
	 */
	public Audio getSon() 
	{
		return son;
	}
	
	/**
	 * Change de sound of the game
	 * @param son
	 */
	public void setSon(Audio son) 
	{
		this.son = son;
	}

	/**
	 * Return the boolean wich can tell is the sound is activate
	 * @return true is sound works, false is sound doesn't work
	 */
	public boolean isActiver()
	{
		return activer;
	}

	/**
	 * Activate the sound
	 * @param activer
	 */
	public void setActiver(boolean activer) 
	{
		this.activer = activer;
	}



	
}


