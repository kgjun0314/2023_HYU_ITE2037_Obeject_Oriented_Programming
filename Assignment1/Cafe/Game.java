package Cafe;

public class Game
{
	private String name;
	private String quality;
	private double price;
	
	public Game(String name, double price)
	{
		this.name = name;
		quality = "Good";
		this.price = price;
	}
	
	public String toString()
	{
		return ("Name: " + name + ", Quality: " + quality + ", Price: " + price + ".");
	}
	
	public double getRepairCost()
	{
		double RepairCost = 0;
		if(quality == "Bad")
		{
			RepairCost = 0.5 * price;
		}
		else if(quality == "Okay")
		{
			RepairCost = 0.2 * price;
		}
		return RepairCost;
	}
	
	public void repair()
	{
		quality = "Good";
	}
	
	public void lowerQuality()
	{
		if(quality == "Good")
		{
			quality = "Okay";
		}
		else if(quality == "Okay")
		{
			quality = "Bad";
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getQuality()
	{
		return quality;
	}
	
	public double getPrice()
	{
		return price;
	}
}
