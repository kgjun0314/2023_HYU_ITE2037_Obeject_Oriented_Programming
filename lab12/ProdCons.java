package lab12;

public class ProdCons 
{
	private Buffer buffer;
	private Producer[] producer;
	private Consumer[] consumer;
	
	public ProdCons() // 사이즈가 5인 Buffer 객체를 생성하고, 같은 버퍼를 공유하는 Producer, Consumer 객체를 저장하기 위한 배열을 만들고 객체를 저장해줍니다.
	{
		buffer = new Buffer(5);
		producer = new Producer[2];
		consumer = new Consumer[2];
		
		Producer prod0 = new Producer(buffer);
		Consumer cons0 = new Consumer(buffer);
		Producer prod1 = new Producer(buffer);
		Consumer cons1 = new Consumer(buffer);
		
		producer[0] = prod0;
		producer[1] = prod1;
		consumer[0] = cons0;
		consumer[1] = cons1;
	}
	
	private class Producer extends Thread 
	{
		private static int serial = 0;
		private int pNum;
		private final Buffer buffer;
		
		public Producer(Buffer buff) // buffer와 스레드의 정보를 알수 있는 pNum을 초기화해주는 생성자입니다.
		{
			this.pNum = serial++;
			this.buffer = buff;
		}
		
		public void produce() throws InterruptedException // 데이터배열에 값을 넣는 동작입니다.
		{
			for(int i = 0; i < buffer.getSize(); i++) // 버퍼의 사이즈 만큼 반복해줍니다.
			{
				System.out.println("Producer#"+this.pNum+":"+this); // Producer 스레드의 정보를 출력합니다.
				buffer.add(pNum, Math.random()*100); // 해당 스레드로 최소 0 최대 100의 크기인 난수를 데이터에 저장해줍니다.
			}
		}
		
		public void run() // 스레드를 작동시키는 함수입니다.
		{
			try {
				produce(); // produce 동작을 실행합니다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class Consumer extends Thread 
	{
		private static int serial = 0;
		private int pNum;
		private final Buffer buffer;
		
		public Consumer(Buffer buff) // buffer와 스레드의 정보를 알 수 있는 pNum을 저장해주는 생성자입니다.
		{
			this.pNum = serial++;
			this.buffer = buff;
		}
		
		public void consume() throws InterruptedException // 데이터 배열의 값을 제거하는 동작입니다.
		{
			for(int i = buffer.getSize(); i > 0; i--) // 버퍼의 사이즈 만큼 반복합니다.
			{
				System.out.println("Consumer#"+this.pNum+":"+this); // Consumer 스레드의 정보를 출력합니다.
				buffer.remove(pNum); // 해당 스레드로 데이터 배열에 있는 값 하나를 지웁니다.
			}
		}
		
		public void run() // 스레드를 작동시키는 함수입니다.
		{
			try {
				consume(); // consume 동작을 실행합니다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void startThread() // 스레드를 작동시키기 위해 스레드의 start()를 invoke합니다.
	{
		for(int i = 0; i < producer.length; i++)
		{
			producer[i].start();
			consumer[i].start();
		}
	}
}
