package lab09;

import java.util.Scanner;

public class Market 
{
	public static void main(String[] args) throws Exception
	{
		int expense;
		
		Scanner keyboard = new Scanner(System.in);
		Wallet wallet = new Wallet("my wallet");
		while(true)
		{
			try
			{
				wallet.empty();
				System.out.print("Enter price: ");
				expense = keyboard.nextInt();
				if(expense < 0)
				{
					throw new NegativeException();
				}
				else if(expense > 100)
				{
					throw new TooMuchExpenseException(expense);
				}
				else if(expense > wallet.getBalance())
				{
					throw new TooMuchExpenseException();
				}
				else
				{
					wallet.increaseIndex();
					wallet.decreaseBalance(expense);
					System.out.println("peace~~");
				}
			}
			catch(NegativeException e) 
			{
				System.out.println(e);
				System.out.println("\tat " + e.getStackTrace()[0]);
				System.out.println("oh, sorry!");
			}
			catch(TooMuchExpenseException e)
			{
				if(e.getMessage().equals("Over the limit!"))
				{
					System.out.println(e);
					System.out.println("\tat " + e.getStackTrace()[0]);
					System.out.println("you pay " + e.getInputNum());
				}
				else
				{
					System.out.println(e);
					System.out.println("\tat " + e.getStackTrace()[0]);
				}
				System.out.println("oh, my!");
			}
			catch(Exception e)
			{
				if(e.getMessage().equals("Go Home"))
				{
					System.out.println(e);
					System.out.println("\tat " + e.getStackTrace()[0]);
					keyboard.close();
					System.out.println("the end...");
					return;
				}
			}
			finally
			{
				System.out.println(wallet);
				System.out.println("---transaction complete--- \n");
			}
		}
	}
}
