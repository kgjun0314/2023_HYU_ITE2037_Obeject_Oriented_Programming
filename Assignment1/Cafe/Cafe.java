package Cafe;

public class Cafe
{
	private double money;
	private Game[] gamesInCafe;
	private Game[] rentedOutGames;
	
	public Cafe(Game[] games, double startingMoney)
	{
		money = startingMoney;
		gamesInCafe = games;
		rentedOutGames = new Game[100];
	}
	
	public void rentOutGame(String name)
	{
		int IndexGamesInCafe = getIndexGamesInCafe(name);
		if(IndexGamesInCafe != -1)
		{
			if(gamesInCafe[IndexGamesInCafe].getQuality().equals("Bad"))
			{
				System.out.println("The quality of this game is bad. so renting is unavailable.");
			}
			else
			{
				for(int i = 0; i < rentedOutGames.length; i++)
				{
					if(rentedOutGames[i] == null)
					{
						rentedOutGames[i] = gamesInCafe[IndexGamesInCafe];
						gamesInCafe[IndexGamesInCafe] = null;
						money += 0.5 * rentedOutGames[i].getPrice();
						System.out.println("Game rented succesfully");
						break;
					}
				}				
			}
		}
		else
		{
			System.out.println("There is no such game.");
		}
	}
	
	public void returnGame(String name)
	{
		int IndexRentedOutGames = getIndexRentedOutGames(name);
		if(IndexRentedOutGames != -1)
		{
			for(int i = 0; i < gamesInCafe.length; i++)
			{
				if(gamesInCafe[i] == null)
				{
					gamesInCafe[i] = rentedOutGames[IndexRentedOutGames];
					rentedOutGames[IndexRentedOutGames] = null;
					gamesInCafe[i].lowerQuality();
					System.out.println("Game returned succesfully");
					break;
				}				
			}
		}
		else
		{
			System.out.println("This is not one of our games that is rented out!");
		}
	}
	
	public void buyGame(Game game)
	{
		if(getIndexGamesInCafe(game.getName()) != -1)
		{
			System.out.println("This game already exists.");
		}
		else
		{	
			for(int i = 0; i < gamesInCafe.length; i++)
			{
				if(gamesInCafe[i] == null)
				{
					gamesInCafe[i] = game;
					money -= gamesInCafe[i].getPrice();
					break;
				}
			}
			System.out.println("Game bought succesfully");
		}
	}
	
	public void printCafeDetails()
	{
		System.out.printf("Money: %.1f\n", money);
		System.out.println("Games in cafe:");
		for(int i = 0; i < gamesInCafe.length; i++)
		{
			if(gamesInCafe[i] != null)
			{
				System.out.println(gamesInCafe[i]);
			}
		}
		System.out.println("Games rented out:");
		for(int i = 0; i < gamesInCafe.length; i++)
		{
			if(rentedOutGames[i] != null)
			{
				System.out.println(rentedOutGames[i]);
			}
		}
	}
	
	public void repairGame(String name)
	{
		int IndexGamesInCafe = getIndexGamesInCafe(name);
		if(IndexGamesInCafe != -1)
		{
			if(gamesInCafe[IndexGamesInCafe].getQuality().equals("Bad") || gamesInCafe[IndexGamesInCafe].getQuality().equals("Okay"))
			{
				money -= gamesInCafe[IndexGamesInCafe].getRepairCost();
				gamesInCafe[IndexGamesInCafe].repair();
				System.out.printf("Repaired succesfully, remaining money: %.1f\n", this.money);
			}
			else
			{
				System.out.println("The quality of game is already good.");			
			}
		}
		else
		{
			System.out.println("There is no such game.");
		}
	}
	
	private int getIndexGamesInCafe(String name)
	{
		for(int i = 0; i < gamesInCafe.length; i++)
		{
			if(gamesInCafe[i] != null)
			{
				if(gamesInCafe[i].getName().equals(name))
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	private int getIndexRentedOutGames(String name)
	{
		for(int i = 0; i < rentedOutGames.length; i++)
		{
			if(rentedOutGames[i] != null)
			{
				if(rentedOutGames[i].getName().equals(name))
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	public double getMoney()
	{
		return money;
	}
}
