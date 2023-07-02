// GameCorner.java

package Cafe;

import java.util.ArrayList;

public class GameCorner
{
	private ArrayList<Game> gamesInCafe; // gamesInCafe와
	private ArrayList<Game> rentedOutGames; // rentedOutGames를 ArrayList로 선언합니다.
	
	public GameCorner(ArrayList<Game> games) // 카페안에 있는 게임의 배열, 빌려준 게임의 배열을 초기화하는 constructor 입니다.
	{
		gamesInCafe = games; 
		rentedOutGames = new ArrayList<Game>();
	}
	
	public double rentOutGame(String name)
	{
		double costOfRenting;
		int IndexGamesInCafe = getIndexGamesInCafe(name); // renting할 game의 index를 구합니다.
		if(IndexGamesInCafe != -1) // Cafe에 존재하는 game이라면
		{
			if(gamesInCafe.get(IndexGamesInCafe).getQuality().equals("Bad")) // Quality가 Bad인 상태라면 renting이 불가능합니다.
			{
				System.out.println("The quality of this game is bad. so renting is unavailable.");
				return 0;
			}
			else // Quality가 Bad가 아니라면
			{
				costOfRenting = 0.5 * gamesInCafe.get(IndexGamesInCafe).getPrice(); // 해당 게임의 대여비를 costOfRenting 변수에 저장하고,
				rentedOutGames.add(gamesInCafe.get(IndexGamesInCafe)); // rentedOutGames ArrayList에 해당 게임을 추가합니다.
				gamesInCafe.remove(IndexGamesInCafe); // 그리고 해당 게임을 gamesInCafe ArrayList에서 제거합니다.
				System.out.println("Game rented succesfully");
				return costOfRenting; // 대여비를 반환합니다.
			}
		}
		else // Cafe에 존재하지 않는 game이라면
		{
			System.out.println("There is no such game.");
			return 0;
		}
	}
	
	public void returnGame(String name)
	{
		int IndexRentedOutGames = getIndexRentedOutGames(name); // returning할 game의 index를 구합니다.
		if(IndexRentedOutGames != -1) // Renting 되었던 game이 맞다면
		{		
			rentedOutGames.get(IndexRentedOutGames).lowerQuality(); // rentedOutGames에 있는 반납할 게임의 Quality를 낮추어줍니다.
			gamesInCafe.add(rentedOutGames.get(IndexRentedOutGames)); // 반납할 게임을 gamesInCafe에 추가하여 반납합니다.
			rentedOutGames.remove(IndexRentedOutGames); // rentedOutGames에 있는 해당 게임을 제거합니다.
			System.out.println("Game returned succesfully");
		}
		else // Renting 되었던 game이 아니라면
		{
			System.out.println("This is not one of our games that is rented out!");
		}
	}
	
	public void buyGame(Game game)
	{
		if(getIndexGamesInCafe(game.getName()) != -1 || getIndexRentedOutGames(game.getName()) != -1) // 해당 게임이 이미 존재한다면
		{
			System.out.println("This game already exists.");
		}
		else // 새로운 게임이라면
		{	
			gamesInCafe.add(game); // Game을 추가해줍니다.
			CafeManager.money -= game.getPrice(); // 해당 게임의 가격만큼 잔고에서 빼줍니다.
		
			System.out.println("Game bought succesfully");
		}
	}
	
	public void printCafeDetails()
	{
		System.out.printf("Money: %.2f\n", CafeManager.money); // 현재의 잔고를 출력하고
		System.out.println("Games in cafe:");
		for(int i = 0; i < gamesInCafe.size(); i++) // gamesInCafe에 있는 게임 목록을 출력합니다.
		{
			System.out.println(gamesInCafe.get(i));
		}
		System.out.println("Games rented out:");
		for(int i = 0; i < rentedOutGames.size(); i++) // rentedOutGames에 있는 게임 목록을 출력합니다.
		{
			System.out.println(rentedOutGames.get(i));
		}
	}
	
	public double repairGame(String name)
	{
		double repairCost;
		int IndexGamesInCafe = getIndexGamesInCafe(name); // repairing할 game의 index를 구합니다.
		if(IndexGamesInCafe != -1) // Cafe에 존재하는 game이라면
		{
			if(gamesInCafe.get(IndexGamesInCafe).getQuality().equals("Bad") || gamesInCafe.get(IndexGamesInCafe).getQuality().equals("Okay")) // game의 quality가 Good이 아닌 상태라면
			{
				repairCost = gamesInCafe.get(IndexGamesInCafe).getRepairCost(); // repairCost 변수에 수리비를 저장합니다.
				gamesInCafe.get(IndexGamesInCafe).repair(); // 그리고 해당 Game을 수리합니다.
				return repairCost; // 수리비를 반환합니다.
			}
			else // game의 quality가 Good이라면
			{	
				return -1;
			}
		}
		else // Cafe에 존재하지 않는 game이라면
		{
			return -2;
		}
	}
	
	private int getIndexGamesInCafe(String name) // gamesInCafe 배열안에 있는 game의 index를 찾는 method입니다.
	{
		for(int i = 0; i < gamesInCafe.size(); i++)
		{
			if(gamesInCafe.get(i).getName().equals(name)) // 찾고자 하는 game의 name과 일치한다면
			{
					return i; // index를 return합니다.
			}
		}
		return -1; // 찾고자 하는 게임이 존재하지 않으면 -1을 return 합니다.
	}
	
	private int getIndexRentedOutGames(String name) // rentedOutGames 배열안에 있는 game의 index를 찾는 method입니다.
	{
		for(int i = 0; i < rentedOutGames.size(); i++)
		{
			if(rentedOutGames.get(i).getName().equals(name)) // 찾고자 하는 game의 name과 일치한다면
			{
					return i; // index를 return합니다.
			}
		}
		return -1; // 찾고자 하는 게임이 존재하지 않으면 -1을 return 합니다.
	}
	
	public double getMoney() // 현재의 잔액을 return 합니다.
	{
		return CafeManager.money;
	}
}