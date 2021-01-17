package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.*;



/**
 * This class is the Main Menu of the application
 * @author Romain V
 *
 */
public class PanelStart extends JPanel
{
  
	private static final long serialVersionUID = 1L;
	private Dimension d;
	private CompoundButton jbStart;
	private CompoundButton jbClassement;
	private CompoundButton jbQuestions;
	private CompoundButton jbQuitter;
    
	
	/**
	 * This class contains the main panel of the game with a cardLayout
	 * @param d
	 */
    public PanelStart(Dimension d)
    {
    	this.setBackground(Color.WHITE);
    
    	JPanel container = new JPanel();
    	container.setBackground(Color.WHITE);
    	
    	JLabel jlImg = new JLabel(new ImageIcon("Pictures/logo.jpg"));
    	
    	// creation de notre panel contenant nos boutons
        this.d = d;
        
        container.setLayout(new OverlayLayout(container));
        
        //le overlayLayout permet la superposition de composants (ajoutes l'un apres l'autre)
        
        //add(new CompoundButton(d, ButtonLocation.CENTER));
        container.add(getJbStart());
        container.add(getJbRanking());
        container.add(getJbQuestions());
        container.add(getJbClose());
        
        this.add(jlImg, BorderLayout.NORTH);
        this.add(container,BorderLayout.CENTER);
        
        
        
    }
    
    @Override 
    public Dimension getPreferredSize() 
    {
        return d;
    }
    
    @Override 
    public boolean isOptimizedDrawingEnabled() 
    {
        return false;
    }
    
    
    /**
     * Return the JButton to start the game
     * @return JButton start
     */
    public JButton getJbStart() 
	{
		if(jbStart == null)
			jbStart = new CompoundButton(d, ButtonLocation.NORTH);
			jbStart.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					//Ici il faut verifier si un joueur n'est pas déjà connecté, si non proposer PanelJoueur si oui directement le PanelGame
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelStart.this);
					
					if(fenetre.getIsConnected())
					{
						Dimension taille = Toolkit.getDefaultToolkit().getScreenSize();
						fenetre.setSize((int)(taille.getWidth()), (int)(taille.getWidth()));
						fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(), "Game");
					
					
					}
					else		
					{
						fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(),"Joueur");
					}
				}
				
			});
		return jbStart;
	}


    /**
     * Return the JButton to show the ranking
     * @return JButton ranking
     */
	public JButton getJbRanking()
	{
		if(jbClassement == null)
		{
			jbClassement = new CompoundButton(d, ButtonLocation.EAST);
			jbClassement.addActionListener(new ActionListener()
			{

				public void actionPerformed(ActionEvent arg0)
				{
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelStart.this);
					fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(),"Classement");
				}
				
			});
		}
		return jbClassement;
	}

	/**
	 * Return the JButton question
	 * @return 
	 */
	public JButton getJbQuestions() 
	{
		if(jbQuestions == null)
			jbQuestions = new CompoundButton(d, ButtonLocation.WEST);
			jbQuestions.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) {
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelStart.this);
					fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(),"Question");
				}
				
			});
		return jbQuestions;
	}


	/**
	 * Return the JButton to close application
	 * @return JButton close
	 */
	public JButton getJbClose()
	{
		if(jbQuitter == null)
		{
			jbQuitter = new CompoundButton(d, ButtonLocation.SOUTH);
			jbQuitter.addActionListener(new ActionListener()
			{

				public void actionPerformed(ActionEvent arg0)
				{
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelStart.this);
					int reponse = JOptionPane.showConfirmDialog(fenetre,"Do you want to exit?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (reponse==JOptionPane.YES_OPTION){
						
						System.exit(0);
					}
						
					
				}
				
			});
		}
		return jbQuitter;
	}
	
}

enum ButtonLocation 
{
	CENTER(0f),
    NORTH(45f),
    EAST(135f),
    SOUTH(225f),
    WEST(-45f);
    
    private final float degree;
    
    private ButtonLocation(float degree)
    {
        this.degree = degree;
    }
    
    public float getStartDegree() 
    {
        return degree;
    }
   
}

class CompoundButton extends JButton
{
    
	private static final long serialVersionUID = 1L;
    private Color cliqueColor = new Color(255,102,0); // couleur de clique, orange des sports
    private Color mouseColor = Color.WHITE; //couleur curseur sur le boutton
    private Shape shape; // un objet shape est une forme complexe
    private Shape base;
    private ButtonLocation bl; //locatlisation du bouton
    private Dimension dim; // dimension du bouton
    
    /** 
     * This class allows to create the main buttons group
     * @param the dimension of a button
     * @param the button location in the panel
     */
    public CompoundButton(Dimension d, final ButtonLocation bl) 
    {
    	//creation de nos composants avec forme et couleur
        
    	
    	//on definit la position ainsi que la dimension
        this.dim = d;
        this.bl = bl;
       
        
        
        //changement de l'icone du boutton
        setIcon(new Icon() {
        	
            @Override 
            public void paintIcon(Component c, Graphics g, int x, int y)
            
            {
                Graphics2D g2 = (Graphics2D) g.create();
                //lissage du texte et des dessins
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                if (getModel().isArmed()) // avant de relacher le clique
                {
                    g2.setColor(cliqueColor);
                    g2.fill(shape);
                    
                } else if (isRolloverEnabled() && getModel().isRollover()) // souris sur le bouton
                {
                    paintFocusAndRollover(g2, mouseColor);
                    
                    
                }
                else 
                {
                	// on definit les couleurs de chaqu'un des boutons
                	if(bl == ButtonLocation.NORTH)
                	{
                		g2.setColor(new Color(52,153,51)); //vert des sciences
                	}
                	else if(bl == ButtonLocation.SOUTH)
                	{
                		g2.setColor(new Color(0,153,203)); //orange de la geo
                	}
                	else if(bl == ButtonLocation.WEST)
                	{
                		g2.setColor(new Color(153,101,51));// Jaune de l'histoire
                	}
                		
                	else
                		g2.setColor(new Color(255,51,102)); //rose entertenainment
                	
                	
                	
                    g2.fill(shape);
                }
                g2.setColor(Color.BLACK);
                g2.drawString("Ranking", 70, 200);
                g2.drawString("Exit", 190, 300);
                g2.drawString("Questions", 290, 200);
                g2.drawString("Start", 190, 100);
                g2.dispose();
                
            }
            
            @Override 
            public int getIconWidth() 
            {
                return dim.width;
            }
            @Override 
            public int getIconHeight()
            {
                return dim.height;
            }
        });
        
        this.setFocusPainted(false); 
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
      
        // on initialise la forme elliptique
        initShape();
        
      
        
		
		
    }
    
    @Override 
    public Dimension getPreferredSize()
    {
        return dim;
    }
    
    
    /**
     * This methode initialise the shape
     */
    private void initShape()
    {
        if (!this.getBounds().equals(base))
        {
            base = getBounds();
            
                
             Shape outer = new Arc2D.Float(1, 1, getWidth() - 2, getHeight() - 2, bl.getStartDegree(), 90f, Arc2D.PIE);
             Area area = new Area(outer);
             shape = area;
            
        }
    }
    
    
    
    private void paintFocusAndRollover(Graphics2D g2, Color color) 
    {
        g2.setPaint(new GradientPaint(0, 0, color, getWidth() - 1, getHeight() - 1, color.brighter(), true));  
        g2.fill(shape);
        g2.setColor(getBackground());
   
    }
    
    
    @Override 
    public void paintComponent(Graphics g) 
    {
        initShape();
        super.paintComponent(g);
        
    }
    
    
    @Override 
    protected void paintBorder(Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.draw(shape);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
        g2.dispose();
    }
    
    
    @Override 
    public boolean contains(int x, int y) 
    {
 
        return shape == null ? false : shape.contains(x, y);
    }
}