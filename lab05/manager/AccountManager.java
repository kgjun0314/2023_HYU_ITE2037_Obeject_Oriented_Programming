package manager;

import java.util.Random;
import java.time.DayOfWeek;
import java.time.LocalDate;

import account.*;

public class AccountManager 
{
	public static void main(String[] args) 
	{
		Random rnd = new Random();
		LocalDate created = LocalDate.of(2021, 12, 01);
		Account myAccount = new Account("Kim", 5, created);
		System.out.println(myAccount);
		
		myAccount.increaseMonths(1); // 익월 말 일부터 이자 지급 하므로 
		
		while(myAccount.getBalance() < 10000)
		{	
			Boolean flag = false;
			myAccount.setCountDays();
			myAccount.setCurrentDate(myAccount.getCountDays());
			
			LocalDate today = myAccount.getCurrentDate();
			LocalDate lastDayOfMonth = today.withDayOfMonth(today.lengthOfMonth());

			if(today.getDayOfMonth() == lastDayOfMonth.getDayOfMonth()) // 영업일 고려 
			{
				while (lastDayOfMonth.getDayOfWeek() == DayOfWeek.SATURDAY || lastDayOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY) 
				{
	                lastDayOfMonth = lastDayOfMonth.minusDays(1);
	            } // 토요일이나 일요일이면 날짜를 1일씩 빼준다. 
				// today는 말일, lastDayOfMonth는 마지막 평일. 
				flag = true;
			}
			
			if(flag)
			{
				myAccount.receiveIncome(100);
				myAccount.receiveInterest();
			}
			
			if(myAccount.getCountDays() >= 365 && myAccount.getCurrentMonths() == 1 && flag) // 가입 1년차 이상자에 한해 1월에 이벤트 진행.
			{
				int randint1 = rnd.nextInt(10);
				int randint2 = rnd.nextInt(10);
				if(randint1 == randint2)
				{
					System.out.println("이벤트 당첨!");
					myAccount.receiveIncome(100);
				}
			}
			
			if(myAccount.getCountDays() >= 365 * 3 && !myAccount.getIsIncreased()) // 가입 3년차 이상이고 이자율 증가 없었다면
			{
				myAccount.increaseYearlyInterest(2);
				myAccount.setIsIncreased();
				System.out.println("가입 후 3년이 지나서 이자율이 2% 인상되었습니다.");
			}
		}
		
		
		LocalDate today = myAccount.getCurrentDate();
		LocalDate lastDayOfMonth = today.withDayOfMonth(today.lengthOfMonth());

		if(today.getDayOfMonth() == lastDayOfMonth.getDayOfMonth())
		{
			while (lastDayOfMonth.getDayOfWeek() == DayOfWeek.SATURDAY || lastDayOfMonth.getDayOfWeek() == DayOfWeek.SUNDAY) 
			{
                lastDayOfMonth = lastDayOfMonth.minusDays(1);
            } // 토요일이나 일요일이면 날짜를 1일씩 빼준다. 
			// today는 말일, lastDayOfMonth는 마지막 평일. 
		}
		
		System.out.print(myAccount);
		System.out.print(", 1억 모으기 끝: ");
		System.out.println(lastDayOfMonth);
	}
}
