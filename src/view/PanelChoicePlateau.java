package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Category;
import model.Dice;
import model.Game;
import model.Piece;
import model.Play;
import model.Question;
import model.SquareQuestionCheese;
import model.Stack;

/**
 * This Class show and allows to choice the next square for the player
 * @author Thomas
 *
 */
public class PanelChoicePlateau extends JPanel
{
	
	private JButton jbchoice1;
	private JButton jbchoice2;
	private JButton jbchoice3;
	private JButton jbchoice4;
	private JButton jbchoice5;
	private JButton jbchoice6;
	private JButton jbchoice7;

	
	private PlateauChoice plateauChoice;
	private JPanel jpSouth;
	private PanelCamembert panelCamembert;
	
	public PanelChoicePlateau()
	{
		
		//liste des choix possible
		List<Integer>choix = new ArrayList<Integer>();
		choix = Play.getListDeplacement(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()),Dice.getInstance().getFace());
		
		Dimension dim = new Dimension(200,500);
		JPanel center= new JPanel();
		center.setLayout(new GridLayout(7,1,1,15));
		
		//création des boutons des choix de déplacement de 2 à 7 boutons
		int j=1;
		for(int i=0;i<choix.size();i++){
			if(i==0){
				
				center.add(getJbchoice1(choix.get(i),j));
				j++;
			}
			if(i==1){
				center.add(getJbchoice2(choix.get(i),j));
				j++;
			}
			if(i==2){
				center.add(getJbchoice3(choix.get(i),j));
				j++;
			}
			if(i==3){
				center.add(getJbchoice4(choix.get(i),j));
				j++;
			}
			if(i==4){
				center.add(getJbchoice5(choix.get(i),j));
				j++;
			}
			if(i==5){
				center.add(getJbchoice6(choix.get(i),j));
				j++;
			}
			if(i==6){
				center.add(getJbchoice7(choix.get(i),j));
				j++;
			}
		}
		center.setPreferredSize(dim);
		
		
		
		JPanel panelLayout = new JPanel();
		panelLayout.setLayout(new GridLayout(1,3,5,100));
		panelLayout.add(getPlateauChoice());
		panelLayout.add(center);
		panelLayout.add(getPanelCamembert());
		
		this.setLayout(new BorderLayout());
		this.add(panelLayout,BorderLayout.CENTER);
		this.add(getJpSouth(),BorderLayout.SOUTH);
	}
	
	
	public JPanel getJpSouth()
	{
		if(jpSouth == null)
			jpSouth = new JpSouth();
		return jpSouth;
	}
	
	
	public PlateauChoice getPlateauChoice() 
	{
		if(plateauChoice == null)
			plateauChoice = new PlateauChoice();
		return plateauChoice;
	}
	
	
	public PanelCamembert getPanelCamembert() {
		if(panelCamembert==null){
			panelCamembert = new PanelCamembert();
		}
		return panelCamembert;
	}


	public JButton getJbchoice1( final int ind, int j) {
		jbchoice1 = null;
		if(ind==8 || ind==11 || ind==20 || ind==23 || ind==32 || ind==35 || ind==44 || ind==47 || ind==56 || ind==59 || ind==68 || ind==71){
			jbchoice1 = new JButton(j+" Throw dice square");
			jbchoice1.setBackground(Color.WHITE);
			jbchoice1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		else
		{
			if(Game.getInstance().getGameBoard().getSquare(ind) instanceof SquareQuestionCheese)
				jbchoice1 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString()+ " (cheese)");
			else
				jbchoice1 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString());
			
			jbchoice1.setBackground(Game.getInstance().getGameBoard().getSquare(ind).getCategorie().getColor());
			jbchoice1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					//Question question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelQuestionView());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbchoice1;
	}

	

	public JButton getJbchoice2(final int ind, int j) {
		jbchoice2 = null;
		if(ind==8 || ind==11 || ind==20 || ind==23 || ind==32 || ind==35 || ind==44 || ind==47 || ind==56 || ind==59 || ind==68 || ind==71){
			jbchoice2 = new JButton(j+" Throw dice square");
			jbchoice2.setBackground(Color.WHITE);
			jbchoice2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
		
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		else
		{
			if(Game.getInstance().getGameBoard().getSquare(ind) instanceof SquareQuestionCheese)
				jbchoice2 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString() + " (cheese)");
			else
				jbchoice2 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString());
			jbchoice2.setBackground(Game.getInstance().getGameBoard().getSquare(ind).getCategorie().getColor());
			jbchoice2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Question question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelQuestionView());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbchoice2;
	}



	public JButton getJbchoice3(final int ind, int j) {
		jbchoice3 = null;
		if(ind==8 || ind==11 || ind==20 || ind==23 || ind==32 || ind==35 || ind==44 || ind==47 || ind==56 || ind==59 || ind==68 || ind==71){
			jbchoice3 = new JButton(j+" Throw dice square");
			jbchoice3.setBackground(Color.WHITE);
			jbchoice3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		else
		{
			if(Game.getInstance().getGameBoard().getSquare(ind) instanceof SquareQuestionCheese)
				jbchoice3 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString() + " (cheese)");
			else
				jbchoice3 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString());
			
			jbchoice3.setBackground(Game.getInstance().getGameBoard().getSquare(ind).getCategorie().getColor());
			jbchoice3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					//Question question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelQuestionView());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbchoice3;
	}



	public JButton getJbchoice4(final int ind,int j) {
		jbchoice4 = null;
		if(ind==8 || ind==11 || ind==20 || ind==23 || ind==32 || ind==35 || ind==44 || ind==47 || ind==56 || ind==59 || ind==68 || ind==71){
			jbchoice4 = new JButton(j+" Throw dice square");
			jbchoice4.setBackground(Color.WHITE);
			jbchoice4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		else
		{
			if(Game.getInstance().getGameBoard().getSquare(ind) instanceof SquareQuestionCheese)
				jbchoice4 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString() + " (cheese)");
			else
				jbchoice4 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString());
			jbchoice4.setBackground(Game.getInstance().getGameBoard().getSquare(ind).getCategorie().getColor());
			jbchoice4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Question question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelQuestionView());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbchoice4;
	}



	public JButton getJbchoice5(final int ind, int j) {
		jbchoice5 = null;
		if(ind==8 || ind==11 || ind==20 || ind==23 || ind==32 || ind==35 || ind==44 || ind==47 || ind==56 || ind==59 || ind==68 || ind==71){
			jbchoice5 = new JButton(j+" Throw dice square");
			jbchoice5.setBackground(Color.WHITE);
			jbchoice5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		else
		{
			if(Game.getInstance().getGameBoard().getSquare(ind) instanceof SquareQuestionCheese)
				jbchoice5 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString() + " (cheese)");
			else
				jbchoice5 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString());
			jbchoice5.setBackground(Game.getInstance().getGameBoard().getSquare(ind).getCategorie().getColor());
			jbchoice5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
				Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
				Question question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
				Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
				fenetre.setContentPane(new PanelQuestionView());
				fenetre.repaint();
				fenetre.revalidate();
			}
		});
		}
		return jbchoice5;
	}


	public JButton getJbchoice6(final int ind,int j) {
		jbchoice6 = null;
		if(ind==8 || ind==11 || ind==20 || ind==23 || ind==32 || ind==35 || ind==44 || ind==47 || ind==56 || ind==59 || ind==68 || ind==71){
			jbchoice6 = new JButton(j+" Throw dice square");
			jbchoice6.setBackground(Color.WHITE);
			jbchoice6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		else
		{
			if(Game.getInstance().getGameBoard().getSquare(ind) instanceof SquareQuestionCheese)
				jbchoice6 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString() + " (cheese)");
			else
				jbchoice6 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString());
			jbchoice6.setBackground(Game.getInstance().getGameBoard().getSquare(ind).getCategorie().getColor());
			jbchoice6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Question question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelQuestionView());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbchoice6;
	}


	public JButton getJbchoice7(final int ind, int j) {
		jbchoice7 = null;
		if(ind==8 || ind==11 || ind==20 || ind==23 || ind==32 || ind==35 || ind==44 || ind==47 || ind==56 || ind==59 || ind==68 || ind==71){
			jbchoice7 = new JButton(j+" Throw dice square");
			jbchoice7.setBackground(Color.WHITE);
			jbchoice7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		else
		{
			if(Game.getInstance().getGameBoard().getSquare(ind) instanceof SquareQuestionCheese)
				jbchoice7 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString() + " (cheese)");
			else
				jbchoice7 = new JButton(j+" "+Game.getInstance().getGameBoard().getSquare(ind).getCategorie().toString());
			jbchoice7.setBackground(Game.getInstance().getGameBoard().getSquare(ind).getCategorie().getColor());
			jbchoice7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).removePiece(Piece.getInstance());
					Game.getInstance().getGameBoard().getSquare(ind).addPiece(Piece.getInstance());
					Question question = Stack.getInstance().getRandomQuestionByCat(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()).getCategorie());
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelChoicePlateau.this);
					fenetre.setContentPane(new PanelQuestionView());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbchoice7;
	}
	
}

/**
 * This class show a board game with the choice of travel 
 * @author Thomas
 *
 */
class PlateauChoice extends JPanel
{
	public PlateauChoice()
	{

	}
	
	public void paintComponent(Graphics g){
		//nettoie le contenu de la fenêtre pour éviter des traces des précédents paint
		//g.clearRect(0, 0, getWidth(), getHeight());
		
		//correspond aux coordonnées x de toutes les cases du plateau
		int x[][]= CoordonneePlateau.getPlateauX();
		
		
		//correspond aux coordonnées y de toutes les cases du plateau
		int y[][]= CoordonneePlateau.getPlateauY();
		
		//correpond aux coordonnées x des formes dans la case centrale
		int caseDepx[][]= CoordonneePlateau.getCaseDepX();
		
		//correpond aux coordonnées y des formes dans la case centrale
		int caseDepy[][]= CoordonneePlateau.getCaseDepY();
		
		//correspond aux coordonnées x des curseurs
		int curseurX[][]= CoordonneePlateau.getCurseurX();
		
		//correspond aux coordonnées y des curseurs
		int curseurY[][]= CoordonneePlateau.getCurseurY();
		
		//variable compteur utilisé pour la sélection des catégories des cases camemberts
		int j=1;
		
		//dessine la case centrale		
		//dessine les formes à l'intérieur de la case centrale
		for(int i=0;i<6;i++){
			for(Category c:Category.values()){
				if(i+1==c.getId()){
					g.setColor(c.getColor());
				}
			}    
			g.fillPolygon(caseDepx[i],caseDepy[i],3);
			g.setColor(Color.BLACK);
			g.drawPolygon(caseDepx[i],caseDepy[i],3);
		}
		
		//dessine les 72 cases du plateau
		for(int i=1;i<=72;i++){
			//dessine les cases camembert du plateau
			if(i==6 || i==18 || i==30 || i==42 || i==54 || i==66){
					for(Category c:Category.values()){
						if(j==c.getId()){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],5);
						}
					}    
				g.setColor(Color.BLACK);
				g.drawPolygon(x[i],y[i],5);
				j++;
			}
			else{	
				//couleur blanche pour les cases rejoués
				if(i==8 || i==11 || i==20 || i==23 || i==32 || i==35 || i==44 || i==47 || i==56 || i==59 || i==68 || i==71){
					g.setColor(Color.WHITE);
					g.fillPolygon(x[i],y[i],4);
				}
				//couleur case Geography
				if(i==13 || i==22 || i==28 || i==36 || i==41 || i==43 || i==51 || i==57 || i==62){
					for(Category c:Category.values()){
						if(c.getId()==1){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Entertainement
				if(i==2 || i==25 || i==34 || i==40 || i==48 || i==53 || i==55 || i==63 || i==69){
					for(Category c:Category.values()){
						if(c.getId()==2){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case History
				if(i==3 || i==9 || i==14 || i==37 || i==46 || i==52 || i==60 || i==65 || i==67){
					for(Category c:Category.values()){
						if(c.getId()==3){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Business
				if(i==5 || i==7 || i==15 || i==21 || i==26 || i==49 || i==58 || i==64 || i==72){
					for(Category c:Category.values()){
						if(c.getId()==4){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Science Nature
				if(i==4 || i==12 || i==17 || i==19 || i==27 || i==33 || i==38 || i==61 || i==70){
					for(Category c:Category.values()){
						if(c.getId()==5){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				//couleur case Sport Leisure
				if(i==1 || i==10 || i==16 || i==24 || i==29 || i==31 || i==39 || i==45 || i==50 ){
					for(Category c:Category.values()){
						if(c.getId()==6){
							g.setColor(c.getColor());
							g.fillPolygon(x[i],y[i],4);
						}
					}
				}
				g.setColor(Color.BLACK);
				g.drawPolygon(x[i],y[i],4);
				
				
				
				// id représente l'id de la case où se situe le joueur
				int id = Game.getInstance().getGameBoard().getIdSquareContainsPiece(Piece.getInstance());
				g.setColor(Color.GREEN);
				g.fillPolygon(curseurX[id], curseurY[id], 3);
				g.setColor(Color.BLACK);
				g.drawPolygon(curseurX[id],curseurY[id],3);
				
				//liste des choix possible
				List<Integer>choix = new ArrayList<Integer>();
				int k =1;
				choix = Play.getListDeplacement(Game.getInstance().getGameBoard().getSquareContainsPiece(Piece.getInstance()),Dice.getInstance().getFace());
				for(Integer in: choix){
					g.setColor(Color.ORANGE.brighter().brighter());
					g.fillPolygon(curseurX[in], curseurY[in], 3);
					g.setColor(Color.BLACK);
					g.drawString(k+"", curseurX[in][0]-3, curseurY[in][0]-15);
					g.setColor(Color.BLACK);
					g.drawPolygon(curseurX[in],curseurY[in],3);
					k++;
				}
			}
		}
	}
}
