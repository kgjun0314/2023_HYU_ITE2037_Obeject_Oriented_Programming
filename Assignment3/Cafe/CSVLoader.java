// CSVLoader.java

package Cafe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVLoader 
{
	Scanner keyboard = new Scanner(System.in);
	public ArrayList<Game> loadGames(String fileName) throws Exception // Exception을 발생시키는 메서드 입니다.
	{
		ArrayList<Game> games = new ArrayList<Game>(); // Game을 저장할 ArrayList입니다.
		Scanner inputStream = null;
		String line;
		boolean isValidInput = false;
		while(!isValidInput) // 유효한 입력을 받을 때 까지 반복합니다.
		{
			try
			{	
				inputStream = new Scanner(new File(fileName));
				while(inputStream.hasNextLine()) // 모든 Line을 읽어냅니다. 
				{
					line = inputStream.nextLine();
					StringTokenizer st = new StringTokenizer(line, ", "); // CSV파일 이기 때문에 comma로 구분되어 있는 String을 분리합니다.
	                String token = st.nextToken();
	                if(token.equals("Card")) // type이 Card라면 CardGame
	                {
	                	String name = st.nextToken();
	                    String price_str = st.nextToken();
	                    String quality_str = st.nextToken();
	                    double price = Double.parseDouble(price_str);  // String 타입으로 읽은 price를 double형으로 변환해줍니다.
	                    int quality = Integer.parseInt(quality_str);  // String 타입으로 읽은 quality을 int형으로 변환해줍니다.
	                    games.add(new CardGame(name, price, quality)); // ArrayList에 객체를 추가합니다.
	                }
	                else if(token.equals("Board")) // type이 Board라면 BoardGame
	                {
	                	String name = st.nextToken();
	                    String price_str = st.nextToken();
	                    String quality_str = st.nextToken();
	                    double price = Double.parseDouble(price_str);  // String 타입으로 읽은 price를 double형으로 변환해줍니다.
	                    int quality = Integer.parseInt(quality_str);  // String 타입으로 읽은 quality을 int형으로 변환해줍니다.
	                    games.add(new BoardGame(name, price, quality)); // ArrayList에 객체를 추가합니다.
	                }
	                else if(token.equals("Electronic")) // type이 Electronic이라면 Electronic
	                {
	                	String name = st.nextToken();
	                    String price_str = st.nextToken();
	                    String quality_str = st.nextToken();
	                    double price = Double.parseDouble(price_str);  // String 타입으로 읽은 price를 double형으로 변환해줍니다.
	                    int quality = Integer.parseInt(quality_str);  // String 타입으로 읽은 quality을 int형으로 변환해줍니다.
	                    games.add(new ElectronicGame(name, price, quality)); // ArrayList에 객체를 추가합니다.
	                }
	            }
				inputStream.close();
				isValidInput = true; // 유효한 input을 받았으므로 true로 바꿔줍니다.
			}
			catch(FileNotFoundException e) // 열고자 하는 파일이 존재하지 않을 때 발생하는 예외처리입니다.
			{
				System.out.println("File Not Found.");
				System.out.println("or could not be opened.");
				if(inputStream != null)
				{
					inputStream.nextLine(); // 입력 버퍼를 비우기 위해 nextLine() 호출 (이상이 있는 파일을 읽었을 때에는 입력 버퍼를 비웁니다.)
	                inputStream.close(); // Scanner를 사용할 경우에는 close()로 파일을 닫아야 합니다
				}
				System.out.println("What is the path of the games file?");
				fileName = keyboard.nextLine();
			}
			catch(NumberFormatException e) // 옳지않은 변수 초기화가 이루어 졌을 때 발생하는 예외입니다. ex) double 또는 int형 변수에 String을 강제 형변환해서 초기화 시도 
			{
				System.out.println("Wrong data type.");
				if(inputStream != null)
				{
					inputStream.nextLine(); // 입력 버퍼를 비우기 위해 nextLine() 호출 (이상이 있는 파일을 읽었을 때에는 입력 버퍼를 비웁니다.)
	                inputStream.close(); // Scanner를 사용할 경우에는 close()로 파일을 닫아야 합니다
				}
				System.out.println("What is the path of the games file?");
				fileName = keyboard.nextLine();
			}
		}
		return games; // 배열을 return 합니다.
	}
	
	public void saveGames(ArrayList<Game> games, String fileName) throws Exception // Exception을 발생시키는 메서드 입니다.
	{
		boolean isValidInput = false;
		while(!isValidInput) // 유효한 input일 때 까지 반복합니다. 
		{
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) 
			{
	            for(int i = 0; i < games.size(); i++)
	            {
	    			if(games.get(i) instanceof BoardGame) // 해당 게임이 BoardGame의 인스턴스일 때.
	    			{
	    				String type = "Board";
	    				String name = games.get(i).getName();
	    				String price = Double.toString(games.get(i).getPrice()); // StringTokenizer로 읽을 것이기 때문에 String으로 변환합니다.
	    				String quality = Integer.toString(games.get(i).quality); // StringTokenizer로 읽을 것이기 때문에 String으로 변환합니다.
	    				writer.write(type + ", " + name + ", " + price + ", " + quality + "\n");
	    			}
	    			else if(games.get(i) instanceof CardGame) // 해당 게임이 CardGame의 인스턴스일 때.
	    			{
	    				String type = "Card";
	    				String name = games.get(i).getName();
	    				String price = Double.toString(games.get(i).getPrice()); // StringTokenizer로 읽을 것이기 때문에 String으로 변환합니다.
	    				String quality = Integer.toString(games.get(i).quality); // StringTokenizer로 읽을 것이기 때문에 String으로 변환합니다.
	    				writer.write(type + ", " + name + ", " + price + ", " + quality + "\n");
	    			}
	    			else if(games.get(i) instanceof ElectronicGame)  // 해당 게임이 ElectronicGame의 인스턴스일 때.
	    			{
	    				String type = "Electronic";
	    				String name = games.get(i).getName();
	    				String price = Double.toString(games.get(i).getPrice()); // StringTokenizer로 읽을 것이기 때문에 String으로 변환합니다.
	    				String quality = Integer.toString(games.get(i).quality); // StringTokenizer로 읽을 것이기 때문에 String으로 변환합니다.
	    				writer.write(type + ", " + name + ", " + price + ", " + quality + "\n");
	    			}
	            }
	            isValidInput = true;
	        } 
			catch(FileNotFoundException e) // 저장하고자 하는 파일이 존재하지 않을 때 발생하는 예외처리입니다.
			{
				System.out.println("File Not Found.");
				System.out.println("or could not be opened.");
				System.out.println("What is the file you want to save?");
				fileName = keyboard.nextLine();
			}
			catch(IOException e) 
			{
				System.out.println("Error writing.");
				System.out.println("What is the file you want to save?");
				fileName = keyboard.nextLine();
	        }
		}
	}
}
