package lab11;

import java.util.ArrayList;
import java.util.Scanner;

public class Logistics 
{
	public static void main(String[] args) 
	{
		String[] new_gyeonggi_boxes = {"SuWon#1", "SeongNam#1", "YongIn#1", "GoSeong#1", "GaPyeong#1"};
		String[] new_gangwon_boxes = {"Gangneung#1", "Wonju#1"};
		ArrayList<Gyeonggi> gyList = new ArrayList<Gyeonggi>();
		ArrayList<Gangwon> gaList = new ArrayList<Gangwon>();
		
		Scanner scan = new Scanner(System.in);
		
		ServiceManagement.packageBoxes(new_gyeonggi_boxes, Gyeonggi.class, gyList);
		ServiceManagement.packageBoxes(new_gangwon_boxes, Gangwon.class, gaList);
		
		System.out.println("*** oh, delivery price has been increased!! ***");
		
		gyList = ServiceManagement.raiseAll(Gyeonggi.class, gyList, 1.05);
		gaList = ServiceManagement.raiseAll(Gangwon.class, gaList, 1.05);
		
		System.out.println("Which box is important in Gangwon-area?");
		
		int index = scan.nextInt();
		
		index = ServiceManagement.findIndexByNum(gaList, index);
		
		if(index == -1)
		{
			System.out.println("nothing");
		}
		else
		{
			System.out.println("The box \"" + gaList.get(index).getDescription() + "\" is important! be careful!\n");
			ServiceManagement.raisePerBox(gaList.get(index), 1.2);
		}
		
		System.out.println("Which box has the wrong area in Gyeonggi-area?");
		
		index = scan.nextInt();
		
		index = ServiceManagement.findIndexByNum(gyList, index);
		
		if(index == -1)
		{
			System.out.println("nothing");
		}
		else
		{
			System.out.println("The box \"" + gyList.get(index).getDescription() + "\" is actually has to go Gangwon! late! hurry up!\n");
			
			ServiceManagement.changeHub(gyList, index, Gangwon.class, gaList);
		}
		
		System.out.println("-------- Delivery List for Gyeonggi --------\n");
		for(Gyeonggi g : gyList)
		{
			if(g == null)
				System.out.println("null\n");
			else
				System.out.println(g + "\n");
		}
		
		System.out.println("-------- Delivery List for Gangwon --------\n");
		for(Gangwon j : gaList)
		{
			if(j == null)
				System.out.println("null\n");
			else
				System.out.println(j + "\n");
		}
		
		scan.close();
	}
}
