import java.util.Scanner;
public class Exercise8 {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int shares;
		double priceOfBuy, priceOfSell, commision, moneySpend, moneyEarned, stockbroker1, stockbroker2, total;
		System.out.println("Enter the amount of shares you intend to buy");
		shares = input.nextInt();
		System.out.println("Enter the price per share");
		priceOfBuy = input.nextDouble();
		System.out.println("Enter the price you intend to sell them on");
		priceOfSell = input.nextDouble();
		System.out.println("Enter the commision you have to pay (in decimals)");
		commision = input.nextDouble();
		
		moneySpend = shares * priceOfBuy;
		moneyEarned = shares * priceOfSell;
		stockbroker1 = moneySpend * commision;
		stockbroker2 = moneyEarned * commision;
		total = moneyEarned - (moneySpend + stockbroker1 + stockbroker2);
		
		System.out.println("You will spend: " + moneySpend + '\n' + "and if sold you will earn: " + moneyEarned + '\n' + 
				"the 1st commision: " + stockbroker1 + " and the 2nd: " + stockbroker2
				 + '\n' + "in total you will earn or lose: " + total
				);
	}
}
