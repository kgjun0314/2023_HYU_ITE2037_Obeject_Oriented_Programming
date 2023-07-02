package lab09;

public class NegativeException extends Exception
{
	public NegativeException()
	{
		super("price must be positive");
	}
	
	public NegativeException(String message)
	{
		super(message);
	}
}
