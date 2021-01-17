package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CamembertGraphe;
import model.Category;
import model.Game;
import model.Piece;

 



class PanelCamembert extends JPanel
{
	
	private JLabel jlPoint;
	private JLabel jlCorrect;
	private JLabel jlWrong;
	
    /**
     * class of JPanel used to create a cheese 
     */
    public PanelCamembert()
    {     	
    	JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add(getJlPoint());
		panel.add(getJlCorrect());
		panel.add(getJlWrong());
		this.add(panel,BorderLayout.NORTH);
    }
    
    
    
    
    
    public JLabel getJlPoint() {
		if(jlPoint==null){
			jlPoint = new JLabel("Number of points: "+Piece.getInstance().getNbPoint());
		}
    	return jlPoint;
	}





	public JLabel getJlCorrect() {
		if(jlCorrect==null){
			jlCorrect = new JLabel("Number of correct answers: "+Piece.getInstance().getCorrectAnswer());
		}
		return jlCorrect;
	}





	public JLabel getJlWrong() {
		if(jlWrong==null){
			jlWrong = new JLabel("Number of wrong answers: "+Piece.getInstance().getWrongAnswer());
		}
		return jlWrong;
	}





	@Override 
    public void paintComponent(Graphics g) 
    {
    	    	
    	CamembertGraphe c[] = new CamembertGraphe[6];
    	
    	for(int i=0;i<6;i++)
    	{
    		c[i] = new CamembertGraphe(60f+i*60, Category.valueIndexOf(i).getColor());
    	}
    	
    	
    	super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        
        //lissage du texte et des dessins
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for(int i=0;i<6;i++)
        {
        	if(Piece.getInstance().getCheese(Category.valueIndexOf(i))){
        		g2.setColor(c[i].getColor());
        	}
        	else
        	{
        		g2.setColor(Color.GRAY);
        	}
        	g2.fill(c[i].getArc());
        	//pour les bords
        	g2.setColor(Color.BLACK);
        	g2.draw(c[i].getArc());
        
        }
 
        
    }
}
	

