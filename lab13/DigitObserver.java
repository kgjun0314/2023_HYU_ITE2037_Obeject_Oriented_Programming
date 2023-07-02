package lab13;

public class DigitObserver implements Observer
{
	private NumberGenerator num;
	
	public DigitObserver(NumberGenerator num) 
	{
		this.num = num; // 난수 발생 객체를 연결하고
		num.addObserver(this); // observer 자신을 그 객체의 observers ArrayList에 추가합니다.
	}
	
	public void update(NumberGenerator generator)
	{
		System.out.println("DigitObserver: " + generator.getNumber()); // 바뀐 난수의 값을 출력합니다.
		
		try {
			Thread.sleep(100); // Graph와 순서대로 출력하기 위해서 쓰레드를 재웁니다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
