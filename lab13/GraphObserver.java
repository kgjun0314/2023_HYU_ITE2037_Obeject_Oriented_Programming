package lab13;

public class GraphObserver implements Observer
{
	private NumberGenerator num;
	
	public GraphObserver(NumberGenerator num) 
	{
		this.num = num; // 난수 발생 객체를 연결하고
		num.addObserver(this); // observer 자신을 그 객체의 observers ArrayList에 추가합니다.
	}
	
	public void update(NumberGenerator generator) 
	{
		System.out.print("GraphObserver: ");
		
		for(int i = 0; i < generator.getNumber(); i++) // 바뀐 난수의 값만큼 *을 출력합니다.
		{
			System.out.print("*");
		}
		System.out.println("");
		
		try {
			Thread.sleep(100); // Digit과 순서대로 출력하기 위해서 쓰레드를 재웁니다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
