// CafeManager.java

package Cafe;
import java.util.Scanner;

public class CafeManager 
{
	public static void main(String[] args) throws Exception
	{
		Scanner keyboard = new Scanner(System.in);
		CSVLoader csvloader = new CSVLoader(); // CSVLoader 객체를 초기화합니다.
		
		System.out.println("What is the path of the games file?"); // 출력예시와 같이 파일의 경로를 입력합니다.
		String filename = keyboard.nextLine();
		Game[] games = csvloader.loadGames(filename); // csvloader의 loadGames method를 사용해 array를 받습니다.
		Cafe cafe = new Cafe(games, 5); // games array와 초기 잔고를 받아 cafe instance를 초기화합니다.
		
		while(true) // 0 을 입력해 프로그램을 종료하기 전까지 동작합니다.
		{
			cafe.printCafeDetails(); // 입력을 받기 전에는 카페의 세부사항을 출력합니다.
			
			System.out.println("What would you like to do:");
			System.out.println("1: Rent a game, 2: return a game, 3: repair a game, 4: buy a new game, 5: save games, 0: quit program");
			int command = keyboard.nextInt();
			while(command != 1 && command != 2 && command != 3 && command != 4 && command != 5 && command != 0) // 0 ~ 5가 아닌 입력을 받았을 때에는 다시 입력을 받도록 합니다.
			{
				System.out.println("What would you like to do:");
				System.out.println("1: Rent a game, 2: return a game, 3: repair a game, 4: buy a new game, 5: save games, 0: quit program");
				command = keyboard.nextInt();
			}
			
			if(command == 1) // 1: Rent a game
			{
				System.out.println("Which game would you like to rent?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine(); // game의 이름을 입력 받아서
				cafe.rentOutGame(nameOfGame); // renting 합니다.
			}
			else if(command == 2) // 2. return a game
			{
				System.out.println("Which game would you like to return?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine(); // game의 이름을 입력 받아서
				cafe.returnGame(nameOfGame); // returning 합니다.
			}
			else if(command == 3) // 3. repair a game
			{
				System.out.println("Which game would you like to repair?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine(); // game의 이름을 입력 받아서
				cafe.repairGame(nameOfGame); // repairing 합니다.
			}
			else if(command == 4) // 4. buy a new game
			{
				System.out.println("What is the name of the game?");
				String buffer = keyboard.nextLine();
				String nameOfGame = keyboard.nextLine(); // game의 이름을 입력 받습니다.
				System.out.println("What is the price of the game?");
				double priceOfGame = keyboard.nextDouble(); // game의 price를 입력 받습니다.
				System.out.println("What is the type of the game?");
				buffer = keyboard.nextLine();
				String typeOfGame = keyboard.nextLine(); // game의 type을 입력 받습니다.
				if(priceOfGame > cafe.getMoney()) // 잔고가 부족하면 구매가 불가능합니다.
				{
					System.out.println("Not enough funds for the game");
				}
				else
				{
					if(typeOfGame.equals("Card")) // game의 type이 Card라면 CardGame의 instance를 만들어서 구매하도록 합니다.
					{
						Game newGame = new CardGame(nameOfGame, priceOfGame, 100);
						cafe.buyGame(newGame);
					}
					else if(typeOfGame.equals("Board")) // game의 type이 Board라면 BoardGame의 instance를 만들어서 구매하도록 합니다.
					{
						Game newGame = new BoardGame(nameOfGame, priceOfGame, 100);
						cafe.buyGame(newGame);
					}
					else if(typeOfGame.equals("Electronic")) // game의 type이 Electronic이라면 ElectronicGame의 instance를 만들어서 구매하도록 합니다.
					{
						Game newGame = new ElectronicGame(nameOfGame, priceOfGame, 100);
						cafe.buyGame(newGame);
					}
					else // 셋 중에 어느것에도 해당하지 않는 type이라면 에러메시지를 출력합니다.
					{
						System.out.println("Wrong type.");
					}
				}
			}
			else if(command == 5) // 5. Save games
			{
				System.out.println("What is the file you want to save?");
				String buffer = keyboard.nextLine();
				filename = keyboard.nextLine(); // 저장하고자 하는 파일의 경로를 입력받아서
				csvloader.saveGames(games, filename); // CSVLoader의 saveGames의 method를 사용해 저장합니다.
				System.out.println("Games saved succesfully.");
			}
			else if(command == 0) // 0. quit program
			{
				System.out.println("End program.");
				keyboard.close(); // Scanner 객체를 close합니다.
				break;
			}
		}
	}
}
