package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



import model.Category;
import model.Game;
import model.Piece;

/**
 * This class permit to throw the dice
 * @author Thomas
 *
 */
public class PanelDice extends JPanel{
	
	private JButton jbLancerDes;


	private PanelPlateau panelPlateau;
	private JpSouth jpSouth;
	private PanelCamembert panelCamembert;

	public PanelDice()
	{
		//Panel composé du plateau + boutons + lancé de des
	
		this.setLayout(new BorderLayout());
		
		
		
		//Panel center contient le lancé de des
		Dimension dim = new Dimension(200,50);
		JPanel center = new JPanel();
		center.add(getJbLancerDes());
		center.setPreferredSize(dim);
		
		JPanel gl = new JPanel();
		gl.setLayout(new GridLayout(1,3,1,100));
		
		
		gl.add(getPanelPlateau());
		gl.add(center);
		gl.add(getPanelCamembert());
		
//		this.add(center,BorderLayout.NORTH);
//		this.add(getPanelPlateau(), BorderLayout.CENTER);
//		this.add(getPanelCamembert(),BorderLayout.CENTER);

		this.add(gl,BorderLayout.CENTER);		
				
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
		if(panelPlateau == null){
			panelPlateau = new PanelPlateau();
			Dimension dim = new Dimension(500,500);
			panelPlateau.setPreferredSize(dim);
		}
		return panelPlateau;
	}
	
	
	public JButton getJbLancerDes()
	{
		if(jbLancerDes==null){
			jbLancerDes = new JButton("Clic to throw the dice.");
			jbLancerDes.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					//TODO 
					
					Window fenetre  = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelDice.this);
					int des = Game.getInstance().getDice().rollDice();
					fenetre.setContentPane(new PanelDice2());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbLancerDes;
	}



	

}


/**
 * This class show the button on the south of the window during the game
 * @author Thomas
 *
 */
class JpSouth extends JPanel
{
	private JButton jbMainMenu;
	private JButton jbQuit;
	private JButton jbAddFiveCheeses;
	
	
	public JpSouth()
	{
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setBackground(Color.WHITE);
		this.add(getJbAddFiveCheeses());
		this.add(getJbMainMenu());
		this.add(getJbQuit());
	}
	
	
	
	public JButton getJbAddFiveCheeses() {
		if(jbAddFiveCheeses == null){
			jbAddFiveCheeses = new JButton("Test Demo");
			jbAddFiveCheeses.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Piece.getInstance().addCheese(Category.GEOGRAPHY);
					Piece.getInstance().addCheese(Category.BUSINESS);
					Piece.getInstance().addCheese(Category.HISTORY);
					Piece.getInstance().addCheese(Category.SCIENCE_NATURE);
					Piece.getInstance().addCheese(Category.ENTERTAINMENT);
					Window fenetre  = (Window)SwingUtilities.getAncestorOfClass(Window.class,JpSouth.this);
					fenetre.setContentPane(new PanelDice());
					fenetre.repaint();
					fenetre.revalidate();
					
				}
			});
		}
		return jbAddFiveCheeses;
	}

	

	public JButton getJbMainMenu()
	{
		if(jbMainMenu==null){
			jbMainMenu = new JButton("Main menu");
			jbMainMenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class, JpSouth.this);
					int reponse = JOptionPane.showConfirmDialog(fenetre,"Do you want to quit the current game?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					if (reponse==0)
					{
						Game.resetInstance();
						Piece.resetInstance();
						Game.getInstance();
						Piece.getInstance();
						fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(), "Start");
						fenetre.repaint();
						fenetre.revalidate();
					}
				}
			});
		}
		return jbMainMenu;
	}

	public JButton getJbQuit() 
	{
		if(jbQuit==null){
			jbQuit = new JButton("Exit");
			jbQuit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					
					int reponse = JOptionPane.showConfirmDialog(JpSouth.this,"Do you want to exit?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (reponse==JOptionPane.YES_OPTION) 
						System.exit(0);
				}
			});
		}
		return jbQuit;
	}
}





