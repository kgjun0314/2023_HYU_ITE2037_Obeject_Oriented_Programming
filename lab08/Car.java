package lab08;
import java.time.LocalDate;

public abstract class Car 
{
	protected String name;
	protected LocalDate date;
	
	Car()
	{
		name = "Car Frame";
		date = null;
	}
	
	abstract int totalCO2();
	
	public static void main(String[] args) 
	{
		Car protoICE = new ICE();
		Car protoBEV = new BEV();
		System.out.println(protoICE);
		System.out.println(protoBEV);
		
		ICE protoType1 = new ICE("Test1", LocalDate.of(1886, 01, 29),1);System.out.println(protoType1);
		ICE newICE = new ICE("ICE1", LocalDate.now(), 800000);System.out.println(newICE);
		ICE addICE = new ICE("ICE1", LocalDate.now(), 200000);System.out.println(addICE);
		
		System.out.println(protoType1.equals(newICE));
		System.out.println(newICE.equals(addICE));
		
		BEV protoType2 = new BEV("Test2", LocalDate.of(1832, 01,01),1);System.out.println(protoType2);
		BEV newBEV = new BEV("BEV1", LocalDate.now(), 1000000);System.out.println(newBEV);
		BEV addBEV = new BEV("BEV1", LocalDate.now(), 300000);System.out.println(addBEV);
		BEV BEVplusplus = new BEV("BEV1++", LocalDate.now(), 100000);System.out.println(BEVplusplus);
		
		System.out.println(newBEV.equals(addBEV));
		System.out.println(addBEV.equals(BEVplusplus));
		
		System.out.println(protoICE.totalCO2());
		System.out.println(protoBEV.totalCO2());
	}

}
