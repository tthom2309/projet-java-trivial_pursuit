package view;

/**
 * 
 * @author Christophe Decroos
 * this interface contains method wich will be redefine to construct a JTable adapted for our need.
 *
 */
public interface ModelTableAdapter 
{
	public String[] getcolumnsName();
	public int getNBrElements();
	public Object getValueAt(int rowIndex, int columnIndex);

}
