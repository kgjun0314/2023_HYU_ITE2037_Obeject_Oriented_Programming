package lab04;
import java.util.Random;

public class City {
	
	Random rnd = new Random();
	
	private String name;
	private int locationX;
	private int locationY;
	
	public City(String name, int locationX, int locationY){
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	public City(String name){
		this.name = name;
		locationX = rnd.nextInt(361);
		locationY = rnd.nextInt(361);
	}
	
	public String getName(){
		return name;
	}
	
	public int getLocationX(){
		return locationX;
	}
	
	public int getLocationY(){
		return locationY;
	}
	
	public Boolean equals(City city){
		if(name.equals(city.name) && locationX == city.locationX && locationY == city.locationY)
			return true;
		else
			return false;
	}
	
	public String toString(){
		return name + ", " + locationX + ", " + locationY;
	}
	
	public static double distance(City city1, City city2){
		return Math.sqrt(Math.pow(city1.locationX - city2.locationX, 2) + Math.pow(city1.locationY - city2.locationY, 2));
	}
	
}
