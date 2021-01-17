package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import utility.Serialisation;
import model.Observer;
import model.Question;
import model.Stack;

/**
 * 
 * This method show all the question, and allow tadmin to delete questions
 *
 */
public class PanelQuestion extends JPanel implements Observer
{
	
	
	private static final long serialVersionUID = 1L;
	private JTable jtable;
	private ModelTableau modeleTableau;
	private PanelButtons panelButtons;
	
	
	public PanelQuestion()
	{
		this.setLayout(new BorderLayout());
		this.add(getJtable(),BorderLayout.NORTH);
		this.add(new JScrollPane(getJtable()));
		this.add(getPanelButtons(), BorderLayout.SOUTH);
		
	}
	
	public JTable getJtable()
	{
		if(jtable==null)
		{
			jtable = new JTable(getModeleTableau());      // on lui envoi le modeleTableau via le getter
			//jtable.getSelectionModel().setSelectionInterval(,);
		}
		return jtable;
	}
	public ModelTableau getModeleTableau(){
		if(modeleTableau == null)
		{
			modeleTableau = new ModelTableau();
		}
		return modeleTableau;
	}
	
	
	public PanelButtons getPanelButtons()
	{
		if(panelButtons == null)
			panelButtons = new PanelButtons();
		return panelButtons;
	}

	@Override
	public void actualise() 
	{
		this.getModeleTableau().fireTableDataChanged();
	}
}


class PanelButtons extends JPanel
{
	
	
	private static final long serialVersionUID = 1L;
	private JButton jbSupprimer;
	private JButton jbAjouter;
	private JButton jbRetour;
	
	
	public PanelButtons()
	{
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.add(getJbAjouter());
		this.add(getjbSupprimer());
		this.add(getjbRetour());
		
		
	}
	
	public JButton getjbSupprimer()
	{
		if(jbSupprimer == null)
		{
			jbSupprimer = new JButton("Delete");
			jbSupprimer.setVisible(false); //invisible au debut car il faut etre connecté en admin pour y acceder
			jbSupprimer.addActionListener(new ActionListener() 
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Stack stack = Stack.getInstance(); //TODO retrieveStack("groupe07.json"); 
					Window fp = (Window) SwingUtilities.getAncestorOfClass(Window.class, PanelButtons.this);
					int[] rows = fp.getPanelCartes().getPanelQuestion().getJtable().getSelectedRows();
					
					for(int i=rows.length-1;i>=0;i--) // boucle en sens inverse pour éviter le bug du row lors ce que l'on selectionne plusieurs items
					{							
					     stack.removeQuestion(rows[i]);
					 }
					Serialisation.saveStack("Data/question.json", stack);
					
					
					//fp.getPanelCartes().getPanelt().getModeleTableau().fireTableDataChanged(); //   Plus besoin grâce à l'observer
					//fp.getPanelCartes().getPanelC().getModeleCombo().update();
				}
			});
		}
		return jbSupprimer;
	}
	
	
	
	public JButton getJbAjouter()
	{
		if(jbAjouter == null)
		{
			jbAjouter= new JButton("Add");
			jbAjouter.setVisible(false); //invisible au debut car il faut etre connecté en admin pour y acceder
			jbAjouter.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					Window fp = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelButtons.this);
					fp.getPanelCartes().getCl().show(fp.getPanelCartes(),"AddQuestion");
					
				}
				
			});
		}
		return jbAjouter;
	}
	
	
	public JButton getjbRetour()
	{
		if(jbRetour==null)
		{
			jbRetour = new JButton("Main menu");
			jbRetour.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					Window fenetre = (Window)SwingUtilities.getAncestorOfClass(Window.class,PanelButtons.this);
					fenetre.getPanelCartes().getCl().show(fenetre.getPanelCartes(),"Start");
				}
				
			});
		}

		return jbRetour;
	}
	
}


class ModelTableau extends AbstractTableModel{
	
	
	private static final long serialVersionUID = 1L;
	private String[]nomColonnes={"Author","Statement","Category","Choice"};
	
	
	
	public ModelTableau()
	{
		
	}
	
	
	@Override
	public int getColumnCount() 
	{
		
		return nomColonnes.length ;
	}

	@Override
	public int getRowCount() 
	{				 
		return  Stack.getInstance().nombreQuestion();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		Question q = Stack.getInstance().getQuestion(rowIndex);
		switch(columnIndex)
		{
		case 0 :
			return q.getAuthor();
		case 1:
			return q.getStatement();
		case 2:
			return q.getCategory();
		case 3:
			return q.getChoices();
		}
		return null;
	}
	
	


	public String getColumn(int index)
	{
		if(index>=0 && index<nomColonnes.length)
		{
			return nomColonnes[index];
		}
		return null;
	}
	
	public String getColumnName(int index)
	{
		return nomColonnes[index];
	}
	
	
}
