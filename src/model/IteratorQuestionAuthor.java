package model;

import java.util.List;

/**
 * This class allows to browse a List of Question and to retrieve the objects Questions which contains 
 * in its attributs author the value of authorCond.
 * The attribut authorCond correspond to the condition which have to be respected.
 * @author Christophe Decroos
 *
 */
public class IteratorQuestionAuthor extends IteratorQuestion {
	
private String authorCond;
	
	public IteratorQuestionAuthor(List<Question> list,String authorCond)
	{
		super(list);
		setAuthorCond(authorCond);
	}

	public String getAuthorCond() {
		return authorCond;
	}

	public void setAuthorCond(String authorCond) 
	{
		this.authorCond = authorCond;
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
			if (authorCond == q.getAuthor()) 
			{
				return q;
			}
		}
	}

}
