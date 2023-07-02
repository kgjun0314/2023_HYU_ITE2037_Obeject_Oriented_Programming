package lab12;

public class Buffer
{
	private int loc = 0;
	private double[] data;
	
	public Buffer(int size) // 버퍼의 사이즈를 인자로 받는 생성자 입니다.
	{
		data = new double[size]; // size라는 크기의 double형 배열을 초기화 합니다.
		System.out.println("New buffer"); // 새로운 버퍼가 생성되었음을 알리는 문구를 출력합니다.
		System.out.println(this + "\n"); // 버퍼에 있는 데이터들을 출력합니다.
	}
	
	public int getSize() // 버퍼의 사이즈를 반환하는 메서드입니다.
	{
		return data.length;
	}
	
	public synchronized String toString() // 버퍼에 있는 데이터들을 String형태로 만들어 반환합니다.
	{
		String toReturn = "";
		for(double d: data) 
		{
			toReturn += String.format("%5.2f", d) + " ";
		}
			
		return toReturn;
	}
	
	public synchronized void add(int pNum, double toAdd) throws InterruptedException // 출력예시와 같이 pNum을 출력하기 위해서 인자로 받았습니다.
	{
		while(loc >= data.length) // if문을 사용한 경우 wait()를 invoke하고 스레드를 깨웠을때 다음 코드로 넘어가지만, while문은 스레드를 깨웠을 때 조건문의 조건을 한번 더 확인하고 wait()를 invoke할 지에 대해 결정한다. 
		{
			System.out.println("Producer#"+pNum+" @ Buffer is full.\n");
			wait(); // 데이터 배열이 모두 찼을 경우 스레드를 wait 상태로 만들어 줍니다.
		}
		System.out.println("Producer#"+pNum+" Adding item on "+loc+": "+toAdd);
		data[loc++] = toAdd; // 배열에 새로운 toAdd를 추가합니다.
		System.out.println(this); // 현재 배열에 어느 값이 있는지 출력해줍니다.
		System.out.flush();
		notifyAll(); // wait 상태의 스레드를 깨웁니다.
	}
	
	public synchronized double remove(int pNum) throws InterruptedException // 출력예시와 같이 pNum을 출력하기 위해서 인자로 받았습니다.
	{
		while(loc <= 0) // if문을 사용한 경우 wait()를 invoke하고 스레드를 깨웠을때 다음 코드로 넘어가지만, while문은 스레드를 깨웠을 때 조건문의 조건을 한번 더 확인하고 wait()를 invoke할 지에 대해 결정한다. 
		{
			System.out.println("Consumer#"+pNum+" O Buffer is empty.\n");
			wait(); // 데이터 배열이 비어있을 경우 스레드를 wait 상태로 만들어 줍니다.
		}
		double temp = data[loc - 1]; // 지우고자 하는 값을 temp 변수에 저장합니다.
		System.out.println("Consumer#"+pNum+" Removing item on "+(loc - 1)+": "+temp);
		data[loc - 1] = 0.0; // 지우고자 하는 값을 0.0 으로 바꿔줍니다.
		loc--; // loc 을 감소시켜줍니다.
		System.out.println(this); // 현재 배열에 어느 값이 있는지 출력해줍니다.
		System.out.flush();
		notifyAll(); // wait 상태의 스레드를 깨웁니다.
		return temp;
	}
}
