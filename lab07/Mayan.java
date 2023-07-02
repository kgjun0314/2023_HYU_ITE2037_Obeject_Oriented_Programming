package lab07;

public class Mayan extends Language 
{
	public Mayan(String name, int numSpeakers)
	{
		super(name, numSpeakers, "Central America", "verb-object-subject");
	}
	
	public void getInfo()
	{
		super.getInfo();
		System.out.println("* Fun facts (TMI) : ");
		System.out.println("* 1. 마야 문명은 20진법을 사용했다.");
		System.out.println("* 2. 숫자 0을 사용한 최초의 문명이나 다른 문명에 영향을 미치지는 않았다.");
		System.out.println("* 3. 가뭄 등의 자연재해에 의해 인구의 90%가 줄어 스페인 제국이 도착하기 전 이미 멸망 직전이었고 스페인 군대에 의해 완전히 함락되었다.");
	}
}
