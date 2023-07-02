// Game.java

package Cafe;

public abstract class Game // 3개의 abstract methods를 가진 abstract class 입니다.
{
	private String name;
	private double price;
	protected int quality;
	
	public Game(String name, double price, int quality) // Game의 생성자입니다.
	{
		this.name = name;
		this.price = price;
		this.quality = quality;
	}
	
	public String toString() // Game의 정보를 출력하는 메서드입니다.
	{
		return ("Name: " + name + ", Quality: " + getQuality() + ", Price: " + price + ", type:");
	}
	
	public void repair() // Game의 Quality를 100으로 바꿔주는 메서드입니다.
	{
		quality = 100;
	}
	
	public abstract double getRepairCost(); // Derived classes에서 정의 될 추상 메서드입니다.
	
	public abstract void lowerQuality(); // Derived classes에서 정의 될 추상 메서드입니다.
	
	public abstract String getQuality(); // Derived classes에서 정의 될 추상 메서드입니다.
	
	public String getName() // name을 반환하는 getter method 입니다.
	{
		return name;
	}
	
	public double getPrice() // price를 반환하는 getter method 입니다.
	{
		return price;
	}
}
