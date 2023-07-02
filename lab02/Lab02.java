package lab02;

import java.util.Scanner;

public class Lab02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		String[] arr = input.split(",");
		
		String[] name = arr[0].split(" ");
		
		String lastName = name[name.length - 1];
		
		System.out.println("Name Length(Korean) : " + name.length);
		for(int i = 0; i < name.length - 1; i++)
		{
			String str = name[i].substring(0, 1).toUpperCase();
			System.out.printf(str + ".");
		}
		
		String str = lastName.substring(0, 1).toUpperCase();
		String sub = lastName.substring(1);
		System.out.printf(str + sub);
		
		String fileName = arr[1].trim();
		String str2 = fileName.substring(0,1).toUpperCase();
		String sub2 = fileName.substring(1);
		System.out.printf(" submitted " + str2 +  sub2.replace("ppt", "pdf"));
	}
}
