package lab11;

public class Hub 
{
	private int number;
	private String description;
	private String area;
	private double price_per_box;
	
	public int getNumber() 
	{
		return number;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public String getArea() 
	{
		return area;
	}
	
	public double getPricePerBox() 
	{
		return price_per_box;
	}
	
	public void setNumber(int number) 
	{
		this.number = number;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public void setArea(String area) 
	{
		this.area = area;
	}
	
	public void setPricePerBox(double price_per_box) 
	{
		this.price_per_box = price_per_box;
	}
	
	public String toString()
	{
		return ("Box Number : " + number + "\nDescription : " + description + "\nArea : " + area + "\nPrice per box : " + price_per_box);
	}
}
