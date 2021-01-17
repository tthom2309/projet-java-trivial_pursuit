package view;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Christophe Decroos
 * this class contains a model to construct JTable.
 * Thanks to the pattern "Adapter", we can reuse this for several using.
   Several different JTable can be created on the basis of only model.
 * @param <E> 
 */
public class ModelTable<E extends ModelTableAdapter> extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	private E model;
	private String[] columnsName;
		
	public ModelTable(E model) 
	{
		this.model = model;
		columnsName = model.getcolumnsName();
	}
	
	@Override
	public int getRowCount()
	{
		return model.getNBrElements();
	}

	@Override
	public int getColumnCount() 
	{
			return columnsName.length;
	}
		
	public String getColumnName(int columnIndex) 
	{
		if (columnIndex >= 0 && columnIndex < columnsName.length)
		{
			return columnsName[columnIndex];
		}
			return "Unknown";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		return model.getValueAt(rowIndex, columnIndex);
	}
		
	
}

