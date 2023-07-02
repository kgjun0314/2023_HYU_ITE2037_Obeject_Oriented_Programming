package Cafe;

import java.util.Scanner;

public class CafeManager 
{
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		Game[] games = new Game[100];
		games[0] = new Game("Battleship", 4.25);
		games[1] = new Game("Uno", 7.0);
		games[2] = new Game("Blue marvle", 5.5);
		
		Cafe cafe = new Cafe(games, 5);
		
		while(true)
		{
			cafe.printCafeDetails();
			
			System.out.println("What would you like to do:");
			System.out.println("1: Rent a game, 2: return a game, 3: repair a game, 4: buy a new game, 0: quit program");
			int command = keyboard.nextInt();
			while(command != 1 && command != 2 && command != 3 && command != 4 && command != 0)
			{
				System.out.println("What would you like to do:");
				System.out.println("1: Rent a game, 2: return a game, 3: repair a game, 4: buy a new game, 0: quit program");
				command = keyboard.nextInt();
			}
			
			if(command == 1)
			{
				System.out.println("Which game would you like to rent?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine();
				cafe.rentOutGame(nameOfGame);
			}
			else if(command == 2)
			{
				System.out.println("Which game would you like to return?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine();
				cafe.returnGame(nameOfGame);
			}
			else if(command == 3)
			{
				System.out.println("Which game would you like to repair?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine();
				cafe.repairGame(nameOfGame);
			}
			else if(command == 4)
			{
				System.out.println("What is the name of the game?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine();
				System.out.println("What is the price of the game?");
				double priceOfGame = keyboard.nextDouble();
				if(priceOfGame > cafe.getMoney())
				{
					System.out.println("Not enough funds for the game");
				}
				else
				{
					Game newGame = new Game(nameOfGame, priceOfGame);
					cafe.buyGame(newGame);
				}
			}
			else if(command == 0)
			{
				System.out.println("End program.");
				break;
			}
		}
	}
}
