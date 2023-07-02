package lab09;

public class TooMuchExpenseException extends Exception
{
	private int inputNum;
	
	public TooMuchExpenseException()
	{
		super("Not enough balance.");
	}
	
	public TooMuchExpenseException(int number)
	{
		super("Over the limit!");
		inputNum = number;
	}
	
	public int getInputNum()
	{
		return inputNum;
	}
}
