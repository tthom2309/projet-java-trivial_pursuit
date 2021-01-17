package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.SwingUtilities;


/**
 * This class allows to display information about a ranking by total of points and total of victories.
 * @author Christophe Decroos
 *
 */
class PanelNorth extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JLabel jlTypeRanking;
	private JComboBox<String> jcTypeRanking;
	
	public PanelNorth()
	{
		this.setLayout(new GridLayout(1,4,10,0));
		this.add(getJlTypeRanking());
		this.add(getJcTypeRanking());
	}
	
	public JLabel getJlTypeRanking() 
	{
		if(jlTypeRanking==null)
			jlTypeRanking = new JLabel("Type of ranking");
		return jlTypeRanking;
	}
	
	public JComboBox<String> getJcTypeRanking()
	{
		if(jcTypeRanking==null){
			String[] content = {"Ranking point","Ranking victory"};
			jcTypeRanking = new JComboBox<String>(content);
			
			jcTypeRanking.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					PanelRanking panelC = (PanelRanking) SwingUtilities.getAncestorOfClass(PanelRanking.class, PanelNorth.this);
	
					String selection = (String) panelC.getPanelNorth().getJcTypeRanking().getSelectedItem();
					// On reprend la valeur de la JComboBox.
					if(selection.equals("Ranking point")){// Si c'est la valeur "Ranking point de la JComboBox qui est sélectionnée
						panelC.getPanelCenter().getCard().show(panelC.getPanelCenter(), "jtableRankingPoint"); 
						// On montre la JCombobox créée avec la class ModelTableAdapterRankingPoint
					}
					else if(selection.equals("Ranking victory")){//Si c'est la valeur "Ranking victory de la JComboBox qui est sélectionnée
						panelC.getPanelCenter().getCard().show(panelC.getPanelCenter(), "jtableRankingVic");
						// On montre la JCombobox créée avec la class ModelTableAdapterRankingPoint
					}	
				}
			});
		}
		return jcTypeRanking;
	}	
	
}

class PanelCenter extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JTable jtableRankingPoint,jtableRankingVic;
	private CardLayout card;
	
	public PanelCenter()
	{
		this.setLayout(getCard());
		this.add(new JScrollPane(getJtableRankingPoint()),"jtableRankingPoint");
		this.add(new JScrollPane(getJtableRankingVic()),"jtableRankingVic");
		// Le PanelCenter contient un cardLayout, ce qui permet de passer d'une JTable à une autre.
		// Les JTable sont dans des JScrollPane
	}

	public JTable getJtableRankingPoint() 
	{
		if(jtableRankingPoint==null)
		{
			jtableRankingPoint = new JTable(new ModelTable<ModelTableAdapter>(new ModelTableAdapterRankingPoint()));
			// On créé la JTable sur base de la classe "ModelTableAdapterRankingPoint"
			jtableRankingPoint.setAutoCreateRowSorter(true);// Permet de trier les colonnes de la JTable.
		}
		return jtableRankingPoint;
	}

	public JTable getJtableRankingVic() 
	{
		if(jtableRankingVic == null)
		{
			jtableRankingVic = new JTable(new ModelTable<ModelTableAdapter>(new ModelTableAdapterRankingVictory()));
			jtableRankingVic.setAutoCreateRowSorter(true);// Voir la méthode d'au dessus.
		}
		return jtableRankingVic;
	}
	
	public CardLayout getCard() 
	{
		if(card==null)
		{
			card = new CardLayout();
		}
		return card;
	}
	
}

class PanelSouth extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JButton jbWelcome;
	
	public PanelSouth()
	{
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(getjbWelcome());
	}
	
	public JButton getjbWelcome() 
	{
		if(jbWelcome == null)
		{
			jbWelcome = new JButton("Main menu");
			jbWelcome.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelSouth.this);
					fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(),"Start");
				}
			});
		}
		return jbWelcome;
	}
	
}

public class PanelRanking extends JPanel
{
	private static final long serialVersionUID = 1L;
	private PanelNorth panelNort;
	private PanelCenter panelCenter;
	private PanelSouth panelSouth;

	
	public PanelRanking()
	{
		this.setLayout(new BorderLayout());
		this.add(getPanelNorth(),BorderLayout.NORTH);
		this.add(getPanelCenter(),BorderLayout.CENTER);
		this.add(getPanelSouth(),BorderLayout.SOUTH);
		this.add(new JPanel(), BorderLayout.WEST);
		this.add(new JPanel(), BorderLayout.EAST);
	}

	public PanelSouth getPanelSouth()
	{
	if(panelSouth == null)
		panelSouth = new PanelSouth();
		return panelSouth;
	}
	
	public PanelCenter getPanelCenter()
	{
		if(panelCenter == null)
			panelCenter = new PanelCenter();
		return panelCenter;
	}
	
	public PanelNorth getPanelNorth()
	{
		if(panelNort == null)
			panelNort = new PanelNorth();
		return panelNort;
	}
	
}
	


	
