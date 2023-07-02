package lab07;

public class Koreanic extends Language
{
	public Koreanic(String name, int numSpeakers)
	{
		super(name, numSpeakers, "Korean peninsula(South Korea, North Korea, Jeju) and several prefectures of China", "subject-object-verb");
		if(name.contains("Jeju"))
		{
			this.regionsSpoken = "Jeju island";
		}
	}
}
