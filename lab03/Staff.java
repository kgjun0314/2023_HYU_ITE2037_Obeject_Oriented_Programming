package lab03;

public class Staff {
	private String name;
	private int age;
	private String department;
	private int workDays;
	private int vacationDays;
	
	public Staff(String name, int age)
	{
		this.name = name;
		this.age = age;
		this.department = "None";
		this.workDays = 0;
		this.vacationDays = 20;
	}
	
	public Staff(String name, int age, String department, int workDays, int vacationDays)
	{
		this.name = name;
		this.age = age;
		this.department = department;
		this.workDays = workDays;
		this.vacationDays = vacationDays;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setCarrer(String department, int workDays)
	{
		this.department = department;
		this.workDays = workDays;
	}
	
	public boolean sameCarrer(Staff b)
	{
		return (department.equals(b.department) && workDays == b.workDays);
	}
	
	public String toString()
	{
		return ("Name: " + name + ", Age: " + age + ", Department: " + department + ", workDays: " + workDays + ", vacationDays: " + vacationDays);
	}
	
	public void vacation(int days)
	{
		if(days > vacationDays)
		{
			System.out.printf("%s, 남은 휴가 일 수 부족.\n", name);
		}
		else
		{
			vacationDays = vacationDays - days;
			System.out.printf("%s, 휴가 %d 사용. 남은 휴가 일 수: %d\n", name, days, vacationDays);
		}
	}
}
