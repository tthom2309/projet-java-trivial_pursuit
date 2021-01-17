package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.Dice;
import model.Game;
import model.Piece;

/**
 * This class shows the result of the roll of the dice
 * @author Thomas
 *
 */
public class PanelDice2 extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private JLabel jlLancerDeDes;
	private JButton jbValider;
	private int des;
	
	private PanelPlateau panelPlateau;
	private JpSouth panelSouth;
	private PanelCamembert panelCamembert;
	
	public PanelDice2()
	{
		
		//Panel composé du plateau + boutons + lancé de des
		
		this.setLayout(new BorderLayout());
		
		panelSouth = new JpSouth();
		
		// conteneur des des
		
		JPanel center = new JPanel();
		center.add(getJlLancerDeDes());
		center.add(getJbValider());
		
		JPanel gl = new JPanel();
		gl.setLayout(new GridLayout(1,3,1,100));
		
		gl.add(getPanelPlateau());
		gl.add(center);
		gl.add(getPanelCamembert());
		
//		this.add(center,BorderLayout.EAST);
//		this.add(getPanelPlateau(), BorderLayout.CENTER);
		
		this.add(gl,BorderLayout.CENTER);
		
		this.add(panelSouth,BorderLayout.SOUTH);		
	
	}
	
	
	
	
	public JPanel getPanelPlateau()
	{
		if(panelPlateau == null)
			panelPlateau = new PanelPlateau();
		return panelPlateau;
	}


	

	public JpSouth getPanelSouth() {
		if(panelSouth==null){
			panelSouth = new JpSouth();
		}
		return panelSouth;
	}




	public PanelCamembert getPanelCamembert() {
		if(panelCamembert==null){
			panelCamembert = new PanelCamembert();
		}
		return panelCamembert;
	}




	public JLabel getJlLancerDeDes() 
	{
		
		if(jlLancerDeDes==null)
		{
			String imgChemin = "Pictures/des"+getDes()+".jpg";
			ImageIcon img = new ImageIcon(imgChemin);
			jlLancerDeDes = new JLabel(img);
		}
		return jlLancerDeDes;
	}


	

	public JButton getJbValider() {
		if(jbValider==null){
			jbValider = new JButton("ok");
			jbValider.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Window fenetre  = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelDice2.this);
					fenetre.setContentPane(new PanelChoicePlateau());
					fenetre.repaint();
					fenetre.revalidate();
				}
			});
		}
		return jbValider;
	}






	public int getDes() {
		des = Dice.getInstance().getFace();
		return des;
	}


	
	
}
