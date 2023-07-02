package lab10;

public class Tiger extends Animal implements Barkable
{
	public Tiger()
	{
		super("Tiger");
	}
	
	public String bark()
	{
		return "Growl";
	}
}
