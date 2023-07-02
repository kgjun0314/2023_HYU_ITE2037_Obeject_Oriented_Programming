package lab13;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator // 난수를 발생시키는 클래스입니다.
{
	private Random random = new Random(); // 난수를 발생시키기 위한 Random 객체를 만듭니다.
	private int number;
	
	public int getNumber() // number라는 변수를 반환하는 getter 메서드 입니다.
	{
		return this.number;
	}
	
	public void execute() // 10회 동안 number를 0 ~ 49의 난수로 변경하고 Observer들에게 알려주는 함수입니다.
	{
		for(int i = 0; i < 10; i++)
		{
			this.number = random.nextInt(50);
			notifyObservers();
		}
	}
}
