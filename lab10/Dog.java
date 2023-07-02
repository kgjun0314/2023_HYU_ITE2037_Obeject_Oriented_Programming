package lab10;

public class Dog extends Animal implements Barkable{
	public Dog()
	{
		super("Dog");
	}
	
	public String bark()
	{
		return "Bowwow";
	}
}
