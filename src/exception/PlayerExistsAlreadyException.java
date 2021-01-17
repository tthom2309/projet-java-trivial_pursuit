package exception;

public class PlayerExistsAlreadyException extends Exception
{
	public PlayerExistsAlreadyException()
	{
		super("This login already exists !");
	}

}
