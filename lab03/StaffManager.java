package lab03;

public class StaffManager {
	
	public static void main(String[] args) {
		Staff james = new Staff("James Wright", 29, "Accounting", 365, 15);
		Staff peter = new Staff("Peter Coolidge", 32, "R&D", 1095, 7);
		Staff amy = new Staff("Amy Smith", 27);
		
		System.out.println(james);
		System.out.println(peter);
		System.out.println(amy);
		System.out.println("---");
		System.out.println("Same Carrer?");
		if(peter.sameCarrer(amy))
			System.out.printf("%s and %s, Same.\n", peter.getName(), amy.getName());
		else
			System.out.printf("%s and %s, Not exactly same.\n", peter.getName(), amy.getName());
		System.out.println("...A Few years later...");
		amy.setCarrer("R&D", 1095);
		if(peter.sameCarrer(amy))
			System.out.printf("%s and %s, Same.\n", peter.getName(), amy.getName());
		else
			System.out.printf("%s and %s, Not exactly same.\n", peter.getName(), amy.getName());
		System.out.println("---");
		james.vacation(10);
		amy.vacation(20);
		amy.vacation(1);
	}
	
}
