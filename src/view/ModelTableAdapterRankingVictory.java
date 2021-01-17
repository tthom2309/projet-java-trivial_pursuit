package view;

import model.Gamer;
import model.ManageUsers;

/**
 * 
 * @author Christophe
 * This class allows to adapte the modelTable according to a gamer ranking by total of victories. 
 *
 */
public class ModelTableAdapterRankingVictory implements ModelTableAdapter 
{
	@Override
	public String[] getcolumnsName()
	{
		return new String[] {"Position","Login","Total Victories","Total games"};
	}

	@Override
	public int getNBrElements() 
	{
		return ManageUsers.getInstance().nbGamer();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Gamer gamer  = ManageUsers.getInstance().getGamer(rowIndex);
		
		switch(columnIndex)
		{
		case 0:
			return gamer.getStatg().getRankingPosVic();
		case 1:
			return gamer.getLogin();
		case 2:
			return gamer.getStatg().getNbVic();
		case 3:
			return gamer.getStatg().getNbPart();
		}
		return null;
	}

}
