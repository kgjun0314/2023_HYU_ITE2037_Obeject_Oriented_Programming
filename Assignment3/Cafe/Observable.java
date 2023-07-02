// Observable.java

package Cafe;

public interface Observable // observable interface
{
	public void subscribe(Observer observer); // observer를 observers ArrayList에 추가하기 위한 abstract 메서드입니다.
	public void unsubscribe(Observer observer); //  observer를 observers ArrayList에서 제거하기 위한 abstract 메서드입니다.
}
