package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.IndexNegativeException;
import exception.IndexTooHighException;

/**
 * This class allows to browse a List of Question. It's also the class mother for
 * the set of Iterator concerning List of Question.
 * The attribut index allows to know the position in the List of Question. The browse of the List 
 * is based on it.
 * The attribut list correspond to a List of Question.  
 * @author Christophe Decroos
 */
public class IteratorQuestion implements Iterator<Question>
{

	private int index;
	private List<Question> list;
	
	public IteratorQuestion(List<Question> list)
	{
		this.list = list;
	}

	public int getIndex() {
		return index;
	}

	public List<Question> getList() 
	{
		List<Question> l = new ArrayList<Question>();
		
		for(Question q : list)
		{
			Question p = new Question(q.getAuthor(), q.getStatement(), q.getCategory());
			p.setChoices(q.getChoices());
			l.add(p);
		}
		
		return l;
	}

	public void setIndex(int index) throws IndexNegativeException, IndexTooHighException 
	{
		if(index<0)
		{
			throw new IndexNegativeException(index);
		}
		else if(index>=list.size()){
			throw new IndexTooHighException(index, list.size());
		}
		this.index = index;
	}
	
	/**
	 * @author Christophe Decroos
	 * Method wich allows to increment the index.
	 */
	public void incrementIndex()
	{
		index++;
	}
	
	/**
	 * @author Christophe Decroos
	 * Method wich allows to decrement the index.
	 */
	public void DecrementIndex()
	{
		index--;
	}

	public int getSize()
	{
		return list.size();
	}
	
	/** This method allows to retrieve a Question in the list of Question.
	 * @author Christophe Decroos
	 * @return Question
	 */
	public Question getItem() 
	{
		if (index < list.size() && index >= 0) 
		{
			return list.get(index);
		}
		else 
		{
			return null;
		}
	}
	
	/**
	 * This method allows to know if there is a next Question in the List of Question.
	 * @author Christophe Decroos
	 * @return boolean
	 */
	public boolean hasNext() 
	{
		return index < list.size();
	}

	/** 
	 * This method allows to retrieve the next Question in the List of Question.
	 * @author Christophe Decroos
	 * @ return Question
	 */
	public Question next() 
	{
		Question q = getItem();
		index++;
		return q;
	}
	
	/**
	 * This method allows to know if there is a previous Question in the List of Question.
	 * @author Christophe Decroos
	 * @return boolean
	 */
	public boolean hasPrevious()
	{
		return index >= 0;
	}
	
	/**
	 * This method allows to retrieve the previous Question in the List of Question.
	 * @return Christophe Decroos
	 */
	public Question previous()
	{
		Question q = getItem();
		index--;
		return q;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	
}
