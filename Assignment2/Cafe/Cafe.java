// Cafe.java

package Cafe;

public class Cafe
{
	private double money;
	private Game[] gamesInCafe;
	private Game[] rentedOutGames;
	
	public Cafe(Game[] games, double startingMoney) // 현재의 잔고, 카페안에 있는 게임의 배열, 빌려준 게임의 배열을 초기화하는 constructor 입니다.
	{
		money = startingMoney;
		gamesInCafe = games;
		rentedOutGames = new Game[100];
	}
	
	public void rentOutGame(String name)
	{
		int IndexGamesInCafe = getIndexGamesInCafe(name); // renting할 game의 index를 구합니다.
		if(IndexGamesInCafe != -1) // Cafe에 존재하는 game이라면
		{
			if(gamesInCafe[IndexGamesInCafe].getQuality().equals("Bad")) // Quality가 Bad인 상태라면 renting이 불가능합니다.
			{
				System.out.println("The quality of this game is bad. so renting is unavailable.");
			}
			else
			{
				for(int i = 0; i < rentedOutGames.length; i++)
				{
					if(rentedOutGames[i] == null) // class type의 array이므로 초기화 되지 않은 부분을 찾습니다.
					{
						rentedOutGames[i] = gamesInCafe[IndexGamesInCafe]; // 해당 부분을 초기화해주고
						gamesInCafe[IndexGamesInCafe] = null; // Cafe에 해당 Game이 있던 부분을 비워줍니다.
						money += 0.5 * rentedOutGames[i].getPrice(); // 잔고를 수정해줍니다.
						System.out.println("Game rented succesfully");
						break;
					}
				}				
			}
		}
		else // Cafe에 존재하지 않는 game이라면
		{
			System.out.println("There is no such game.");
		}
	}
	
	public void returnGame(String name)
	{
		int IndexRentedOutGames = getIndexRentedOutGames(name); // returning할 game의 index를 구합니다.
		if(IndexRentedOutGames != -1) // Renting 되었던 game이 맞다면
		{
			for(int i = 0; i < gamesInCafe.length; i++)
			{
				if(gamesInCafe[i] == null) // class type의 array이므로 초기화 되지 않은 부분을 찾습니다.
				{
					gamesInCafe[i] = rentedOutGames[IndexRentedOutGames]; // 해당 부분을 초기화해주고
					rentedOutGames[IndexRentedOutGames] = null; // Renting된 것을 모아놓은 배열에 Game이 있던 부분을 비워줍니다.
					gamesInCafe[i].lowerQuality(); // Returning 할 때 품질이 낮아집니다.
					System.out.println("Game returned succesfully");
					break;
				}				
			}
		}
		else // Renting 되었던 game이 아니라면
		{
			System.out.println("This is not one of our games that is rented out!");
		}
	}
	
	public void buyGame(Game game)
	{
		if(getIndexGamesInCafe(game.getName()) != -1 && getIndexRentedOutGames(game.getName()) != -1) // 해당 게임이 이미 존재한다면
		{
			System.out.println("This game already exists.");
		}
		else // 새로운 게임이라면
		{	
			for(int i = 0; i < gamesInCafe.length; i++)
			{
				if(gamesInCafe[i] == null) // class type의 array이므로 초기화 되지 않는 부분을 찾습니다.
				{
					gamesInCafe[i] = game; // 해당 부분을 초기화합니다.
					money -= gamesInCafe[i].getPrice(); // 해당 게임의 가격만큼 잔고에서 빼줍니다.
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
			if(gamesInCafe[i] != null) // class type의 array이므로 초기화 된 부분을 찾습니다.
			{
				System.out.println(gamesInCafe[i]);
			}
		}
		System.out.println("Games rented out:");
		for(int i = 0; i < gamesInCafe.length; i++)
		{
			if(rentedOutGames[i] != null) // class type의 array이므로 초기화 된 부분을 찾습니다.
			{
				System.out.println(rentedOutGames[i]);
			}
		}
	}
	
	public void repairGame(String name)
	{
		int IndexGamesInCafe = getIndexGamesInCafe(name); // repairing할 game의 index를 구합니다.
		if(IndexGamesInCafe != -1) // Cafe에 존재하는 game이라면
		{
			if(gamesInCafe[IndexGamesInCafe].getQuality().equals("Bad") || gamesInCafe[IndexGamesInCafe].getQuality().equals("Okay")) // game의 quality가 Good이 아닌 상태라면
			{
				money -= gamesInCafe[IndexGamesInCafe].getRepairCost(); // 잔액에서 수리비만큼 빼줍니다.
				gamesInCafe[IndexGamesInCafe].repair(); // 그리고 해당 Game을 수리합니다.
				System.out.printf("Repaired succesfully, remaining money: %.1f\n", this.money);
			}
			else // game의 quality가 Good이라면
			{
				System.out.println("The quality of game is already good.");			
			}
		}
		else // Cafe에 존재하지 않는 game이라면
		{
			System.out.println("There is no such game.");
		}
	}
	
	private int getIndexGamesInCafe(String name) // gamesInCafe 배열안에 있는 game의 index를 찾는 method입니다.
	{
		for(int i = 0; i < gamesInCafe.length; i++)
		{
			if(gamesInCafe[i] != null) // gamesInCafe는 class type의 배열이기 때문에 null이 아니라면 초기화 된 것입니다.
			{
				if(gamesInCafe[i].getName().equals(name)) // 찾고자 하는 game의 name과 일치한다면
				{
					return i; // index를 return합니다.
				}
			}
		}
		return -1; // 찾고자 하는 게임이 존재하지 않으면 -1을 return 합니다.
	}
	
	private int getIndexRentedOutGames(String name) // rentedOutGames 배열안에 있는 game의 index를 찾는 method입니다.
	{
		for(int i = 0; i < rentedOutGames.length; i++)
		{
			if(rentedOutGames[i] != null) // rentedOutGame는 class type의 배열이기 때문에 null이 아니라면 초기화 된 것입니다.
			{
				if(rentedOutGames[i].getName().equals(name)) // 찾고자 하는 game의 name과 일치한다면
				{
					return i; // index를 return합니다.
				}
			}
		}
		return -1; // 찾고자 하는 게임이 존재하지 않으면 -1을 return 합니다.
	}
	
	public double getMoney() // 현재의 잔액을 return 합니다.
	{
		return money;
	}
}