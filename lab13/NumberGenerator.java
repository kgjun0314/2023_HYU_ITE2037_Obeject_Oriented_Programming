package lab13;

import java.util.ArrayList;

public abstract class NumberGenerator // 수를 생성하는 추상 클래스입니다.
{
	private ArrayList<Observer> observers = new ArrayList<Observer>(); // Observer들을 저장하는 ArrayList입니다.
	
	public abstract int getNumber();
	public abstract void execute();
	
	public void addObserver(Observer observer)  // ArrayList에 observer를 추가합니다.
	{
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer)  // ArrayList에 있는 observer를 제거합니다.
	{
		observers.remove(observer);
	}
	
	public void notifyObservers() // ArrayList에 있는 observer들에게 난수가 바뀌었음을 알리기 위한 함수입니다.
	{
		for(int i = 0; i < observers.size(); i++)  // 각각의 observer들에게 접근하여 최신 난수 정보를 update 해줍니다.
		{
			observers.get(i).update(this);
		}
	}
}
