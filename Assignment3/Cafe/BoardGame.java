// BoardGame.java

package Cafe;

public class BoardGame extends Game // Game을 Base class로 한 BoardGame class 입니다.
{
	public BoardGame(String name, double price, int quality) // 상위 class의 constructor를 invoke 합니다.
	{
		super(name, price, quality);
	}
	
	public double getRepairCost() // 수리비를 반환하는 메서드입니다.
	{
		return quality * 0.04;
	}
	
	public void lowerQuality() // 품질의 수치를 떨어뜨리는 메서드입니다.
	{
		quality -= 25;
	}
	
	public String getQuality() // 품질의 수치에 따른 품질을 구분하여 주는 메서드입니다.
	{
		if(quality > 70)
			return "Good";
		else if(quality >= 50)
			return "Okay";
		else
			return "Bad";
	}
	
	public String toString() // type을 출력해야 하기 때문에 Base class의 toString method를 overriding 한 메서드입니다.
	{
		return ("Name: " + super.getName() + ", Quality: " + getQuality() + ", Price: " + super.getPrice() + ", type: Board");
	}
}
