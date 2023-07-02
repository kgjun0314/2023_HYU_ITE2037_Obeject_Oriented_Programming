package lab08;
import java.time.LocalDate;

public class BEV extends Car
{
	private static int carNum;
	private static int CO2emission;
	private static int GHGPERCAR = 25;
	
	BEV()
	{
		super();
	}
	
	BEV(String name, LocalDate date, int carNum)
	{
		this.name = name;
		this.date = date;
		this.carNum += carNum;
		CO2emission += carNum * GHGPERCAR;
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else
		{
			Car car = (Car)obj;
			return (this.name.equals(car.name) && this.date.equals(car.date));
		}
	}
	
	public String toString()
	{
		return ("name: " + name + ", date: " + date + ", carNum: " + carNum);
	}
	
	int totalCO2()
	{
		System.out.println("BEV emit CO2 most when generating electirc energy");
		return CO2emission;
	}
}