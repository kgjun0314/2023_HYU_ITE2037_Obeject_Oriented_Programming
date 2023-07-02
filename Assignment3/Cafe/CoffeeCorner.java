// CoffeeCorner.java

package Cafe;

import java.util.ArrayList;
import java.util.HashMap;

public class CoffeeCorner implements Observer
{
	private class CoffeeMachine extends Thread implements Observable // CoffeeMachine Inner class 입니다.
	{
		private ArrayList<Observer> observers; // observer들을 저장하기 위한 ArrayList입니다
		private int index; // CoffeeMachine이 만드는 커피의 인덱스를 나타냅니다.
		private String machineName; // CoffeeMachine의 이름입니다.
		
		public CoffeeMachine(int index, String name) // CoffeeMachine의 Constructor입니다. index, machineName, observers ArrayList를 초기화합니다.
		{
			this.index = index;
			machineName = name;
			this.observers = new ArrayList<>();
		}
		
		public void setIndex(int index) // 주문받은 커피의 인덱스를 변경해주는 메서드입니다.
		{
			this.index = index;
		}
		
		public void subscribe(Observer observer) // observer를 observers ArrayList에 추가하기 위한 메서드입니다.
		{
			observers.add(observer);
		}
		
		public void unsubscribe(Observer observer) //  observer를 observers ArrayList에서 제거하기 위한 메서드입니다.
		{
			observers.remove(observer);
		}
		
		public void run() // 스레드를 실행시킵니다.
		{
		    int progress = 0; // coffee 의 완성도는 0부터 시작하여
		    while (progress < 100) // 100 퍼센트가 되기 전까지 반복하여 증가시킵니다.
		    {
		        try {
		        	progress += 20; // 완성도를 20씩 증가시킵니다.
		        	if(progress != 100) // 100이 되기 전에는 완성도를 출력해줍니다.
		        	{	
		        		Thread.sleep(2500);
		        		System.out.println("Coffee with number: " + index + " is " + progress + "% done.");
		        	}
		        	else
		        	{
		        		Thread.sleep(2500);
		        		break;
		        	}
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		    for(Observer observer : observers) // 커피를 완성했으면 
		    {
		    	observer.update(index, machineName); // update 메서드를 통해서 완성했음을 알려줍니다.
		    }
		}
	}
	
	private int coffeeIndex;
	private HashMap<String, Double> coffeeTypes;
	private ArrayList<CoffeeMachine> machines;
	
	public CoffeeCorner(int machineAmount) // coffeeMachine의 수를 인자로 받은 CoffeeCorner Constructor입니다.
	{
		this.coffeeIndex = 0; // coffeeIndex 변수는 0으로 저장합니다.
		this.coffeeTypes = new HashMap<>(); // coffeeTypes 객체를 만듭니다.
		this.machines = new ArrayList<>(); // CoffeeMachine들을 저장할 ArrayList 객체를 만듭니다. 
		
		coffeeTypes.put("Capucino", 3.75); // HashMap으로
		coffeeTypes.put("Americano", 2.5); // 커피의 이름과
		coffeeTypes.put("Latte", 3.25); // 가격을 저장합니다.
		
		for (int i = 0; i < machineAmount; i++) // 인자로 받은 CoffeeMachine의 수 만큼 coffeeMachine을 만들고 Observer 관계를 만들고 machines ArrayList에 추가하여 줍니다.
		{
			CoffeeMachine machine = new CoffeeMachine(0, "Machine " + (i + 1));
			machine.subscribe(this);
			machines.add(machine);
		}
	}
	
	public int makeCoffee(String type) // 만들고자 하는 커피의 이름을 인자로 받습니다.
	{
		int cmidx; // CoffeeMachine의 인덱스입니다.
		double price = 0.0; // 커피의 가격을 일단 0.0으로 초기화해줍니다,
		
		try{
			price = coffeeTypes.get(type); // 커피의 가격을 HashMap을 통해서 받습니다.
		} catch(NullPointerException e) { // 존재 하지 않는 커피의 이름일 때에는 예외를 처리해줍니다.
			System.out.println("not exists coffee.");
			return -1;
		}
		
		if((coffeeIndex + 1) % machines.size() == 0) // Coffee를 만들기 위한 CoffeeMachine의 인덱스를 구하는 조건문 입니다.
		{
			cmidx = machines.size(); // ex) 커피 머신이 2대 있을때, 만들고자 하는 커피가 2(== 1 + 1) 번째 라면, 2번째 커피머신을 사용해야 하므로, 커피머신의 수인 2로 나누어 떨어진다면 2번째 커피머신을 사용합니다. 
		}
		else
		{
			cmidx = (coffeeIndex + 1) % machines.size();
		}
		
		if(cmidx == 1) // 만약 모든 한번이라도 모든 CoffeeMachine을 사용해서 커피들을 만들거나 처음으로 1번째 커피머신부터 사용을 한다면 기존에 시작되었던 스레드는 다시 시작할 수 없기 때문에
		{
			int machineSize = machines.size();
			for(int i = 0; i < machineSize; i++) // machines ArrayList에 있는 모든 machine들로부터 observer 관계를 없앱니다. 
			{
				machines.get(i).unsubscribe(this);
			}
			machines.clear(); // machines ArrayList도 비웁니다.
			for (int i = 0; i < machineSize; i++) // coffeeMachine객체들을 전부 다시 만들어 Observer관계를 만들고, machines ArrayList에 추가해줍니다.
			{
				CoffeeMachine ma = new CoffeeMachine(0, "Machine " + (i + 1));
				ma.subscribe(this);
				machines.add(ma);
			}
		}
		
		CoffeeMachine machine = machines.get(coffeeIndex % machines.size());
		
		System.out.println("The coffee is being prepared on Machine " + cmidx + "!"); // 커피를 만드는데 사용되는 커피 머신이 무엇인지 출력해줍니다.
		System.out.println("your number is: " + (coffeeIndex + 1)); // 그리고 주문한 커피가 몇 번째 커피인지 출력해줍니다.
		machine.setIndex(coffeeIndex + 1); // machine이 만드는 coffee가 몇번째 커피인지 setter 메서드로 바꿔줍니다.
		CafeManager.money += price; // 판매한 커피의 가격만큼 잔액을 증가시킵니다.
		coffeeIndex++; // 다음 주문 순서를 위해 coffeeindex를 증가시킵니다.
		
		if(coffeeIndex % machines.size() == 0) // n개의 coffeeMachine이 있을 때 n개의 주문이 들어왔다면 스레드를 실행시켜 커피를 만들어냅니다.
		{
			for(int i = 0; i < machines.size(); i++)
			{
				machines.get(i).start();
			}
		}
		
		return coffeeIndex;
	}
	
	public void listCoffeeTypes() // HashMap을 사용해서 key : value 관계인 커피 메뉴 목록을 출력합니다.
	{
		for (String type : coffeeTypes.keySet()) 
		{
			System.out.println(type + ", Price: " + coffeeTypes.get(type));
		}
	}
	
	public void update(int coffeeIndex, String machineName) // 커피가 완성되었다면 커피가 완성되었고 어떤 커피머신에서 픽업할 수 있는지 출력합니다.
	{
		System.out.println("Coffee with number: " + coffeeIndex + " is ready for pickup at " + machineName + ".");
	}
}
