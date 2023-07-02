package lab13;

public class PrintRandomNumber 
{
	public static void main(String[] args) 
	{
		NumberGenerator a = new RandomNumberGenerator(); // 난수를 발생시키기 위한 객체를 만듭니다.
		DigitObserver b = new DigitObserver(a); // 만든 객체를 DigitObserver와
		GraphObserver c = new GraphObserver(a); // GraphObserver에 연결해줍니다.
		a.execute(); // 난수를 발생시킵니다.
	}
}
