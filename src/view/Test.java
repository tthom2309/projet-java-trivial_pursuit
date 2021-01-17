package view;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import utility.Audio;





//TODO ATTENTION bien penser qu'un admin n'est pas un joueur, risque de soucis quand on joue, @Thomas 

public class Test 
{

	public static void main(String[] args)
	{

	
		//Demarrage de l'application
		//setBestLookAndFeelAvailable();
		//new TestPlateau().setVisible(true);
		
		
		//Test de l'affichage d'une question
		
		new Window().setVisible(true);
		
		
		
		
		
		
	}
	
	
	
	public static void setBestLookAndFeelAvailable()
	{
		//permet d'adapter le composants en fonction de l'os du pc sur lequel le programme est lancé
		
		   String system_lf = UIManager.getSystemLookAndFeelClassName().toLowerCase();
		   if(system_lf.contains("metal")){
		       try {
		           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		       }catch (Exception e) {}
		   }else{
		       try {
		           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		       }catch (Exception e) {}
		   }
		 }
	
	

	
	
	
	


}

class fenetre extends JFrame
{
	private PanelCamembert jbStart = new PanelCamembert();
	

	
	
	public fenetre()
	{
		
		this.setTitle("Trivial Pursuit");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension taille = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int) taille.getWidth()/4, (int) taille.getWidth()/4);
		this.setMinimumSize(new Dimension(1300,800));
		this.setLocationRelativeTo(null);
		
	
        
        //le overlayLayout permet la superposition de composants (ajoutes l'un apres l'autre)
        jbStart.setPreferredSize(new Dimension(50,50));
        jbStart.setMaximumSize(new Dimension(50,50));
     
        this.add(jbStart);
  
    
		
	}
}


