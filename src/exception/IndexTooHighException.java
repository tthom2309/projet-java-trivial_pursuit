package exception;

public class IndexTooHighException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public IndexTooHighException(int index, int sizeList)
	{
		super("The index ("+index+") is incompatible against the size of the list ("+sizeList+")!");
	}

	
}
