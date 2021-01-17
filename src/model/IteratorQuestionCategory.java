package model;

import java.util.List;

/**
 * This class allows to browse a List of Question and to retrieve the objects Questions which contains 
 * in its attributs category the value of catCond.
 * The attribut catCond correspond to the condition which have to be respected.
 * @author Christophe Decroos
 *
 */
public class IteratorQuestionCategory extends IteratorQuestion
{
	private Category catCond;
	
	public IteratorQuestionCategory(List<Question> list,Category catCond)
	{
		super(list);
		setCatCond(catCond);
	}

	public Category getCat() {
		return catCond;
	}

	public void setCatCond(Category catCond) 
	{
		this.catCond = catCond;
		//start();
	}
	
	/** 
	 * This method allows to retrieve the next Question in the List of Question wich respect the condition.
	 * @author Christophe Decroos
	 * @ return Question
	 */
	public Question next() 
	{
		for (;;) 
		{
			Question q = super.getItem();
			super.incrementIndex();
			
			if (q == null) 
			{
				return q;
			}
			if (q.getCategory() == catCond) 
			{
				return q;
			}
		}
	}
	
	
}
