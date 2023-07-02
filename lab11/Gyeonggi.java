package lab11;

public class Gyeonggi extends Hub
{
	public static int init_num = 10000;
	public static String init_area = "Gyeonggi";
	public static double init_price_per_box = 3000;
	
	public Gyeonggi(String description)
	{
		this.setDescription(description);
		this.setArea(init_area);
		this.setPricePerBox(init_price_per_box);
		this.setNumber(++init_num);
	}
}
