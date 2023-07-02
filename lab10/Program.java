package lab10;

public class Program 
{
	public static void main(String[] args) 
	{
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animal = new Animal[3];
		animal[0] = dog;
		animal[1] = tiger;
		animal[2] = turtle;
		
		Person person = new Person() 
		{
			private int hp = 100;
			
			public void control(Animal animal)
			{
				if(animal instanceof Dog)
				{
					hp -= 10;
					System.out.println("You have overpowered the Dog");
				}
				else if(animal instanceof Tiger)
				{
					hp -= 80;
					System.out.println("You have overpowered the Tiger");
				}
				else if(animal instanceof Turtle)
				{
					System.out.println("You have overpowered the Turtle");
				}
			}
			
			public void showInfo()
			{
				System.out.println("Person HP: " + hp);
			}
		};
		
		showResult(animal, person);
	}
	
	private static void showResult(Animal[] animals, Person P)
	{
		for(int i = 0; i < animals.length; i++)
		{
			System.out.println("Animal" + (i + 1) + ":" + animals[i].getName());
			if(!(animals[i] instanceof Turtle))
			{
				Barkable a = (Barkable)animals[i];
				System.out.println("Animal" + (i + 1) + " barked " + a.bark());
			}
			P.control(animals[i]);
			P.showInfo();
		}
	}
}
