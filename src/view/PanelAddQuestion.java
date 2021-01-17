package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import utility.Serialisation;
import model.Category;
import model.Question;
import model.Stack;

/**
 * This class contains three JPanel to allow to add some questions
 * @author Romain V
 *
 */
public class PanelAddQuestion extends JPanel 
{
	
	
	private static final long serialVersionUID = 1L;
	private JTextField jtStatement;
	private PanelNorth panelNord;
	private PanelSouth panelSud;
	private PanelCenter panelCentre;
	
	
	/**
	 * Constructs a JPanel which contains a form to enter and save some questions
	 * 
	 */
	public PanelAddQuestion()
	{
		panelNord = new PanelNorth();
		panelSud = new PanelSouth();
		panelCentre = new PanelCenter();
		
	
		this.setLayout(new BorderLayout());
		this.add(getPanelNord(), BorderLayout.NORTH);
		this.add(getPanelCentre(),BorderLayout.CENTER);
		this.add(getPanelSud(), BorderLayout.SOUTH);
		this.setBackground(Color.WHITE);
		
	
		
	}
	
	
	/**
	 * Returns the form's North JPanel
	 * @return the north panel
	 */
	public PanelNorth getPanelNord()
	{
		if(panelNord == null)
		{
			panelNord = new PanelNorth();
		}
		return panelNord;
	}

	
	/**
	 * Returns the form's South JPanel
	 * @return the south panel
	 */
	public PanelSouth getPanelSud() 
	{
		if(panelSud == null)
		{
			panelSud = new PanelSouth();
		}
		return panelSud;
	}

	/**
	 * Returns the form's Center JPanel
	 * @return the center panel
	 */
	public PanelCenter getPanelCentre() 
	{
		if(panelCentre==null)
		{
			panelCentre = new PanelCenter();
		}
		return panelCentre;
	}
	
	/**
	 * Returns the JtextField of the question's statement
	 * @return the statement
	 */
	public JTextField getJtStatement()
	{
		if(jtStatement == null)
		{
			jtStatement = new JTextField();
			jtStatement.setPreferredSize(new Dimension(200,20));
		}
		return jtStatement;
	}


	
	class PanelNorth extends JPanel
	{
		private JComboBox combo;
		private JLabel jlQuestion, jlCategory;

		/**
		 * Constructs the north panel wich contains a combobox and two JLabel
		 */
		public PanelNorth()
		{

			this.setBackground(Color.WHITE);
			
			jlQuestion = new JLabel("Statement : ");
			jlCategory = new JLabel("Category : ");

			this.add(jlQuestion);	
			this.add(getJtStatement());
			this.add(jlCategory);
			this.add(getCombo());


		}

		/**
		 * Returns the combobox
		 * @return the combobox
		 */
		public JComboBox getCombo() 
		{
			if(combo == null)
			{
				// Rajout des categories dans la combobox peu importe le nombre
				Category[] tab = Category.values();
				String[] categorie = new String[tab.length];
				for (int i = 0 ; i < tab.length  ; i++)
				{
				  Category type = tab[i];
				  categorie[i] = type.toString();
				}
					
				combo = new JComboBox(categorie);
			}
			return combo;
		}

		
	}
	



	class PanelSouth extends JPanel
	{
		private JButton menu, sauvegarder ,retour;

		/**
		 * Constructs the first part of the PanelQuestion, it contains the Jbuttons
		 */
		public PanelSouth()
		{
			menu = new JButton("Main Menu");
			sauvegarder = new JButton("Save");
			retour = new JButton("Back");
			this.setLayout(new FlowLayout(FlowLayout.RIGHT));
			this.setBackground(Color.WHITE);

			menu.addActionListener(new ActionListener()
			{

				public void actionPerformed(ActionEvent e) 
				{
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelAddQuestion.this);
					fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(),"Start");
				} 
				
			}); 
			sauvegarder.addActionListener(new ActionListener()
			{

				public void actionPerformed(ActionEvent e)
				{
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelAddQuestion.this);
					PanelAddQuestion panQ = (PanelAddQuestion)SwingUtilities.getAncestorOfClass(PanelAddQuestion.class,PanelSouth.this);
					PanelNorth panN = panQ.getPanelNord();
					PanelCenter panC = panQ.getPanelCentre();
					
					
					//TODO exception si des champs sont vides
					// Obtenir la question
					String statement = PanelAddQuestion.this.getJtStatement().getText();
					
					// Obtenir l'auteur
					String author = "Moi"; //TODO Quoi faire pour l'auteur? Recuperer login et activer le add question que quand on est loggé?
					
					//Obtenir la categorie
					Category category = Category.valueIndexOf(panN.getCombo().getSelectedIndex());
					
					
				
					
					//creation de la question
					Question maQuestion = new Question(author, statement, category);
					for(int i=0; i<4;i++)
					{
						//On parcourt le tableau des 4choix de reponses associés à leur boolean respectif
						
						maQuestion.addChoice(panC.getJtEnterTab()[i].getText(), panC.getResultTab()[i]);
					}
					
					//Rajout de la question au stack
					Stack stack = Stack.getInstance();  //TODO .retrieveStack("groupe07.json");  
					stack.addQuestion(maQuestion);
					
					//sauvegarde du stack
					Serialisation.saveStack("Data/question.json", stack);
					
					
					//TODO le tableau ne s'actualise pas quand on clique sur retour
					
					
					
				}
				
			});
			retour.addActionListener(new ActionListener(){

				
				public void actionPerformed(ActionEvent arg0)
				{
					Window fp = (Window) SwingUtilities.getAncestorOfClass(Window.class, PanelAddQuestion.this);
					fp.getPanelCartes().getCl().show(fp.getPanelCartes(),"Question");
					
				}
				
			});


			this.add(menu);
			this.add(sauvegarder);
			this.add(retour);

		}
	}
	
	//boutons du panel sud, annuler et sauvegarder


	class PanelCenter extends JPanel
	{
		private JLabel jlChoice, jlChoice2, jlChoice3, jlChoice4;
		private JTextField jtEnter, jtEnter2, jtEnter3, jtEnter4;
		private JRadioButton choixT,  choixT2,  choixT3,  choixT4;
	
		private ButtonGroup groupe;
		
		/**
		 * Constructs the second part of the PanelQuestion, it contains choices and JRadioButtons
		 */
		public PanelCenter()
		{
			this.setBackground(Color.WHITE);
			
			choixT = new JRadioButton("Reponse 1",false);
			choixT2 = new JRadioButton("Reponse 2",false);
			choixT3 = new JRadioButton("Reponse 3",false);
			choixT4 = new JRadioButton("Reponse 4",false);
			
			groupe = new ButtonGroup();
			groupe.add(choixT);
			groupe.add(choixT2);
			groupe.add(choixT3);
			groupe.add(choixT4);
			
			jtEnter = new JTextField(5);
			jtEnter2 = new JTextField(5);
			jtEnter3 = new JTextField(5);
			jtEnter4 = new JTextField(5);


			jlChoice = new JLabel("Choice : ");
			jlChoice2 = new JLabel("Choice : ");
			jlChoice3 = new JLabel("Choice : ");
			jlChoice4 = new JLabel("Choice : ");


			GroupLayout g1 = new GroupLayout(this);
			this.setLayout(g1);
			g1.setAutoCreateContainerGaps(true);
			g1.setAutoCreateGaps(true);

			g1.setHorizontalGroup(g1
					.createSequentialGroup()
					.addGroup(g1.createParallelGroup()
							.addComponent(jlChoice)
							.addComponent(jlChoice2)
							.addComponent(jlChoice3)
							.addComponent(jlChoice4))
						.addGroup(g1.createParallelGroup()
							.addComponent(jtEnter, 0, GroupLayout.DEFAULT_SIZE,500)
							.addComponent(jtEnter2,0, GroupLayout.DEFAULT_SIZE,500)
							.addComponent(jtEnter3,0, GroupLayout.DEFAULT_SIZE,500)
							.addComponent(jtEnter4,0, GroupLayout.DEFAULT_SIZE,500))
						.addGroup(g1.createParallelGroup()
								.addComponent(choixT)
								.addComponent(choixT2)
								.addComponent(choixT3)
								.addComponent(choixT4))
				);



			g1.setVerticalGroup(g1
					.createSequentialGroup()
					.addGroup(g1.createParallelGroup()
							.addComponent(jlChoice)
							.addComponent(jtEnter,0, GroupLayout.DEFAULT_SIZE,25)
							.addComponent(choixT)
							)
					.addGroup(g1.createParallelGroup()
							.addComponent(jlChoice2)
							.addComponent(jtEnter2,0, GroupLayout.DEFAULT_SIZE,25)
							.addComponent(choixT2)
							)
					.addGroup(g1.createParallelGroup()
							.addComponent(jlChoice3)
							.addComponent(jtEnter3,0, GroupLayout.DEFAULT_SIZE,25)				
							.addComponent(choixT3)
							)
					.addGroup(g1.createParallelGroup()
							.addComponent(jlChoice4)
							.addComponent(jtEnter4,0, GroupLayout.DEFAULT_SIZE,25)
							.addComponent(choixT4))
							);



		}
		
		public JRadioButton getChoixT3()
		{
			return choixT3;
		}
	
		public JTextField getJtEnter() 
		{
			return jtEnter;
		}
		public JTextField getJtEnter2()
		{
			return jtEnter2;
		}
		public JTextField getJtEnter3() 
		{
			return jtEnter3;
		}
		public JTextField getJtEnter4()
		{
			return jtEnter4;
		}
		
		/**
		 * Renvoie le tableau des valeurs des booleans
		 * 
		 * @return
		 */
		public boolean[] getResultTab()
		{
			boolean[] resultTab = new boolean[4];
			resultTab[0] = choixT.isSelected();
			resultTab[1] = choixT2.isSelected();
			resultTab[2] = choixT3.isSelected();
			resultTab[3] = choixT4.isSelected();
			
			return resultTab;
			
			
		}
		/** Renvoie le tableau des jt
		 * 
		 * @return
		 */
		public JTextField[] getJtEnterTab()
		{
			JTextField[] jtEnterTab = new JTextField[4];
			jtEnterTab[0] = jtEnter;
			jtEnterTab[1] = jtEnter2;
			jtEnterTab[2] = jtEnter3;
			jtEnterTab[3] = jtEnter4;
			
			return jtEnterTab;
		}
	}

}


