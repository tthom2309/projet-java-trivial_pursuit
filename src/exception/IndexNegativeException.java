package exception;

public class IndexNegativeException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public IndexNegativeException(int ind)
	{
		super("The index can't be negative!");
	}

	
}
