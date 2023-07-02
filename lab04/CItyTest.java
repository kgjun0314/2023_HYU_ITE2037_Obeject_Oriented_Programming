package lab04;

public class CItyTest {

	public static void main(String[] args) {
		City seoul = new City("Seoul", 23, 45);
		City paris = new City("Paris", 123, 41);
		City racooncity = new City("Racoon City");
		City megacity = new City("Mega City");
		
		System.out.println(seoul);
		System.out.println(paris);
		System.out.println(racooncity);
		System.out.println(megacity);
		
		System.out.printf("%s-%s: %.14f\n", seoul.getName(), paris.getName(), City.distance(seoul, paris));
		System.out.printf("%s-%s: %.14f\n", seoul.getName(), racooncity.getName(), City.distance(seoul, racooncity));
		System.out.printf("%s-%s: %.14f\n", seoul.getName(), megacity.getName(), City.distance(seoul, megacity));
	}

}
