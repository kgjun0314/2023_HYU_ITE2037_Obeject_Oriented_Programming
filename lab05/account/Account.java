package account;
import java.time.LocalDate;

public class Account 
{
	private String name;
	private double yearlyInterest;
	private double balance;
	private LocalDate created;
	
	private LocalDate currentDate;
	private LocalDate TempDate;
	private boolean isIncreased;
	private int countDays;
	
	public Account(String name, double yearlyInterest, LocalDate created) 
	{
		this.name = name;
		this.yearlyInterest = yearlyInterest;
		this.balance = 0;
		this.created = created;
		
		this.currentDate = created;
		this.TempDate = created;
		this.isIncreased = false;
		this.countDays = 0;
	}

	public LocalDate getCreated() 
	{
		return created;
	}
	
	public void increaseYearlyInterest(int byPercent)
	{
		yearlyInterest += byPercent;
	}
	
	public double getBalance() 
	{
		return balance;
	}
	
	public void receiveIncome(double income)
	{
		balance += income;
	}
	
	public void receiveInterest()
	{
		balance += (balance * (yearlyInterest / 100) / 12);
	}
	
	public String toString()
	{
		return ("이름: " + name + ", 연이자: " + yearlyInterest + ", 잔고: " + balance + ", 가입일: " + created);
	}
	
	public LocalDate getCurrentDate()
	{
		return currentDate;
	}
	
	public Boolean getIsIncreased()
	{
		return isIncreased;
	}
	
	public int getCountDays()
	{
		return countDays;
	}
	
	public int getCreatedYears()
	{
		return created.getYear();
	}
	
	public int getCurrentYears()
	{
		return currentDate.getYear();
	}
	
	public int getCreatedMonths()
	{
		return created.getMonthValue();
	}
	
	public int getCurrentMonths()
	{
		return currentDate.getMonthValue();
	}
	
	public int getCurrentDays()
	{
		return currentDate.getDayOfMonth();
	}
	
	public void setCurrentDate(int Days)
	{
		currentDate = TempDate.plusDays(Days);
	}
	
	public void increaseMonths(int Months)
	{
		TempDate = created.plusMonths(Months);
	}
	
	public void setIsIncreased()
	{
		isIncreased = true;
	}
	
	public void setCountDays()
	{
		countDays++;
	}
}
